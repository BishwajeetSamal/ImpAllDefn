🔥🔥AMAZON SES
---------------
Search SES (Amazon Simple Email Service) //Highly Scalable inbound and outbound emial Service
It is a cloud based email service that provides cost-effective, flexible and scalable way for businesses of 
all sizes to keep in contact with their customers through email.

Create Identity
Select Email Address option and enter Email Address -> Click on create identity button and it will get verify

In springboot
-------------
package com.example.aws.springbootses.config;

@Configuration
public class SesConfiguration {
	@Value("${cloud.aws.credentials.access-key}")
	private String accessKey;
	@Value("${cloud.aws.credentials.secret-key}")
	private String secretKey;
	@Value("${cloud.aws.region.static}")
	private String region;

@Bean
public MailSender(AmazonSimpleEmailService amazonSimpleEmailService) {
	return new SimpleEmailServiceSender(amazonSimpleEmailService);

}

@Bean
public AmazonSimpleEmailService AmazonSimpleEmailService(){
	BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey,secretKey);
	return AmazonSimpleEmailServiceClientBuilder
			.standard()
			.withRegion(region)
			.withCredentials(new AWSStaticCredentialsProvider(credentials))
			.build();
}
}
----------------------------
//for pom.xml
<dependency>
<groupId>com.amazonaws</groupId>
<artifact>aws-java-sdk</artifact>
<version>1.11.327</version>
</dependency>
----------------------------------

//To get all these accessKey, secretKey and region. Go to IAM -> Access Management -> Users -> Add User ->
// Permisions -> 
---------------------------------
applications.yml
cloud:
  aws:
  	region: ap-south-1
  	auto: false
  stack:
  auto:false
  credentials:
  	access-key:AKIA...
  	secret-key:Borm...
  	-----------------------------------
  	Now Configuration is ready.

  	service.MailServiceImpl.java
  	-------------------------
	@Service
  	public class MailService{
  		@Autowired
  		private MailSender mailSender;


  		public void sendMessage(SimpelMailMessage simpleMailMessage){
  			this.mailSender.send(simpleMailMessage);
  		}

  	}

  	controller.MailController.java
  	------------------------------
  	@RestController
  	public class MailController{
  		@Autowired
  		private MailService mailService;
  		@GetMapping("/sendMail")
  		public String sendMessage(@RequestParam String fromEmail,
  			@RequestParam String toEmail,@RequestParam String subject,@RequestParam String body){

  			SimpleMailMessage simpleMailMessage = new simpleMailMessage();
  			simpleMailMessage.setFrom(fromEmail);
  			simpleMailMessage.setTo(toEmail);
  			simpleMailMessage.setSubject(subject);
  			simpleMailMessage.setText(body);

  			mailService.sendMessage(simpleMailMessage);

  			return "Mail Sent Successfully";
  		} 
  	}


  FILE UPLOAD
  ------------
  Uploads a new object to the specified Amazon S3 bucket. 
  The PutObjectRequest contains all the details of the request, including the bucket to upload to, the 
  key the object will be uploaded under, and the file or input stream containing the data to upload.
  	

  AmazonS3 -> Provides an interface for accessing the Amazon S3 web service.

  public void initialS3Bucket() {

		AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);

		s3client = AmazonS3ClientBuilder
				.standard()
				.withCredentials(new AWSStaticCredentialsProvider(credentials))
				.withRegion(region)
				.build();

	}

//upload via putObject
-----------------------
	s3client.putObject(new PutObjectRequest(bucketName, fileName, file)
					.withCannedAcl(CannedAccessControlList.PublicRead));


Generate the presigned url 
--------------------------
GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(fileType, objectKey, HttpMethod.PUT)
					.withContentType(fileType)
					.withExpiration(expiration)
					.withMethod(HttpMethod.PUT)
					.withBucketName(bucketName);


			URL url = s3client.generatePresignedUrl(generatePresignedUrlRequest);


