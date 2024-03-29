# methodParser

This project is built using javapaser 3.25.9(https://github.com/javaparser/javaparser), gradle 8.4 and Jbr 17. Javaparser won't work with newer java versions.
So, it is recommended to use Java 17.

This project reads input from a file named `input.txt`, which should be located in the root folder of the project. 
It can only process valid Java source code locations. If the specified location is invalid, the output will not contain any method name.
The results will be written to a file named `output.txt`, also located in the root folder of the project. 
Each line in the `output.txt` file corresponds to the method names found in an individual file.

## Setup and Run
### To run this project, you must have java installed,If java environment is configured properly follow the steps below.

Step 1: Gradle wrapper is already available with this project, so use it to ensure that the correct version of Gradle is used for the project. Command:
```
$ .\gradlew wrapper
```
This command will download the specified version of Gradle defined in the project.

Step 2: To reload all the dependencies, run the following command: 
```
$ .\gradlew --refresh-dependencies
```

Step 3: An input.txt file is added on the root directory of this project, replace the path with the source code root 
path of a java project. Here is an example:
```text
path/to/the/source/code/root/folder
```

Step 4: Now run using:
```
$ .\gradlew run
```
Check the `output.txt` file. All the method of that source code has been added there.

Note: Only one path will be taken from the input file, Instead of using comma try to run multiple time for multiple source codes.  For Linux and Mac try
`./gradlew` and before that give executable permission to the `gradlew` file.