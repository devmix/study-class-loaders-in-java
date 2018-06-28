#!/bin/bash

JAVA_HOME=/mnt/data-1/sdk/jdk-11
JAVAC="${JAVA_HOME}/bin/javac"
JAVA="${JAVA_HOME}/bin/java"

if [ "$1" == 'build' ]
then
    ../mvnw clean package
fi

$JAVAC ./compiled/ExternalClass.java
$JAVA -cp ./target/study-classloaders.jar com.github.devmix.study.classloaders.CustomClassLoader
