#!/bin/bash

JAVA_HOME=/mnt/data-1/sdk/jdk-11
JAVA="${JAVA_HOME}/bin/java"

if [ "$1" == 'build' ]
then
    ../mvnw clean package
fi

$JAVA -cp ./target/study-classloaders.jar com.github.devmix.study.classloaders.issues.DifferentClassLoaders
