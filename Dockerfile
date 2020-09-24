FROM adoptopenjdk/openjdk8:jre8u265-b01
COPY /time-manager-cms/target/*.jar time-manager-cms.jar
EXPOSE 33001
ENTRYPOINT ["java","-jar", "-Duser.timezone=GMT+8","-Djava.awt.headless=true","time-manager-cms.jar"]