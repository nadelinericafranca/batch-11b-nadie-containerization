FROM tupperware.mynt.xyz/mtc/devtools/springboot-jdk17:3.0.5 as build

COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean compile package -Dmaven.test.skip=true

# FROM openjdk:17
FROM docker.io/eclipse-temurin:17-jre

# Set timezone to Asia/Manila
ENV TZ=Asia/Manila
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

COPY --from=build /usr/src/app/target/*.jar /usr/app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/app/app.jar"]