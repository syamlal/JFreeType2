#!/bin/bash
mkdir prebuilt prebuilt/linux32 prebuilt/linux64
g++ -I /usr/lib/jvm/java-7-openjdk-amd64/include/ -I freetype-2.6/include/ -L lib/linux32 -shared -lfreetype -o prebuilt/linux32/libfreetype2jni.so src/*.cpp -fPIC -m32
g++ -I /usr/lib/jvm/java-7-openjdk-amd64/include/ -I freetype-2.6/include/ -L lib/linux64 -shared -lfreetype -o prebuilt/linux64/libfreetype2jni.so src/*.cpp -fPIC -m64

