FROM openjdk:8-jdk

COPY build/libs/kotlin-demo.jar /app/kotlin-demo.jar
WORKDIR /app

EXPOSE 8080

ENV JAVA_OPTS="-XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap"
CMD ["java", "-jar", "/app/kotlin-demo.jar"]
