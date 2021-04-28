FROM openjdk:11-jdk-slim-buster
COPY ./target/playerservice-0.0.1-SNAPSHOT.jar /usr/app/playerservice.jar
WORKDIR /usr/app
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "playerservice.jar" ]
