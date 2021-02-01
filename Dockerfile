FROM openjdk:8-jdk-alpine

RUN apk update \
    && apk upgrade \
    && apk add --no-cache bash \
    && apk add --no-cache tar \
	&& apk add --no-cache wget \
	&& apk add --no-cache openssl

ENV DOCKERIZE_VERSION v0.6.1
RUN wget https://github.com/jwilder/dockerize/releases/download/$DOCKERIZE_VERSION/dockerize-alpine-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && tar -C /usr/local/bin -xzvf dockerize-alpine-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && rm dockerize-alpine-linux-amd64-$DOCKERIZE_VERSION.tar.gz
 
COPY target/*.jar /app/app.jar

EXPOSE 8080