Generate presigned url using uploadId and part Number
-------------------------------------------------------
GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(fileType, fileName, HttpMethod.PUT)
				.withContentType(fileType)
				.withExpiration(expiration)
				.withMethod(HttpMethod.PUT)
				.withBucketName(bucketName);

		generatePresignedUrlRequest.addRequestParameter("partNumber", partNumber+"");
		generatePresignedUrlRequest.addRequestParameter("uploadId", uploadId);


		Map<String, Object> repObj = new HashMap<String, Object>();

		repObj.put("preSignedUrl", s3client.generatePresignedUrl(generatePresignedUrlRequest));

CompleteMultipartUploadRequest request = new CompleteMultipartUploadRequest(bucketName, completeReq.getFileName(), completeReq.getUploadId(), partETags);

CompleteMultipartUploadResult obj = s3client.completeMultipartUpload(request);
		completeMultipartUpload //amazon S3 for assemble
**********************************code****************************************
public RestResponse generatePresignedUrlForMutlipart(String fileName, String fileType, String uploadId, int partNumber) {

		// Initialization bucket
		this.initialS3Bucket();

		java.util.Date expiration = new java.util.Date();
		long expTimeMillis = expiration.getTime();
		expTimeMillis += 1000 * 60 * 60;
		expiration.setTime(expTimeMillis);

		GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(fileType, fileName, HttpMethod.PUT)
				.withContentType(fileType)
				.withExpiration(expiration)
				.withMethod(HttpMethod.PUT)
				.withBucketName(bucketName);

		generatePresignedUrlRequest.addRequestParameter("partNumber", partNumber+"");
		generatePresignedUrlRequest.addRequestParameter("uploadId", uploadId);


		Map<String, Object> repObj = new HashMap<String, Object>();

		repObj.put("preSignedUrl", s3client.generatePresignedUrl(generatePresignedUrlRequest));

		return new DataResponse(200, "",MessageType.SUCCESS, repObj);
	}
	****************************code end******************************************

		%%%%%=================================================================================================
		*************************************************************************************************
		*"completeUpload" function after all chunks get upload and frontend requests for the assembing providing
		the partETags

		*completeReq is the list of all parts with partETags.

		@Override
	public RestResponse completeUpload( CompleteReq completeReq) {

		// Initialization bucket
		this.initialS3Bucket();

		if(completeReq.getParts()!= null && !completeReq.getParts().isEmpty()) {

			List<PartETag> partETags = new ArrayList<PartETag>();

			for(PartDto partDto : completeReq.getParts()) {
				PartETag partETag = new PartETag(partDto.getPartNumber(), partDto.geteTag());
				partETags.add(partETag);
			}

			CompleteMultipartUploadRequest request = new CompleteMultipartUploadRequest(bucketName, completeReq.getFileName(), completeReq.getUploadId(), partETags);

			CompleteMultipartUploadResult obj = s3client.completeMultipartUpload(request);

			if(completeReq.getOriginalFileName()!= null) {
				obj.setKey(completeReq.getOriginalFileName());				
			}

			if(completeReq.getUploadType() == UPLOAD_TYPE.BASE64) {

				CompletableFuture.runAsync(()-> {

					//LambdaInvokeImpl lambdaInvoker = new LambdaInvokeImpl();
					lambdaInvoker.invokeLambda(completeReq.getFileName(), completeReq.getOriginalFileName());

				});
			}

			//JSONObject resp = mapper.convertValue(obj, JSONObject.class);

			//resp.put("uploadType", completeReq.getUploadType());
			//resp.put("originalFileName", completeReq.getOriginalFileName());

			return new DataResponse(202, "Test message",MessageType.ERROR, obj);

		}else {
			return new DataResponse(404, "",MessageType.ERROR, null); 
		}
	}
	***************************************************************************************
	========================================================================================

	An Overview of AWS
	==================

	IaaS vs. PaaS
When you think about cloud computing models, IaaS and PaaS come into mind. AWS offers both.

Infrastructure as a Service (IaaS) allows organizations to utilize AWS instead of owning and operating their own datacenter. You can simply rent VMs or physical servers from AWS.

IaaS stands for Infrastructure as a Service’ the fundamental aspect here is that Amazon Web Services manages the Infrastructure for you. They own and operate the data center and give the user VMs and other services at a fractional cost to the user.

The Platform as a Service (PaaS) on the other hand removes the need for your organization to manage the underlying platforms like a database, streaming services, etc. This allows you to focus on the deployment and management of your core applications and not worry about the IaaS and PaaS layers.

