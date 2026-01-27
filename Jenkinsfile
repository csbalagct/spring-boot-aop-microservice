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
            bat "start java -jar build\\libs\\spring-boot-aop-microservice-0.0.1-SNAPSHOT.jar"
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
