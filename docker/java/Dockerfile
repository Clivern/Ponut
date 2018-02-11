FROM java:8

EXPOSE 4567

MAINTAINER clivern.com

RUN mkdir -p /opt/apps/ponut

WORKDIR /opt/apps/ponut

ENTRYPOINT ["java", "-jar", "build/libs/ponut_fat-1.0.0.jar"]