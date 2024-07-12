/* Author: Randall Carbonel
 * Date: 7/11/24
 * Class: ASD216 - Java Programming
 * Assignment:  Create an application that checks whether a file exists on the current computer and prints the contents of the file if it does exist.
 * Specifications:
 *      - Use the console to get a path from the user.
 *      - If the file exists, display a message that prints the contents of the file
 *      - If the file doesn’t exist, display an appropriate message.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choice = "y";

        while (choice.equalsIgnoreCase("y")) {
            // Prompt the user to enter a file path
            System.out.print("Enter a path to a file: ");
            String filePath = sc.nextLine();

            // Create a File object with the specified file path
            File file = new File(filePath);

            // Check if the file exists
            if (file.exists()) {

                // Print the contents of the file
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    System.err.println("Error reading the file: " + e.getMessage());
                }

            } else {
                System.out.println("File does not exist.");
            }

            // Ask user if they want to check another file
            System.out.print("Continue? (y/n): ");
            choice = sc.nextLine();
        }

        // Close the scanner
        sc.close();
    }
}
