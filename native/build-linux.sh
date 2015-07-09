#!/bin/bash
g++ -I /usr/lib/jvm/java-7-openjdk-amd64/include/ -I freetype-2.6/include/ -L lib/linux32 -shared -lfreetype26 -o libfreetype2jni.32.so src/*.cpp -fPIC -m32
g++ -I /usr/lib/jvm/java-7-openjdk-amd64/include/ -I freetype-2.6/include/ -L lib/linux64 -shared -lfreetype26 -o libfreetype2jni.64.so src/*.cpp -fPIC -m64

