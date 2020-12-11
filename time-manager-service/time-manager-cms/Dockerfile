FROM adoptopenjdk:8-jdk-openj9
COPY /time-manager-cms/target/*.jar time-manager-cms.jar
EXPOSE 33001
ENTRYPOINT ["java","-jar", "-Duser.timezone=GMT+8","-Djava.awt.headless=true","time-manager-cms.jar"]