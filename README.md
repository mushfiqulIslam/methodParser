# methodParser

This project is built using javapaser 3.25.9(https://github.com/javaparser/javaparser) and Jbr 17. Javaparser wont work with newer java versions.
So, it is recommended to use Java 17.

### To run this project, you must have java installed,If java environment is configured properly follow the steps below:

Step 1: Gradle wrapper is already available with this project, so use it to ensure that the correct version of Gradle is used for the project. Command:
```
$ .\gradlew wrapper
```
This command will download the specified version of Gradle defined in the project.

Step 2: To reload all the dependencies, run the following command: 
```
$ .\gradlew --refresh-dependencies
```

This project reads input from input.txt file added on the project root folder. It can only read valid java source code location.
If location is invalid, output method will be empty. The output will be written in a output.txt file on the project root folder, each line indicates methodNames of an individual file.

Step 3: Now run using:
```
$ .\gradlew run
```