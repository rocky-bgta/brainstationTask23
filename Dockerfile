FROM openjdk:8
WORKDIR /opt
ENV PORT 9191
EXPOSE 8080
COPY target/*.jar /opt/app.jar
ENTRYPOINT exec java $JAVA_OPTS -jar app.jar

