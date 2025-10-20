FROM openjdk:21-slim
WORKDIR /app
COPY target/producer-*.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]