#!/usr/bin/env sh

clear
./gradlew test && git add . && git commit -am "green" && git push