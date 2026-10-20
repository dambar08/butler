FROM node:24-bookworm-slim AS node-runtime

FROM eclipse-temurin:25-jdk AS build

COPY --from=node-runtime /usr/local/ /usr/local/

WORKDIR /workspace

COPY gradlew settings.gradle build.gradle ./
COPY gradle ./gradle
COPY frontend ./frontend
RUN chmod +x ./gradlew

COPY src ./src
RUN ./gradlew --no-daemon bootJar \
    && find build/libs -maxdepth 1 -type f -name '*.jar' ! -name '*-plain.jar' -exec cp {} /app.jar \;

FROM eclipse-temurin:25-jre

WORKDIR /app
COPY --from=build --chown=10001:10001 /app.jar /app/app.jar
USER 10001:10001

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
