FROM openjdk:11

WORKDIR /app

RUN mkdir public

COPY target/sendEmailExemple-0.0.1-SNAPSHOT.jar /app/sendEmailExemplo.jar
COPY  /src/main/webapp/ /app/public/

ENTRYPOINT ["java", "-jar", "sendEmailExemplo.jar"]