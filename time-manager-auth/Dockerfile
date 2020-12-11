FROM adoptopenjdk:8-jdk-openj9
COPY /time-manager-auth/target/*.jar time-manager-auth.jar
EXPOSE 33201
ENTRYPOINT ["java","-jar", "-Duser.timezone=GMT+8","-Djava.awt.headless=true","time-manager-auth.jar"]