PaaS in turn, gets organizations to be more efficient and focused as you don’t need to worry about resource procurement, capacity planning, software maintenance, patching, or any of the other undifferentiated heavy lifting involved in running your application.

Amazon web services infrastructure
The Amazon Web Services Infrastructure consists of four primary areas which are a combination of IaaS and PaaS:

Compute (EC2, LightSail, ECS, Lambda, Batch)
Storage (EBS, EFS, S3, Glacier, Storage Gateway, Storage Migration Services)
Database (RDS, Redshift)
Network (CloudFront, VPC, Direct Connect, Load Balancing, Route 53)
In this course we will go into the details of the various services that would fall into one of these four main buckets.

Compute
Compute(EC2): This is where you create/deploy your own virtual machine. At AWS you have a wide variety of compute instances you can choose from. This ranges from the type of operating system you would choose to the RAM or CPU you would want your compute instance to have.

Elastic Container Services(ECS): It is used to run and manage your Docker containers. You can think of it as a managed Kubernetes service.

LightSail (VPS Service – Virtual Private service): AWS Lightsail launches virtual private servers, which are VMs with individual operating systems but restricted access to physical server resources.

Lambda: Lambda lets you upload a function onto AWS and you pay every time the function is executed or called. You do not need to think about managing the OS or the VM. Lambda does it all for you.

For example, think about a tax calculator. In the traditional model, you would write the code. Procure a virtual machine to deploy your code to the VM. Then you need to maintain, manage your deployment. However, with Lambda you don’t need to pay or manage the VM, Amazon does this for you.

Batch: Batch computing is used for Batch processing. AWS Batch dynamically provisions the optimal quantity and type of compute resources (e.g., CPU vs. memory optimized instances) based on the volume and specific resource requirements of the batch jobs submitted. It also manages the batch process, i.e re-starting jobs that fail, scheduling jobs, etc.

Storage
Simple Storage Service (S3): Amazon Simple Storage Service (Amazon S3) is an object storage service offering industry-leading scalability, data availability, security, and performance. Customers of all sizes and industries can store and protect any amount of data for virtually any use case, such as data lakes, cloud-native applications, and mobile apps. With cost-effective storage classes and easy-to-use management features, you can optimize costs, organize data, and configure fine-tuned access controls to meet specific business, organizational, and compliance requirements.

Network Attached Storage (EFS): In the Elastic file System you upload your files to an EFS and then mount that onto multiple virtual machines.

Glacier: It is a storage service used for Data archival. It is primarily used to store data that you do not need to use right away. The cost of storage on Glacier is significantly lower. It takes 3 – 5 hours to restore from Glacier and it costs $0.01 per gigabyte, per month.

Snow Ball: It is used to transport a large amount of data onto AWS or to take it out of AWS and move it to your data center.

AWS ships you a hardware device that you plug into your data center and then upload your encrypted data onto the snowball (Hardware device). You will then ship it to AWS and they will upload your data onto AWS. This way you do not need to move your data through the internet as it might take months to move petabytes of data onto AWS.

Storage Gateway: It is a VM you install in your data center and this replicates data back into S3. This is used when you have an on-premises data-center and would like to replicate the data onto AWS. Once you have a Storage gateway setup you can replicate to S3 on AWS.

Database
Relational Database Service (RDS): Provides cost-efficient and resizable capacity while managing time-consuming database administration tasks, freeing you to focus on your applications and business.

Amazon RDS gives you access to several familiar database engines, including Amazon Aurora, MySQL, PostgreSQL, MariaDB, Oracle, and SQL Server. This means that the code, applications, and tools you already use with your existing databases can be used with RDS.

RDS automatically patches the database software and backs up your database, storing the backups for a user-defined retention period and enabling point-in-time recovery.

Aurora: It is an AWS proprietary relational Database that is compatible with MySQL and PostgreSQL. It combines the performance and availability of high-end commercial databases with the simplicity and cost-effectiveness of open source databases.

DynamoDB: It is a nonrelational database i.e a NoSQL DB. It is a managed service, i.e you do not need to tune or manage it in any way, AWS does this for you.

