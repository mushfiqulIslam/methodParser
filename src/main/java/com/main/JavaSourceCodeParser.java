package com.main;

import com.github.javaparser.ParseProblemException;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.io.*;


public class JavaSourceCodeParser {
    /**
     * The JavaSourceCodeParser class is responsible for parsing Java source code files
     * and extracts method names from them.
     */
    private final BufferedWriter bufferedWriter;
    public JavaSourceCodeParser(BufferedWriter bufferedWriter) {
        this.bufferedWriter = bufferedWriter;
    }
    String parseJavaFile(File file) {
        try {
            // Build CompilationUnit from FileInputStream
            FileInputStream inputStream = new FileInputStream(file);
            CompilationUnit cu = StaticJavaParser.parse(inputStream);

            // Visit the CompilationUnit object
            MethodVisitor methodVisitor = new MethodVisitor();
            methodVisitor.visit(cu, null);
            return methodVisitor.getMethodNames();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseProblemException e) {
            e.printStackTrace();
            System.out.println("Parse error occurred in file: " + file.getName());
        }
        return "";
    }

    void parse(File directory) throws IOException {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // Recursive call
                    parse(file);
                } else if (file.isFile() && file.getName().endsWith(".java")) {
//                    System.out.println(file.getPath());
                    String methodNames = parseJavaFile(file);
                    if (methodNames != null) {
                        this.bufferedWriter.write(methodNames);
                        this.bufferedWriter.newLine();
                    }
                }
            }
        }
    }
}
