# Dockerfile for Spring Boot App
FROM openjdk:17-jdk
VOLUME /tmp
COPY target/rateshop-0.0.1-SNAPSHOT.jar rateshop-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/rateshop-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080
