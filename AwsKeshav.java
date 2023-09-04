

5. AWS***********************************************************************************************


Basic steps to deploy project
    Create ec2 instance 
    download pem file and do ssh
    setUp Nginx
    install java
    install database
    clone project from git 
    build by mvn clean install
    run this build file 
    NoHup command is used for running
    java -jar fileName 
    this can also be used but it will be like running docker without -d
    thats why we use nohup
    jis port par server chal rha he usko publicc karte he taki sab usko access kr ske
    we can create elastic ip
    like if the server is updated or restarted or due to any reason
    out ip address is changed then this elastic ip will remian 
    samne and will help us to access our instance







creating an ec2 instance
     go to console
     in service 
     compute 
     ec2 link
     launch instance here 
     here 7 steps are there
     select operating system.........which are we using
     chose instance type (configurarion of application)t2nano t2.micro....?? 
     configure instance details here select custom cunfiguration like number of instance   
     select storage in gb 
     add tags like spring boot or micro service or react helps in idntifiynong projects easily
     configure security group ?? with port no.
     review and launch
     here create a pair or key pair an download it --.pemfile
  
       this pem file is used to connect to ec2 instance 
       use this file 
       contains host info username and everything
       
       now click on launch 
       go to instances here you will find the 
       instance you lauched as running 
     now you can give it a name 
    


creating an S3 Bucket 
      console 
      storage 
      S3 bucket
      create bucket 
      give name
      allow publicc access 
      create a bucket
      here you can upload files 
      or you can create folder sturcture
      upload can work by drag and drop 
      now upload jar here 
      and make it publicc
      copy url this will help to get from ec2 intance 
       even if bucket is publicc still we need to make jar public 
      if we upload anything then we get signed url which can be used to downlaod the file
    

 Connecting to an created ec2 instance
      USING WINDOWS
       putty tool 
       puttygen
       to convert the .pem file and save privatee key here 
       now this key will help in communicating with ec2
       not oepn putty tool 
       now open ec2 on aws console 
       now click on connect to get all the details 
       copy host name 
       give username 
       in ssh  
       auth 
       brows and upload key pair file 
       now open and open
       now it is connected to the server
      USING MAC OR UBUNTU
       
    

deploy springboot application in ec2 instance
      create the app spring boot 
      run
      mvn clean install 
      maven should be installed
      clean delete all previous compiled.class files
      insall will compile and test and... your project
      this will create the jar of the application
      build is created in target folder    
    
       now connect to ec2 then

      install java now
      install maven set up the entire environment
      now follow s3 bucket 
      now use 
      wget and copy the jar url
      it will get downloaded
      now java -jar filename.jar
      nohup java -jar.... 
      now our program will get started 
      now get the ip address from aws console 
      copy paste ip and give port wwe will get the response




    
     


EC2 amazone RDS 
    One     
            use cloud database
            postgres 
            mariadb 
            amazone aurora
            etc..
        
            create my sql instance in aws console
            RDS 
            databases 
            Create an databse 
            select appropriate database
            select version
            give identifier 
            use ursename and password
            additional connectivity configuration 
            publicc access select yes
            create database name 
            now select create databse
          now our db instance is running 
          now copy enpoint of this database instance
          and put this endpoint in 
          spring.datasource.url = copied endpoint
         port is same in properties and 
        
          go to security now in the intance created 
          select security id and select 
          edit inbound rules
          add custom rule and add security
        
          now ready to use database is available
          connecting to rds
          gotoo myswl workbench
          and create connection and pul all details from the instance
          done it is 
          copy the endpoint in springboot application also
        
        
        
        
          elastic beanstalk
          set up database and upload jar and we get ready to use application

    Two
          



uploading on s3 using backend 
     put all required credentials in properties 
     like bucket name accsee key secret key
     get all this from aws console+
     load all in config file using @value
     @Configuration
     public class AmazonConfig {
      @Bean
      public AmazonS3 s3() {
        AWSCredentials awsCredentials =
                new BasicAWSCredentials("accessKey", "secretKey");
        return AmazonS3ClientBuilder
                .standard()
                .withRegion("ap-south-1")
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();

                }
            }
      now 
      @AutoWired 
      AmazoneS3 s3Client;
    
      s3Client.putObject(bucketName,fileName,File file)
      S3Object s3Object = s3Client.getObject(BucketName,FileName);
      s3Client.deleteObject(bucketName , fileName)
    
      here file can be in multipart and we may need to convert into 
      one file uskinf FileOutPutStream 
      delete after uploading the file
      fileObj.delete();
    
     S3Object s3Object = s3Client.getObject(BucketName,FileName);
     S3ObjectInputStream = s3Object.getObjectContant();
     byte[] content = IOUtils.toByteArray(S3ObjectInputStream)
     s3Client.deleteObject(bucketName , fileName)





AWS MAIL SERVICE SES 
     ses simple email servuce
     create identity 
     regirtsr your email and vairfy it   
     create a IAM user
     ALLOW AmazoneSESFullAccess
     Administrator access permissions
     creating this we will get the access key and secret key

     public MailSender mailSender(AmazoneSimpleMailService amazoneSimpleMailService)
       {
         return new SimpleEmailServiceMailSender(amazoneSimpleMailService);
       }
     publicc AmazoneSimpleEmialService amazone..(){
       BasicAwsCredentials ... = new Basic...(accesskey, secet ket)
       return AmazoneEmialServoceClientBulider....build();
    }
  
for normal mails
      @Autowired
      MailSender mailSender
    
    
      mailSender.send(simpleMailMessage);
    
      SimpleMailMessage simpleMailMessage = new SimpleMai..();
    simpleMailMessage.setFrom()
    .setTo();
    .setSubject();
    .setText();

for template mail
      destination.setToAddresses(toAddresses);
      SendTemplatedEmailRequest templatedEmailRequest = new SendTemplatedEmailRequest();
      templatedEmailRequest.withDestination(destination);
      templatedEmailRequest.withTemplate(templateName);
      templatedEmailRequest.withTemplateData(templateData);
      templatedEmailRequest.withSource(from);
      client.sendTemplatedEmail(templatedEmailRequest);
      return "email sent";





S3 bucket presignedUrl
   
    FOR SIMPLE UPLOAD
       public String generatePreSignedUrl(String filePath,String bucketName,HttpMethod httpMethod) 
          {
              Calendar calendar = Calendar.getInstance();
              calendar.setTime(new Date());
              calendar.add(Calendar.MINUTE, 10); //validity of 10 minutes
              return amazonS3.generatePresignedUrl(bucketName, filePath, calendar.getTime(), httpMethod).toString();
          }

  
        File file = convertMultiPartToFile(multipartFile);
    
    FOR MULTIPART UPLOAD

        first call statrt upload 
        this will initilize the upload

        then call getPreSignedUrlForMultipart
          GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(fileType, fileName, HttpMethod.PUT)
          .withContentType(fileType)
          .withExpiration(expiration)
          .withMethod(HttpMethod.PUT)
          .withBucketName(bucketName);
          generatePresignedUrlRequest.addRequestParameter("partNumber", partNumber+"");
          generatePresignedUrlRequest.addRequestParameter("uploadId", uploadId);


        now call completeUpload 
        this will invoke lambda expression of aws to merge all the chunks
