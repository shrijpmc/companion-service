FROM openjdk:8-jdk-alpine

EXPOSE 9092

ADD target/companion-service.jar companion-service.jar

ENTRYPOINT ["java","-jar","companion-service.jar"]