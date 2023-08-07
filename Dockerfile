FROM eclipse-temurin:17
WORKDIR /bhara
ENV PORT 8080
EXPOSE 8080
COPY target/springmysql-docker-k8s.jar springmysql-docker-k8s.jar
ENTRYPOINT exec java -jar springmysql-docker-k8s.jar