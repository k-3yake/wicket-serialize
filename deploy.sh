#!/bin/bash
mvn clean compile war:war
cp ./target/*.war /usr/local/apache-tomcat-8.0.22/webapps/.
