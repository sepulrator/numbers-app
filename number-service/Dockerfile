FROM java:8-jre
MAINTAINER Osman Samil AKCELIK <osman.samil327@gmail.com>

ADD ./target/number-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/number-service.jar"]

EXPOSE 8000

