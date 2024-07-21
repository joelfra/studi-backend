

# Getting Started with a SpringBoot App

### `mvn spring-boot:run`
Runs the app in the development mode.\


# Getting Started with Docker

###  `docker build -t studi-backend`
Builds the app in docker desktop

###  `docker run -p 8080:8080 -t studi-backend`
run the app in localhost with the port 8080


### Scripts CodeDeploy to suppply a EC2 instance 

tree
├── Scripts
│   ├── BeforeInstall.sh  
│   └── AfterInstall.sh 
│
|── appspec.yml         : CodeDeploy
│── buildspec.yml       : CodePipeline

