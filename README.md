Toy Robot
Description:
- The application is a simulation of a toy robot moving on a square tabletop,
of dimensions 5 units x 5 units.
- There are no other obstructions on the squareTable surface.
- The robot is free to roam around the surface of the squareTable, but must be
prevented from falling to destruction. Any movement that would result in the
robot falling from the squareTable must be prevented, however further valid
movement commands must still be allowed.

#How To Run:
## Git clone https://github.com/sumyat/java-toy-robot

## Install Gradle
- `brew install gradle`

## Import Project in Intellij
- From Main Menu of Intellij, File > Open
- Go to the file location, choose build.gradle and click `OK`.
- Specify Gradle Home location
On Mac: /usr/local/opt/gradle/libexec in case you installed it via brew.
For Windows: specify the path where you installed Gradle.

## Install Intellij RunConfiguration
- Install configuration by gradle task `gradle installRunConfiguration`.

## Start Application
- Start `ToyRobot` from Run Configuration.
