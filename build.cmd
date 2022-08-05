@echo off

mkdir out

set src=src\glmatrix

javac -sourcepath src -d out ^
    %src%\mat4.java ^
    %src%\mat3.java ^
    %src%\vec3.java ^
    %src%\vec2.java
