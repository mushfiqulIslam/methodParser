package com.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String currentDir = System.getProperty("user.dir");
        String inputFilePath = currentDir + File.separator + "input.txt";
        String outputFilePath = currentDir + File.separator + "output.txt";

        try {
            Scanner scanner = new Scanner(new File(inputFilePath));
            FileWriter fileWriter = new FileWriter(outputFilePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            if (scanner.hasNextLine()) {
                String directoryPath = scanner.nextLine();

                // Parse the given folder
                JavaSourceCodeParser parser = new JavaSourceCodeParser(bufferedWriter);
                bufferedWriter.write("Method names declared in the given source code are: ");
                bufferedWriter.newLine();
                parser.parse(new File(directoryPath));
            } else {
                bufferedWriter.write("Input file is empty");
            }

            scanner.close();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}