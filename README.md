# AWS-Service:- EC2, S3, RDS, IAM, VPC, Lambda, CloudWatch, SNS, SQS, ECS& EKS, Fargate
1. Amazon EC2 (Elastic Compute Cloud) is a core AWS service that provides scalable virtual servers in the cloud. It's used to host web applications, backend services, and enterprise software. 

2. Amazon S3 (Simple Storage Service) is a highly durable and scalable object storage service. It's commonly used to store static assets like images, videos, backups, logs, and big data for analytics. Many companies also use S3 to host static websites or implement secure file sharing. 

3. Amazon RDS (Relational Database Service) is a fully managed service for setting up, operating, and scaling relational databases such as MySQL, PostgreSQL, SQL Server, and Oracle. It helps eliminate manual tasks like backups, patching, and failover handling

4. AWS IAM (Identity and Access Management) enables you to manage access to AWS resources securely. It allows you to create and manage AWS users and groups, and use permissions to allow or deny their access to resources.

5. Amazon VPC (Virtual Private Cloud) allows you to create a logically isolated network in AWS where you can define your IP address ranges, subnets, route tables, and gateways. It’s essential for securely hosting web apps, databases, and internal services.

6. AWS Lambda is a serverless compute service that lets you run code in response to events without provisioning or managing servers. It’s widely used for event-driven applications such as responding to file uploads in S3, triggering workflows from API Gateway, and processing stream data from DynamoDB or Kinesis.

7. Amazon CloudWatch is a monitoring and observability service that provides data and actionable insights for AWS, hybrid, and on-premises applications. It’s used to collect and track metrics, monitor log files, set alarms, and automatically react to changes in your environment, such as triggering auto-scaling or sending notifications on errors.

8. Amazon SNS (Simple Notification Service) is a fully managed pub/sub messaging and mobile notification service. It allows systems and applications to send time-critical messages to multiple subscribers via email, SMS, or Lambda.

9. Amazon SQS (Simple Queue Service) is a fully managed message queuing service used to decouple and scale microservices, distributed systems, and serverless applications. It enables asynchronous communication between components, ensuring reliable message delivery even when the receiving component is temporarily unavailable.

10. Amazon ECS (Elastic Container Service) is a highly scalable, fast container management service that makes it easy to run, stop, and manage Docker containers on a cluster of EC2 instances or using Fargate (serverless containers). ECS is ideal for running microservices architectures, APIs, and batch processing jobs.

11. Amazon EKS (Elastic Kubernetes Service) is a managed service for running Kubernetes on AWS without needing to install, operate, and maintain your own Kubernetes control plane. EKS is used for orchestrating containerized applications, enabling high availability, scalability, and integration with AWS networking and security services.

12. AWS Fargate is a serverless compute engine for containers that works with both Amazon ECS (Elastic Container Service) and Amazon EKS (Elastic Kubernetes Service). It allows you to run containers without provisioning, configuring, or managing the underlying virtual machines.


## Deploy Spring boot application on EC2
- Launch EC2 Instance
- Launch a new EC2 instance (Amazon Linux 2 or Ubuntu preferred)
- Select a key pair (or create one) for SSH access.
- Connect to EC2 via SSH(Use the following SSH command to connect to your instance)
```
  ssh -i /path/to/your-key.pem ec2-user@<public-ip-address>
```
- Since the project is hosted on GitHub, install the Git client 
```
sudo yum install git -y
```
- Clone the GitHub repository
```
git clone ---https-url----
cd your-repository-name
```
- install maven and java(on EC2 machine to build and run)
```
sudo yum install maven -y
```
- mvc clean package (package project in jar file)
```
java -jar target/project-name
```
- Go to the Security Group associated with your EC2 instance.
- Edit Inbound Rules and allow Custom TCP on port 8080 (or whichever your app uses) from Anywhere (0.0.0.0/0).
- Obtain the public IP address of your EC2 instance and use it to access your application in a web browser
