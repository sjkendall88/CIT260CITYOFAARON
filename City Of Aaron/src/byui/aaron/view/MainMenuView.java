/* The MainMenuView class - part of the view layer
 * Object of this class is to manage the main menu.
 * Authors: James Rasmussen, JJ Hugh, and Sterling Kendall
 * Date last modified: June 4, 2018
 */
package byui.aaron.view;

import java.util.Scanner;
import city.of.aaron.CityOfAaron;
import byui260.aaron.model.Player;



/**
 *
 * @author James Rasmussen, JJ Hugh, and Sterling Kendall
 */
public class MainMenuView {
    Scanner keyboard = new Scanner(System.in);
    private String theMenu;
    private int max;
    // The MainMenuView constructor
    // Purpose: Initialize the menu Data
    // Parameters: none
    // Return: none
    // ========================================
    public MainMenuView(){
        theMenu = "\n" + "***************************\n"
                + "*City Of Aaron: Main Game Menu *\n"
                + "***************************\n"
                + "1 - Start new Game \n"
                + "2 - Get and Start a Saved Game \n"
                + "3 - Get help on playing the Game \n"
                + "4 - Save Game \n"
                + "5 - Quit \n";
        max = 5;
    }
    // The displayMainMenu method
    // Purpose: displays the menu, gets the user input
    //          and does the selected action
    // Parameters: none
    // Returns: none
    // ========================================
    public void displayMainMenu(){
        // Display the Menu
        // Prompt the user for input and get user input
        // Perform the desired action
        // Determine and Display the next action
        // ============================================
        
    }
}
