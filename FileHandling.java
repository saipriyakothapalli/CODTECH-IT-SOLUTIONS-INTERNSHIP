import java.io.*;
import java.util.Scanner;

public class FileHandling {

    // Write data to file
    public static void writeFile(String fileName, String content) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    // Read data from file
    public static void readFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("\nFile Content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Modify file (append content)
    public static void modifyFile(String fileName, String newContent) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write("\n" + newContent);
            System.out.println("File modified successfully.");
        } catch (IOException e) {
            System.out.println("Error modifying file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "sample.txt";

        // Write Operation
        System.out.print("Enter text to write: ");
        String content = scanner.nextLine();
        writeFile(fileName, content);

        // Read Operation
        readFile(fileName);

        // Modify Operation
        System.out.print("\nEnter text to append: ");
        String newContent = scanner.nextLine();
        modifyFile(fileName, newContent);

        // Read Again
        readFile(fileName);

        scanner.close();
    }
}