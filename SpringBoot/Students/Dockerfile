# Use lightweight Java runtime
FROM eclipse-temurin:24-jdk-alpine

# Set working directory
WORKDIR /app

# Copy jar
COPY target/*.jar app.jar

# Run application
ENTRYPOINT ["java","-jar","app.jar"]