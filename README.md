# Observation
For workflow examples (TUTORIAL.md), please look at cinema-service repository: https://github.com/Stuurt/cinema-service

# Requirements
- Docker
- Docker Compose (comes with docker desktop for Windows users)
- Java 21 (For **Windows users** if your IDE doesn't manage JDK versions, maybe you will need to change manually by environment variables JAVA_HOME or Path), like the example below:
  ![img.png](./readme-images/environment-variables-example.png), 

more information about changing jdk versions in windows: https://www.happycoders.eu/java/how-to-switch-multiple-java-versions-windows/
- Gradle (maybe your IDE has already installed it for you)

# How to run?

Just start by your IDE or run **./gradlew bootRun** at root directory.

### Common beginners errors for Windows users
If you encounter some persisting errors trying to setup properly, probably the reasons are:
- Wrong Java Version at your Path or JAVA_HOME:
  ![img.png](./readme-images/java-path-environment-variables.png)
  ![img.png](./readme-images/environment-variables-example.png)
- Running at wrong order. The docker image need to be run first, the spring will fail on startup if it doesn't encounter the specified database available

**To run the application using your IDE instead of the terminal, you will likely need to learn how to manage JDK versions within your IDE rather than changing environment variables**
IntelliJ example:
![img.png](./readme-images/changing-jdk-version-by-intellij.png)