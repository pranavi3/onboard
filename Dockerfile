# Use the official OpenJDK base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the target directory to the working directory in the container
COPY ./target/onboard-0.0.1-SNAPSHOT.jar ./app.jar

# Run the application
CMD ["java", "-jar", "app.jar"]
