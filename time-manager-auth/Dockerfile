FROM adoptopenjdk/openjdk8:jre8u265-b01
COPY /time-manager-auth/target/*.jar time-manager-auth.jar
EXPOSE 33201
ENTRYPOINT ["java","-jar", "-Duser.timezone=GMT+8","-Djava.awt.headless=true","time-manager-auth.jar"]