FROM openjdk:8-jdk

RUN /bin/ls /
COPY build/libs/*.jar /app/
RUN /bin/ls /
RUN /bin/ls /app
RUN /bin/ls /workspace
WORKDIR /app
RUN pwd -p

EXPOSE 8080

ENV JAVA_OPTS="-XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap"
CMD ["java", "-jar", "/app/kotlin-demo.jar"]
