FROM adoptopenjdk:8-jdk-openj9
COPY /time-manager-gateway/target/*.jar time-manager-gateway.jar
EXPOSE 33101
ENTRYPOINT ["java","-jar", "-Duser.timezone=GMT+8","-Djava.awt.headless=true","time-manager-gateway.jar"]