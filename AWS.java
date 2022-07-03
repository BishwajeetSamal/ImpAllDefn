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

  			SimpelMailMessage simpleMailMessage = new simpleMailMessage();
  			simpleMailMessage.setFrom(fromEmail);
  			simpleMailMessage.setTo(toEmail);
  			simpleMailMessage.setSubject(subject);
  			simpleMailMessage.setText(body);

  			mailService.sendMessage(simpleMailMessage);

  			return "Mail Sent Successfully";
  		} 
  	}