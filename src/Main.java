import java.io.File;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Take input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();
        scanner.close();

        // Parse the given folder
        JavaSourceCodeParser parser = new JavaSourceCodeParser();
        System.out.print("Method names declared in the given source code are: ");
        parser.parse(new File(directoryPath));
    }
}