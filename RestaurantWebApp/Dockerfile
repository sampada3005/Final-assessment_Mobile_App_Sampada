FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY target/restaurant_app_jar.jar .
EXPOSE 8081
CMD ["java", "-jar", "restaurant_app_jar.jar"]