Neptune: It is a fully managed graph database. Relationships are first-class citizens in graph databases, and most of the value of graph databases is derived from these relationships. Graph databases use nodes to store data entities, and edges to store relationships between entities.

A graph in a graph database can be traversed along with specific edge types or across the entire graph. In graph databases, traversing the joins or relationships is very fast because the relationships between nodes are not calculated at query times but are persisted in the database. Graph databases have advantages for use cases such as social networking, recommendation engines, and fraud detection, when you need to create relationships between data and quickly query these relationships.

ElasticCache: It offers fully managed Redis and Memcached. Seamlessly deploy, operate, and scale popular open source compatible in-memory data stores.


Security, Identity & Compliance
==============================
Primary pillars of AWS security
Security, Identity, and Compliance are the three primary pillars of operating on AWS in a safe and secure way. Let’s look into what each of these pillars brings to the table.

IAM (Identity and Access Management)
It allows you to manage users and their levels of access to the AWS resources.

Cognition
It is used for device authentication / OAuth service. This service provides end users temporary access to AWS resources. Imagine you have an app that lets users upload pictures onto your S3. You can do this by using cognito.

Guard Duty
It is used to monitor for malicious activity on your AWS account.

Inspector
It is an agent installed on your virtual machine and you can run tests for security vulnerabilities etc.

Macie
It is used to check your entire suite of applications for personally identifiable information. It is a security service that uses machine learning to automatically discover, classify, and protect sensitive data in AWS.

Amazon Macie recognizes sensitive data such as personally identifiable information (PII) or intellectual property and provides you with dashboards and alerts that give visibility into how this data is being accessed or moved. This fully managed service continuously monitors data access activity for anomalies and generates detailed alerts when it detects the risk of unauthorized access or inadvertent data leaks.

Certificate Manager
It is used to give certificates to any domain you have registered via AWS/Routes 53. This also helps in maintaining and updating certificates that are about to expire.

Cloud HSMHardware Security Module
It is a dedicated hardware to store your hardware private and public keys, that are used to securely access your application/EC2 instances. You can also store a variety of exception keys.

Directory Services
It is used for integrating your Microsoft active directory services with AWS services.

WAF – Web Application Firewall
WAF sits in front of your web server and it mitigates against injection, cross-scripting. WAF primarily protects your application layer from any malicious attacks

Shield
You get this as a default for your load balancers, cloud front, as well as Route 53. This is basically a DDoS mitigation service that prevents DDoS Attacks.

Advance Shield
It is an AWS team that is in standby mode in the case of a DDOS attack. If you have advanced shield protection, then AWS will not charge you for any auto-scaling or added utilization of the AWS services during the attack.

Artifact
It is used for compliance and audit. Artifact gives access to AWS SOC 1, 2, 3, PCI reports, etc. It is a central resource for compliance-related information that matters to you. It provides on-demand access to AWS’ security posture.


Application Integration
========================
Overview of AWS - SQS, SNS and Amazon MQ, the three primary services that are used in modern applications to integrate with other applications or microservices.

Amazon MQ
It is a managed message broker service that makes it easy to set up and operate message brokers in the cloud.

Message brokers allow different software systems–often using different programming languages, and on different platforms to communicate and exchange information. Messaging is the communications backbone that connects and integrates the components of distributed applications, such as order processing, inventory management, and order fulfillment for e-commerce.

AWS MQ manages the administration and maintenance of ActiveMQ, a popular open-source message broker.

SNS – Simple Notification Service
It provides a low-cost infrastructure for mass message delivery for mobile users.

SQS – Simple Queue Service.

This is an Amazon-managed queuing service that makes it easy to decouple and scale microservices or distributed systems or serverless applications.

Using SQS, you can send, store, and receive messages between software components at any volume, without losing messages or requiring other services to be available.


Availability Zones & Regions
============================

What are AZs & Regions?
AWS has 16 Regions and 44 Availability Zones.

A Region is a geographically distinct area—for example, the west coast of the USA.

Availability Zones are datacenters within a region. The availability zones are fault-tolerant between each other. Each Availability Zone (AZ) has its own power and is independent of other AZ within that region.

Redundant AZs
Ideally, you design your application to be across more than one AZ that way if one AZ goes down you have another.

