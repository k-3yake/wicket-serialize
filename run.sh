#!/bin/bash
PROJECT_HOME=/home/katsuki/develop/workspace/wicket-serialize

#mvn clean compile war:war || abort
docker build -f infra/server/base/DockerFile -t k3yake/ws-base . || abort
docker build -f infra/server/base/dev/DockerFile -t k3yake/ws-dev . || abort
docker stop `docker ps -q`
#docker run -d -p 8080:8080 -p 8082:8082 -v k3yake/ws-dev || abort
#docker run -d -p 8080:8080 -p 8082:8082 -v $PROJECT_HOME/target/wicket-serialize-1.0-SNAPSHOT.war:/usr/local/apache-tomcat-8.0.22/webapps/ws.war:ro k3yake/ws-dev || abort
docker run -d -p 8080:8080 -p 8082:8082 -v $PROJECT_HOME:/root/wicket-serialize k3yake/ws-dev || abort

docker ps
