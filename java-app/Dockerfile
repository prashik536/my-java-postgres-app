# Use an official Maven image to build the app
FROM maven:3.8.4-openjdk-11-slim AS build

WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src /app/src
RUN mvn package

# Use OpenJDK to run the app
FROM openjdk:11-jre-slim

WORKDIR /app
COPY --from=build /app/target/my-java-app.jar /app/my-java-app.jar

ENTRYPOINT ["java", "-jar", "/app/my-java-app.jar"]
