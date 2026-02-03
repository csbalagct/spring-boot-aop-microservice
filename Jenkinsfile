pipeline {
    agent any

    environment {
        APP_NAME = "spring-boot-app"
        JAR_NAME = "build/libs/spring-boot-aop-microservice-0.0.1-SNAPSHOT.jar"
        PORT = "8080"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/csbalagct/spring-boot-aop-microservice.git'
            }
        }

        stage('Build') {
            steps {
                // Use Gradle wrapper if available
                bat './gradlew clean build -x test'
            }
        }

         stage('Deploy') {
            steps {
            bat '''
            docker build -t springboot-aop-app .
            docker stop springboot-aop-app || echo "No container to stop"
            docker rm springboot-aop-app || echo "No container to remove"
            docker run -d --name springboot-aop-app -p 8080:8080 springboot-aop-app
            '''
            }
        }
    }

    post {
        success {
            echo "✅ Deployment successful!"
        }
        failure {
            echo "❌ Deployment failed!"
        }
    }
}
