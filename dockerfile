FROM eclipse-temurin:22-jre
WORKDIR /app
COPY target/proyectoSiga-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

