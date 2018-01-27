FROM java:8

EXPOSE 4567

MAINTAINER clivern.com

RUN mkdir -p /opt/apps/ponut

COPY ponut_fat-1.0.0.jar /opt/apps/ponut

ENTRYPOINT ["java", "-jar", "/opt/apps/ponut/ponut_fat-1.0.0.jar"]