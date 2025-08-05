# Use a slim version of OpenJDK 21 for a smaller image size
FROM openjdk:21-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled JAR file from your target folder into the container
# IMPORTANT: Replace 'your-service-name-0.0.1-SNAPSHOT.jar' with the actual JAR file name
# You can find this name in the 'target' folder after building
COPY target/*.jar app.jar

# Expose the port that this specific service runs on
# Example for PRODUCT-SERVICE:
EXPOSE 8083

# The command to run your application when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]
