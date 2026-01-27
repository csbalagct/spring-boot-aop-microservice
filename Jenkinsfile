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
                sh './gradlew clean build -x test'
            }
        }

        stage('Stop Existing App') {
            steps {
                script {
                    // Kill any process running on port 8080
                    def pid = sh(script: "lsof -ti:${PORT}", returnStdout: true).trim()
                    if (pid) {
                        sh "kill -9 ${pid}"
                        echo "Stopped running Spring Boot app on port ${PORT}"
                    } else {
                        echo "No app running on port ${PORT}"
                    }
                }
            }
        }

        stage('Deploy') {
            steps {
                sh "nohup java -jar ${JAR_NAME} > app.log 2>&1 &"
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
