#!/bin/bash
#First kill all java process
killall java

JAVA=$JAVA_HOME/bin/java
APP_FOLDER=/opt/app/shared-issues
PROPERTIES_FOLDER=/opt/properties

CLASSPATH=$PROPERTIES_FOLDER:$APP_FOLDER/target/shared-issues-1/WEB-INF/lib/*:$APP_FOLDER/target/shared-issues-1/WEB-INF/classes:

echo "Starting application..."
export CLASSPATH=$CLASSPATH
$JAVA -Dfile.encoding=UTF-8 com.sharedissues.all.common.JettyServer prod 80 > app-sysout.log

