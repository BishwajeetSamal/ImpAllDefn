AMAZON SES
-----------
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