/**
 * This class is the main class of the program.
 * The program is a simple library management system
 * that allows the user to view, add, remove, and search
 * for library items (limited to books at this time).
 *
 * @author Erin Beatrice Micaela G. Reyes
 */

package org.example;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        BookManager bookManager = new BookManager();
        Scanner myScan = new Scanner(System.in);
        String loop;

        bookManager.initializeBooks();

        System.out.print("Hello! Welcome to The Library of Alexandria! \n");

        do {
            loop = "";

            try {
                System.out.print("\nSelect a Function: \nView Books[1], \nAdd a Book [2], \nDelete a Book [3], \nSearch for a Book [4] \n");
                int optionInput = myScan.nextInt();
                myScan.nextLine(); // Consume newline character left in the buffer

                bookManager.option(optionInput);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                myScan.nextLine(); // Clear the scanner buffer
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                myScan.nextLine(); // Clear the scanner buffer
            }


            while(!loop.equalsIgnoreCase("Y") && !loop.equalsIgnoreCase("N")){
                System.out.println("Return to the main menu? Y/N?");
                loop = myScan.nextLine().trim();

                if(!loop.matches("[yYnN]")) {
                    System.out.println("\nInvalid input. Please type Y/N.");
                }
            }
        } while(loop.equalsIgnoreCase("Y"));

        myScan.close();
    }
}
