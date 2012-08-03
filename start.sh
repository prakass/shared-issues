#!/bin/bash
APP_FOLDER=/opt/trunk/myfamily
PROPERTIES_FOLDER=/opt/properties
CLASSPATH=$PROPERTIES_FOLDER:$APP_FOLDER/target/shared-issues-1/WEB-INF/lib/*:$APP_FOLDER/target/shared-isssues-1/WEB-INF/classes/:.

echo "Stopping application..."
killall java

echo "Cleaning the application directory"
mvn clean

mvn package
#echo "Packaging the software"

echo "Starting application..."
export CLASSPATH=$CLASSPATH
java -Dfile.encoding=UTF-8 com.sharedissues.all.common.JettyServer prod