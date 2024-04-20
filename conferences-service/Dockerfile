FROM openjdk:11
VOLUME /tmp
EXPOSE 8002
ADD ./target/conferences-service-0.0.1-SNAPSHOT.jar conferences-service.jar
ENTRYPOINT ["java","-jar","/conferences-service.jar"]