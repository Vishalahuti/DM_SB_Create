FROM openjdk:17-jdk-slim
EXPOSE 8081
ADD target/DM_SB_Create.jar DM_SB_Create.jar
ENTRYPOINT ["java","-jar","/DM_SB_Create.jar"]
