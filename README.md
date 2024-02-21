# methodParser

This project is built using javapaser 3.25.9(https://github.com/javaparser/javaparser), gradle 8.4 and Jbr 17. Javaparser wont work with newer java versions.
So, it is recommended to use Java 17.

This project reads input from **input.txt** file added on the project root folder. It can only read valid java source code location.
If location is invalid, output method will be empty. The output will be written in **output.txt** file on the project root folder, each line indicates methodNames of an individual file.

## Setup and Run
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

Step 3: An input.txt file is added on the root directory of this project, replace the path with the source code root path of a java project.
Step 4: Now run using:
```
$ .\gradlew run
```
Check the **output.txt** file. All the method of that source code has been added there.

Note: Only one path will be taken from the input file, Instead of using comma try to run multiple time for multiple source codes.