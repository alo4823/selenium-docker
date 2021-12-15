FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq

WORKDIR /usr/share/testing

# ADD .jar under target from host into this image at WORKDIR
ADD target/selenium-docker.jar selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/libs libs

# ADD suite files
ADD book-flight-module.xml book-flight-module.xml
ADD search-module.xml search-module.xml

# ADD health check script
ADD healthcheck.sh healthcheck.sh

# BROWSER
# HUB HOST
# MODULE

#ENTRYPOINT java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TestNG $MODULE

ENTRYPOINT sh healthcheck.sh