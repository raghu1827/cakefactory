# CakeFactory - E-commerce Website Deployment Project

## Project Overview
CakeFactory is a full-fledged e-commerce application built using Spring Boot for backend services, MariaDB for the database, and hosted on Amazon Linux 2023 servers in the AWS EC2 environment. This project showcases expertise in DevOps and full-stack development by deploying a scalable, production-ready web application.

---

## Table of Contents
- [Technologies Used](#technologies-used)
- [Features](#features)
- [Setup Instructions](#setup-instructions)
- [CI/CD Integration](#cicd-integration)
- [Database Setup](#database-setup)
- [Deployment Process](#deployment-process)
- [Monitoring & Security](#monitoring--security)
- [Key Takeaways](#key-takeaways)

---
## Technologies Used
- **Spring Boot**: Backend framework for building the REST API.
- **MariaDB/MySQL**: Database engine for storing user and order data.
- **AWS EC2**: Cloud hosting for scalable infrastructure.
- **Amazon Linux 2023**: Operating system for the EC2 instance.
- **Docker**: For containerizing the Spring Boot application.
- **Jenkins**: For automating the CI/CD pipeline.
- **Maven**: For managing project dependencies.
- **SSL**: For secure HTTP traffic.
- **CloudWatch**: AWS monitoring service for application performance.

---

## Features
- **User Registration & Authentication**: Secure sign-up and login.
- **Product Browsing**: View cakes, details, and manage shopping cart.
- **Order Management**: Place orders and view order history.
- **Admin Panel**: Manage products, orders, and users.
- **Real-time Notifications**: Updates on order statuses.
- **Responsive UI**: Optimized for desktops and mobile devices.

---

## Setup Instructions
### Prerequisites
- **Java 11+**: Ensure Java is installed (`java -version`).
- **Maven**: Install Maven to build the project.
- **Docker**: Install Docker to containerize the application.
- **AWS Account**: For deploying the application on EC2.

### Steps to Set Up Locally
1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/cakefactory.git
   cd cakefactory
   ```
2. **Build the Spring Boot application**:
   ```bash
   mvn clean install
   ```
3. **Run the application locally**:
   ```bash
   mvn spring-boot:run
   ```

### Docker Setup (Optional)
1. **Build Docker image**:
   ```bash
   docker build -t cakefactory .
   ```
2. **Run Docker container**:
   ```bash
   docker run -p 8080:8080 cakefactory
   ```

---

## CI/CD Integration
### Jenkins Pipeline
#### Continuous Integration:
- Automates build processes whenever changes are pushed to the repository.
- Builds the Spring Boot application and runs unit tests.

#### Continuous Deployment:
- Automatically deploys the application to AWS EC2 upon successful build.
- Docker containers ensure consistency across environments.

### Steps to Set Up Jenkins:
1. Install Jenkins on your local or cloud server.
2. Create a new pipeline project and link it to this repository.
3. Configure the pipeline to trigger on push events.

---

## Database Setup
1. **Create Database**:
   ```bash
   mysql -u root -p
   CREATE DATABASE cakefactory;
   ```
2. **Create User**:
   ```sql
   CREATE USER 'cakeuser'@'%' IDENTIFIED BY 'Admin#123';
   GRANT ALL PRIVILEGES ON cakefactory.* TO 'cakeuser'@'%';
   FLUSH PRIVILEGES;
   ```
3. **Configure Database Connection**:
   Update `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/cakefactory
   spring.datasource.username=cakeuser
   spring.datasource.password=Admin#123
   ```

---

## Deployment Process
1. **Launch EC2 Instance**:
   - Create an Amazon Linux 2023 EC2 instance on AWS.
2. **SSH into Instance**:
   ```bash
   ssh -i your-key.pem ec2-user@your-ec2-public-ip
   ```
3. **Install Java and Docker**:
   - Install Java:
     ```bash
     sudo yum install java-11-openjdk-devel
     ```
   - Install Docker:
     ```bash
     sudo yum install docker
     sudo service docker start
     sudo usermod -aG docker ec2-user
     ```
4. **Deploy Application**:
   - Copy the built `.jar` file or Docker image to the EC2 instance.
   - Run the application using Docker:
     ```bash
     docker run -p 8080:8080 cakefactory
     ```

---

## Monitoring & Security
### SSL Configuration:
- Secure the application with SSL certificates for encrypted traffic.

### CloudWatch Monitoring:
- Monitor application performance, uptime, and issues using AWS CloudWatch.

### Security Measures:
- Configure AWS firewalls and security groups to allow only necessary traffic.
- Use IAM roles for access management.

---

## Key Takeaways
- Gained hands-on experience with AWS EC2 and Amazon Linux 2023.
- Integrated MariaDB for secure data handling.
- Implemented CI/CD with Jenkins for automated builds and deployments.
- Secured the application using SSL and monitored performance with CloudWatch.

