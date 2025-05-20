FROM maven:3.9.6-amazoncorretto-21

WORKDIR /opt/apps

COPY target/*.jar ./payments-service.jar

CMD ["java", "-jar", "payments-service.jar"]