FROM eclipse-temurin:17-jdk-alpine

LABEL maintainer="Paz P&D - Auth_API"

VOLUME /tmp

COPY target/*.jar auth-api-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/auth-api-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080