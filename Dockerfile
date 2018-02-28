FROM openjdk:8-jdk
WORKDIR /usr/src/app

COPY kotlin-test.jar .

EXPOSE 8080
ENV JAVA_OPTS="-XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap"
ENTRYPOINT ["java", "-jar", "kotlin-test.jar"]
