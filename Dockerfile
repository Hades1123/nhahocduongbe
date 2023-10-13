FROM openjdk:17-jdk-alpine3.14
COPY target/api-0.0.1-SNAPSHOT.jar /nhd.jar
CMD ["java", "-jar", "nhd.jar"]