FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

COPY build/libs/*.jar app.jar

RUN useradd -n springuser && chown -R springuser /app
USER springuser

EXPOSE 80

ENTRYPOINT ["java", "-jar"]