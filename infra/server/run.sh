#!/bin/sh
#docker run -d -p 8080:8080 -p 8082:8082 -v /home/katsuki/develop/workspace/wicket-examples/infra/server/base/dev/tomcatHome:/usr/local/apache-tomcat-8.0.22 k3yake/ws-dev
docker run -d -p 8080:8080 -p 8082:8082 k3yake/ws-dev