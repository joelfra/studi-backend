pipeline {
    agent any

    environment {
        mavenhome = tool 'jenkins-maven'
        imageName = "demo"
        registryCredentials = "nexus"
        registry = "localhost:9001/"
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
        stage('Deploy') {
            steps {
                script {
                docker.withRegistry("http://"+registry, registryCredentials) {
                    dockerImage.push('latest')
                }

                }
            }
        }

    }
}