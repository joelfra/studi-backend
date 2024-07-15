pipeline {
    agent any

    environment {
        mavenhome = tool 'jenkins-maven'
        imageName = "studi-backend"
        credentialsID = "aws-jenkins"
        accessKeyVariable = 'AWS_ACCESS_KEY_ID = credentials'
        secretKeyVariable = 'AWS_SECRET_ACCESS_KEY_ID'

        /*
        registryCredentials = "nexus"
        registry = "localhost:9001/"
        */
        dockerImage = ""
    }
    tools {
        jdk 'jenkins-java'
    }

    stages {
        stage('Build') {
            steps {
                bat 'mvn clean -DskipTests install'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
        stage('Build image') {
            steps {
                script {
                    dockerImage = docker.build imageName
                }
            }
        }
        stage('Deploy Image') {
            steps {
                script {
                    def dockerCmd = "docker run -d -p 8080:8080 ${imageName}"
          withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', credentialsId: 'aws-jenkins', 
                accessKeyVariable: 'AWS_ACCESS_KEY_ID',
                secretKeyVariable: 'AWS_SECRET_ACCESS_KEY' ]]) {
                    bat 'aws ecr get-login-password --region eu-west-3 | docker login --username AWS --password-stdin 767398121285.dkr.ecr.eu-west-3.amazonaws.com'
                    bat 'docker login -u AWS -p ${AWS_SECRET_ACCESS_KEY_ID} ${AWS_ACCESS_KEY_ID}'
                    bat 'docker push ${imageName}'
                }
                         }
            }
        }
        }
    }
}