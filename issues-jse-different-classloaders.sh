#!/bin/bash

if [ "$1" == 'build' ]
then
    mvn clean package
fi

java -cp ./target/study-classloaders.jar com.github.devmix.study.classloaders.issues.DifferentClassLoaders
