# Use a lightweight JDK base image
FROM eclipse-temurin:25-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the Spring Boot fat JAR
COPY build/libs/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]