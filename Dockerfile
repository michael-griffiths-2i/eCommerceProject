# Use an official Maven image to build the project
FROM maven:3.8.6-openjdk-11 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml file and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the rest of the project files
COPY src ./src

# Package the application
RUN mvn package

# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the packaged jar file from the build stage
COPY --from=build /app/target/test-1.0-SNAPSHOT.jar ./test.jar

# Run the application
ENTRYPOINT ["java", "-jar", "test.jar"]
