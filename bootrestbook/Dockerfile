# Use Java 21 for ARM64 Mac
FROM eclipse-temurin:21-jdk-jammy


# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy the JAR file into the container
COPY target/bootrestbook-0.0.1-SNAPSHOT.jar app.jar



# Step 4: Expose the port your Spring Boot app runs on
EXPOSE 8080

# Step 5: Define the command to run your JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
