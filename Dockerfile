FROM eclipse-temurin:17-jdk-alpine
EXPOSE 80:8080
COPY target/microservice-with-angular-0.0.1-SNAPSHOT.jar microservice-with-angular-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","microservice-with-angular-0.0.1-SNAPSHOT.jar"]