When designing an application you try to have redundancy between the three AZs. That way if AZ1 goes down due to a power failure, AZ2 will be alive and will not be affected and in turn, your applications and their underlying data are not affected.

Media Services
==============
Amazon Elastic Transcoder
Amazon Elastic Transcoder re-codes a particular media format to suit other media formats. Suppose you record a video in one format; the elastic transcoder re-codes the existing file for any other types of media formats that have been chosen by the user.

Kinesis Video Streams
Kinesis Video Streams make it easy to securely stream video from connected devices to AWS for analytics, machine learning (ML), playback, and other processing.

MediaTailor
MediaTailor provides the ability to insert individually targeted advertising into their video streams without sacrificing broadcasting quality.

MediaLive
MediaLive is a live video processing service that enables the creation of high-quality video streams that can be broadcasted to TVs and Internet-connected devices.

MediaPackage
MediaPackage packages and protects your video and distributes your content to a wide range of video playback devices.

MediaConvert
MediaConvert is a file-based video transcoding service with broadcast-grade features. It allows you to easily create video-on-demand (VOD) content for broadcast and multiscreen delivery.

MediaTranscoder
MediaTranscoder is used to convert (or “transcode”) media files from their source format into versions that will playback on devices like smartphones, tablets, and PCs.

S3 - Simple Storage Service
============================

Fundamentally there are two types of storage:

Object-Based Storage
Block-Based Storage
Simple Storage Service (S3) - Object-Based Storage
It provides developers and IT Teams with secure, durable, highly-scalable object storage. It is easy to use the simple web interface to store and retrieve any amount of data from anywhere on the web.

It is a place to store your files on AWS. and data is spread across multiple devices and facilities.

Think about S3 to store your photos or files.

Object based storage
Unlimited storage
Files are stored in Buckets/Folders
Names must be unique globally
Every time you have a successful upload you get a http 200 code back
S3 is primarily used for:

Store and Backup
Application File Hosting
Media Hosting
Software Delivery
Storing AMI’s and Snapshots
Data consistency Model – S3
S3 data consistency model provides strong read after write consistency for PUT and DELETE requests of objects in the S3 bucket.

Objects consist of the following:

Key – this is simply the file name of the object.
Value – the data and is made up of a sequence of bytes.
Versioning – which version of the object is this
MetaData – Additional information about the data file you are storing.
Think, if you are storing a music track/song. This would have metadata like the information of the singer, the year it was released, the name of the album, etc.

Sub resources
Access Control list – this determines whether we can access the file on S3. This can be done at the file level or at the Bucket level.
Torrent – supports the Bit torrent protocol.
Built for 99.99% availability of the S3
Durability guarantee – 99.9%… (11.9s)
Tiered storage Availability
Lifecycle management
Versioning
Encryption
Secure the data using Access control lists and Bucket policies
S3 – IA (Infrequently Accessed)
It is used for data that is accessed less frequently but requires rapid access when needed. This costs lesser than S3 but you are charged for the retrieval of the data.

S3 – RRS (Reduced Redundancy Storage)
It provides less durability with the same level of availability.

For example, this is about data you could potentially regenerate like a tax calculation or a payslip. This is cheaper. Suppose you create thumbnails for all your pictures. If you lose a thumbnail you could always regenerate it.

When deciding which storage to use think about the various storage options, their advantages vs disadvantages. Are you optimizing for durability, the frequency of retrieval, or availability?

Image comparing the various types of S3

Charging model
Storage
Number of requests
Storage Management Pricing
Add metadata to see usage metrics.
Transfer Acceleration - Enables fast, easy and secure transfers of your files over long distances between your end-users and an S3 bucket.

Transfer acceleration takes advantage of Amazon cloud front’s globally distributed edge locations. As the data arrives at an edge location, the data is routed to Amazon S3 over an optimized network path.

Think of transfer acceleration as a combination of S3 and CDN natively supported by this Service. Basically, every user ends up going through the closest possible edge location which in turn talks to the actual S3 bucket.

Recap - S3
S3 Storage Classes

S3 (Durable, immediately available and frequently accessed)
S3 – IA (durable, immediately available, infrequently accessed)
S3 Reduced Redundancy Storage (Used for data that is easily reproducible, such as thumbnails)
Core fundamentals of S3 objects

