#!/bin/bash
JAVA=$JAVA_HOME/bin/java
echo "Stopping application..."
killall java

echo "Cleaning the application directory"
$MAVEN clean

$MAVEN package
echo "Packaging the software"
