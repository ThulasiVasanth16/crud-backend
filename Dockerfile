FROM openjdk:21-jdk-slim

WORKDIR /app

COPY target/CrudBackEnd-0.0.1-SNAPSHOT.war app.war

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.war"]
