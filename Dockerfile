#Stage 1
# initialize build and set base image for first stage
FROM maven:3.8.6-openjdk-18 as stage1
# speed up Maven JVM a bit
ENV MAVEN_OPTS="-XX:+TieredCompilation -XX:TieredStopAtLevel=1"
# set working directory
WORKDIR /opt/demo
# copy just pom.xml
COPY pom.xml .
# go-offline using the pom.xml
RUN mvn dependency:go-offline
# copy other files
COPY ./src ./src
# compile the source code and package it in a jar file
RUN mvn clean install -Dmaven.test.skip=true

#Stage 2
FROM eclipse-temurin:19
#RUN addgroup -S spring && adduser -S spring -G spring
#USER spring:spring
COPY --from=stage1 /opt/demo/target/*.jar app.jar
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]