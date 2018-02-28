FROM openjdk:8-jdk

COPY build/libs/kotlin-test.jar /app/kotlin-test.jar
WORKDIR /app

EXPOSE 8080

ENV JAVA_OPTS="-XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap"
ENTRYPOINT ["java", "-jar", "/app/kotlin-test.jar"]
