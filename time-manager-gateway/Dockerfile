FROM adoptopenjdk/openjdk8:jre8u265-b01
COPY /time-manager-gateway/target/*.jar time-manager-gateway.jar
EXPOSE 33101
ENTRYPOINT ["java","-jar", "-Duser.timezone=GMT+8","-Djava.awt.headless=true","time-manager-gateway.jar"]