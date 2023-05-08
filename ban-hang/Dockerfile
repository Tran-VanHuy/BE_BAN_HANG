FROM maven:3.8.6 as builder
ENV HOME=/home/usr/app
RUN mkdir -p $HOME
WORKDIR $HOME
ADD pom.xml $HOME
RUN ["/usr/local/bin/mvn-entrypoint.sh", "mvn", "verify", "clean", "--fail-never"]
ADD . $HOME
RUN ["mvn", "generate-sources"]
RUN ["mvn", "package","-DskipTests"]

FROM openjdk:11.0.16-slim
ENV HOME=/home/usr/app
WORKDIR $HOME
EXPOSE 8080
COPY --from=builder $HOME/target/*.jar $HOME/*.jar
ENTRYPOINT ["java", "-jar", "/home/usr/app/*.jar" ]