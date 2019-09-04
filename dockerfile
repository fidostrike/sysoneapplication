FROM openjdk:8-jre-alpine
VOLUME /tmp
WORKDIR "/tmp"
EXPOSE 8090:8090
EXPOSE 3306:3306
COPY /target/sysoneapplication-0.0.1-SNAPSHOT.jar /tmp/sysoneapplication-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/tmp/sysoneapplication-0.0.1-SNAPSHOT.jar"]