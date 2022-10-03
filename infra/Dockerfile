FROM openjdk:17-alpine

ENV TZ=Asia/Seoul
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

COPY ./*SNAPSHOT.jar deploy.jar
ENTRYPOINT ["java","-jar","deploy.jar"]