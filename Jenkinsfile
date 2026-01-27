pipeline {
    agent any

    environment {
        APP_NAME = "spring-boot-app"
        JAR_NAME = "build/libs/${APP_NAME}.jar"
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

stage('Stop Existing App') {
    steps {
        script {
            bat """
            for /f "tokens=5" %%a in ('netstat -ano ^| findstr :%PORT%') do taskkill /PID %%a /F
            """
            echo "Stopped process on port %PORT% if it was running"
        }
    }
}

        stage('Deploy') {
            steps {
                bat "nohup java -jar ${JAR_NAME} > app.log 2>&1 &"
                echo "Spring Boot app deployed and running on port ${PORT}"
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
