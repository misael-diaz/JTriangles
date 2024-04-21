# JTriangles

## Compile

Instructions to compile the application in Mac OS X and GNU/Linux.

First create the directory to host the classes:

```sh
mkdir bin
```

Note that the Java compiler won't create it for you so this is a mandatory step.

Then issue the following instructions to the Java compiler:

```sh
javac -d bin ./src/com/midiaz/*/*.java ./src/com/midiaz/JTriangle.java
```

Upon a successful build all the classes are going to be located in the binaries directory `bin`.

You should obtain the same directory hierarchy as shown here:

```
bin
bin/com
bin/com/midiaz
bin/com/midiaz/util
bin/com/midiaz/util/Tag.class
bin/com/midiaz/util/JRandom.class
bin/com/midiaz/util/Util.class
bin/com/midiaz/JTriangle.class
bin/com/midiaz/JTriangle$1.class
bin/com/midiaz/polygon
bin/com/midiaz/polygon/EquilateralTriangle.class
bin/com/midiaz/polygon/IsoscelesTriangle.class
bin/com/midiaz/polygon/ScaleneTriangle.class
bin/com/midiaz/polygon/Triangle.class
```

## Archive

To package the application into a standalone Java application you will need to archive it.

To create the Java Archive (JAR) issue the following command:

```sh
jar --create --file JTriangle.jar --main-class com.midiaz.JTriangle -C bin com
```

Upon completion you should see `JTriangle.jar` at the top level of the repository.

## Execute

To execute the standalone Java application pass the following instructions to the
Java launcher:

```sh
java -jar JTriangle.jar
```

## Demo

This shows the expected output for a unit equilateral triangle:

```
JTriangle App
input the lenghts of a triangle: 1 1 1

kind: equilateral
x: 1.000000 theta: 60.000000
area: 0.433013

```
