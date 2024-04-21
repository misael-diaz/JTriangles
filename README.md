# JTriangles

## Compile

```sh
mkdir bin
```

```sh
javac -d bin ./src/com/midiaz/*/*.java ./src/com/midiaz/JTriangle.java
```

## Archive

```sh
jar --create --file JTriangle.jar --main-class com.midiaz.JTriangle -C bin com
```

## Execute

```sh
java -jar JTriangle.jar
```
