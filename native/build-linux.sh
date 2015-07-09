#!/bin/bash
g++ -I /usr/lib/jvm/java-7-openjdk-amd64/include/ -I inc/ -L lib/linux32 -shared -lfmod -o libfreetype2jni.32.so src/*.cpp -fPIC -m32
g++ -I /usr/lib/jvm/java-7-openjdk-amd64/include/ -I inc/ -L lib/linux64 -shared -lfmod -o libfreetype2jni.64.so src/*.cpp -fPIC -m64

