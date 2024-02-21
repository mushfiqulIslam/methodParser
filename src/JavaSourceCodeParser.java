import com.github.javaparser.ParseProblemException;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class JavaSourceCodeParser {
    void parseJavaFile(File file) {
        try {
            // Build CompilationUnit from FileInputStream
            FileInputStream inputStream = new FileInputStream(file);
            CompilationUnit cu = StaticJavaParser.parse(inputStream);

            // Visit the CompilationUnit object
            MethodVisitor methodVisitor = new MethodVisitor();
            methodVisitor.visit(cu, null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseProblemException e) {
            e.printStackTrace();
            System.err.println("Parse error occurred in file: " + file.getName());
        }
    }

    void parse(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // Recursive call
                    parse(file);
                } else if (file.isFile() && file.getName().endsWith(".java")) {
//                    System.out.println(file.getPath());
                    parseJavaFile(file);
                }
            }
        }
    }
}
