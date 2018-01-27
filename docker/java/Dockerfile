FROM openjdk:8-jre-alpine

MAINTAINER clivern.com

RUN mkdir -p /opt/apps/ponut

COPY build/libs/ponut_fat-1.0.0.jar /opt/apps/ponut
RUN cd /opt/apps/ponut && ls -ltr

ENTRYPOINT ["java", "-jar", "/opt/apps/ponut/ponut_fat-1.0.0.jar"]