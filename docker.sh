#!/bin/bash
#
#
#
#
#  _____   ____  _   _ _    _ _______
# |  __ \ / __ \| \ | | |  | |__   __|
# | |__) | |  | |  \| | |  | |  | |
# |  ___/| |  | | . ` | |  | |  | |
# | |    | |__| | |\  | |__| |  | |
# |_|     \____/|_| \_|\____/   |_|


JAVA_CONTAINER_BUILD="./docker/java/"
JAVA_CONTAINER_JAR="./docker/java/ponut_fat-1.0.0.jar"
FAT_JAR_PATH="./build/libs/ponut_fat-1.0.0.jar"

rm $FAT_JAR_PATH
rm $JAVA_CONTAINER_JAR
./gradlew build
./gradlew fatJar
cp $FAT_JAR_PATH $JAVA_CONTAINER_BUILD
docker-compose build
docker-compose up -d