Key: Name of the object these are stored in alphabetic order
Value: The data itself
Version ID: The version of the object
Meta Data: The various attributes of the data
Sub resources

ACL: Access control lists
Torrent: bit Torrent protocol
Cross-region Replication

This basically means that if you have this turned on then for a bucket AWS will automatically make a bucket available across 2 or more regions.


Securing your S3 Buckets
By default, all buckets are private
You can set up access control for your use
Bucket Policies
Access control lists (ACL)
S3 buckets can be configured to create access logs
Encryption for S3
In-transit
SSL/TLS (using HTTPS)
At Rest
Server-Side Encryption
S3 Managed keys – SSE-S3
Server-side Encryption
Key Management Service – Managed Key
SST – KMS
Client-Side Encryption

Lambda - Serverless Architecture
================================

What is Lambda?
The evolution or timeline of Lambda looks something like this:

On-Prem DataCenter –> IAAS –> PaaS –> containerization/Docker –> Serverless

Lambda is a compute service where you can upload your code and create a Lambda function. AWS Lambda takes care of provisioning and managing the servers that you use to run the code. You do not have to worry about operating systems, patching, scaling etc.

It is essentially described as an event-driven compute service where AWS Lambda runs your code in response to events. These events could be changes to the data in an Amazon S3 bucket or an Amazon Dynamo DB table.

Lambda events can trigger other Lambda events or call other AWS services like SQS or SNS.

Why use Lambda?
The Lambda runtime is fully managed by AWS. Once a function is uploaded and configured, Lambda is responsible for managing the resources required to run the code.
Developers are free from the traditional overhead of configuring and maintaining server instances.
Lambda will immediately scale to meet spikes in demand.
Lambda is cost-effective as you only pay for the computational resources used. This is, of course, true for other AWS compute services, but the cost model for Lambda is more granular than EC2 for example, with resources being charged per 100 milliseconds.
Lambdas event-driven model means you can integrate nicely with a range of AWS services, but still ensure loose coupling.
It’s very low cost. The first 1 million requests are free and you have to pay 0.20 per 1 million requests thereafter!!
Lambda architecture#

Let’s describe the various components in the above Architecture:

Angular Client allows the user to add and delete images from S3. It also calls an API Gateway endpoint to retrieve details for all images uploaded.

Save/Delete Lambda Function will handle image upload and delete events from S3. It will be invoked by S3 when a new image is uploaded - the function will use the supplied event data to call back to S3 and retrieve the image. The image details will be saved to DynamoDB. As an image is deleted the function will use the supplied event data to identify the deleted image and remove the associated details from DynamoDB.

Retrieve Image Details: Lambda Function will retrieve image details from DynamoDB and return JSON results.

Dynamo DB: a single Dynamo DB table will be used to persist image details. All interactions with DynamoDB will happen via the Lambda functions.

API Gateway: an API Gateway endpoint will be used as a bridge to the Retrieve Image Details and Lambda function from the web app.

That should give you a good overview of how Lambda functions work. Also, note that some cloud providers call this “Function as a Service” FaaS.

Elastic Load Balancers (ELB)
=============================

Elastic Load Balancers
This is a virtual appliance that is used to distribute traffic across multiple application instances.

Instances are checked by the Load Balancers (LB) and they re-route the traffic if they find an application is not returning any data back.

All AWS Load Balancers have their own DNS name.

Cloud Watch
Cloud Watch is used for:

Monitoring and setting up alarms that notify the user if an AWS threshold is hit.

Events in cloud watch help you to respond to a state change of your resources.

Cloud watch Logs – helps you aggregate monitor and store logs. This is done by installing an agent on your EC2 server.

CloudTrail
Audits what is created or modified in terms of AWS infrastructure.

Elastic Load-balancing Across Two Availability Zones
Elastic Load-balancing Across Two Availability Zones
EC2 Placement Groups
Logical grouping of instances within a single availability zone. You can have placement groups that enable applications to participate in low latency, 10 Gbps networks.

Placement groups are recommended for applications that benefit from low latency and high network throughput or both.

Take for example a Hadoop cluster or a NoSQL database where you need really high network throughput or low latency between your NoSQL DB nodes.