JFreeType2
=======

The aim of this project is to bring FreeType2 to Java. The version of FreeType2 that is supported is currently version 2.6.

Because this is a personal project, it's likely that to begin with, I will only be porting functions that I actually need to use. So you will probably come across this project, only to find that it's incomplete and half the functions you want to use are missing. Since I'm releasing it as open source, you are free to fork the project and add more functions that I haven't ported yet. (Please consider submitting a pull request afterwards so others can benefit!) If you don't feel up to that task, you can request the addition of missing functions by opening an issue on GitHub and I'll look into adding them for you as soon as I can find some free time.

<h2>License</h2>

JFreeType2 is licensed under the 3-clause BSD license.

FreeType itself is dual-licensed under both GNU GPL and the 'FreeType License'. See native/freetype-2.6/docs/LICENSE.TXT for details.

<h2>Dependencies</h2>

This project makes use of JLibraryLoader, which works around a design flaw on the Linux version of OpenJDK where library symbols are not loaded in global scope. On other platforms the JLibraryLoader mostly does nothing.

<h2>Testing</h2>

I tested this library on Windows (x86 and x64), Mac OS X (x86_64) and Ubuntu (x86_64) so far. It seems to work well enough.

A test project is included which you can run from Eclipse or some other reputable IDE if you want to test the library is working properly.

<h2>Including JFreeType2 in a Project</h2>

The project is still in flux. There is an 'unstable' 0.1 release available from <b>maven.ginever.net</b> for inclusion in public projects, but using it isn't recommended right now - many features are still missing. Nevertheless, here's an example on how to add it to a Gradle build script:

    repositories {
    	maven {
    		url "http://maven.ginever.net/"
    	}
    }
    
    dependencies {
    	compile 'com.tinytimrob:jfreetype2:0.1'
    } 

And an example of in a Maven POM file:

        <repository>
            <id>ginever</id>
            <name>Ginever Alliance Maven</name>
            <url>http://maven.ginever.net</url>
        </repository>

        <dependency>
            <groupId>com.tinytimrob</groupId>
            <artifactId>jfreetype2</artifactId>
            <version>0.1</version>
        </dependency>

The natives are published under the <b>jfreetype2-platform</b> artifact ID and appended with platform classifiers (win32, win64, osx, linux32, linux64 and ios). They should be fetched automatically by Gradle/Maven but you will need to extract them manually to an appropriate place and add them to your java.library.path in order to make use of them. You can probably automate this without too much work; I wrote a custom Gradle task to do this in my own projects and it is fairly straightforward. For Maven, you could try using the [maven-nativedependencies-plugin](https://code.google.com/p/mavennatives/), although I have no experience with using that. Be sure to extract the natives for each platform to a separate folder, as some have clashing names.

<h2>Building it yourself</h2>

Building this library is in three steps.

The first step is to build freetype itself. This has already been done for you, so you can normally skip this. If you feel like redoing it for some reason, you can use the 'configure' and 'make' procedure to build the so/dylib (on linux/mac) or the vs2013 project to build the lib on Windows. (Note: There is also a 'configure32' script included in order to build the 32-bit version of freetype on 64-bit Linux.)

Building freetype for iOS can use the included ios_build.sh.

The next step is to build the natives using the appropriate tools:

* *Windows*: Use the included Visual Studio project.
* *Mac OS X and Apple iOS*: Use the included XCode project.
* *Linux*: The 'native' folder includes a shell-script called 'build-linux.sh'.

After building the natives, you need to copy them to the native/prebuilt/ folder.

Note that you will only be building the natives for *your platform* using this method.

Once you have all the natives rebuilt, the final step is to build the Java part of the library. A Gradle build script is provided to do this. Here are the steps:

1. Create the Eclipse project ('gradlew eclipse')
2. Use the test application to verify that the library is working properly
3. Set environment variables JAVADOC_PUBLISHING_LOCATION and MAVEN_PUBLISHING_LOCATION
4. Publish the library and Javadoc ('gradlew publish')

<h2>API Documentation</h2>

Wherever possible I have tried to keep the API of JFreeType2 as close to the original as possible. If you need them, some [Javadocs](https://javadoc.ginever.net/jfreetype2/0.1/) are also available which are based on the official FreeType 2 documentation.
