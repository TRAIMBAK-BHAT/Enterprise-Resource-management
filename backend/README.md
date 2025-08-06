# Use an OpenJDK base image with Gradle installed
#FROM gradle:7.6.0-jdk17 AS builder
#FROM gradle:8.5.0-jdk17 AS builder
FROM gradle:8.5.0-jdk21 AS builder

ENV GRADLE_OPTS="-Xms128m -Xmx512m -Dorg.gradle.daemon=false"

WORKDIR /app

# Copy project files
COPY . .
RUN echo "Checking application.yml:" && cat src/main/resources/application.yml


# Build the app (builds jar)
RUN gradle clean build --no-daemon -x test

# Run stage
#FROM openjdk:17-jdk-slim
FROM eclipse-temurin:21-jdk AS runtime

WORKDIR /app

# Copy the built jar from builder stage
COPY --from=builder /app/build/libs/*-all.jar /app/app.jar

# Expose port 8080
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
