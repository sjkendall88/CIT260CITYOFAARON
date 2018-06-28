/* The MainMenuView class - part of the view layer
 * Object of this class is to manage the main menu.
 * Authors: James Rasmussen, JJ Hugh, and Sterling Kendall
 * Date last modified: June 4, 2018
 */
package byui.aaron.view;

import byui260.aaron.model.CropData;
import java.util.Scanner;
import city.of.aaron.CityOfAaron;
import byui260.aaron.model.Player;
import byui260.aaron.model.Game;
import byui.aaron.view.NewGameMenu;
import byui260.aaron.control.GameControl;

/**
 *
 * @author James Rasmussen, JJ Hugh, and Sterling Kendall
 */

public class MainMenuView extends MenuView {
    Scanner keyboard = new Scanner(System.in);
    private String theMenu;
    private int max;
    // The MainMenuView constructor
    // Purpose: Initialize the menu Data
    // Parameters: none
    // Return: none
    // ========================================
    public MainMenuView(){
        
        super("\n" + "***************************\n"
                + "*City Of Aaron: Main Game Menu *\n"
                + "***************************\n"
                + "1 - Start new Game \n"
                + "2 - Get and Start a Saved Game \n"
                + "3 - Get help on playing the Game \n"
                + "4 - Save Game \n"
                + "5 - Quit \n",
                5);
    }
      
    // The doAction method
    // Purpose: performs the selected action
    // parameters: none
    // return: none
    // ======================================================
    
    @Override public void doAction(int option){
        switch(option){
            case 1: // if the option is 1, call startNewGame()
                startNewGame();
                break;
            case 2: // if the option is 2, call startSavedGame()
                startSavedGame();
                break;
            case 3: // if the option is 3, call displayHelpMenu()
                displayHelpMenu();
                break;
            case 4: // if the option is 4, call displaySaveGame()
                displaySaveGameView();
                break;
            case 5: // if the option is 5, display goodbye message
                System.out.println("Thanks for playing ... goodbye.");
        }
    }
    
    // The startNewGame method
    // Purpose: create game object and starts the game
    // parameters: none
    // returns: none
    // =====================================================
    public void startNewGame(){
        // Create a new Game object.
        Game theGame = new Game();
        
        // Save a reference to it in the GameProject class.
        CityOfAaron.setCurrentGame(theGame);
        
        // Display the Banner Page.
        System.out.println("\nA hearty welcome to the City of Aaron! "
                + "\n\nIt has been ordained that you should be the ruler "
                + "of the city. \nAs part and parcel with your calling, "
                + "be prepared to buy and sell land, \n1"
                + "as well as set aside "
                + "wheat for both food and the years planting. \nYour job also"
                + " includes the high and holy requirement of declaring and "
                + "paying offerings. \nRemember though, people must eat too, "
                + "and people who don’t eat have a tendency to starve. "
                + "\nPlease Plan carefully. Sounds easy enough… but have we "
                + "told you about the rats?");
        
        // Prompt for and get the user's name.
        String name;
        System.out.println("\nPlease type in your first name: ");
        name = keyboard.next();
        
        // Display a welcome message
        System.out.println("\nWelcome " + name + " have fun.");
        
        //call createNewGame() method. send name as param.
        GameControl.createNewGame(name);
        
        //Display the game menu
        NewGameMenu ngmv = new NewGameMenu(); 
        ngmv.displayMenu();
            
        }
     
    // The displayHelpMenu method
    // Purpose: Display the help menu view
    // parameters: none
    // returns: none
    // Author : James
    // =====================================================
    public void displayHelpMenu(){
        HelpMenuView hmv = new HelpMenuView();
        hmv.displayHelpMenuView();
    }
    
    // The startSavedGame method
    // Purpose: locate game object and starts saved game
    // parameters: none
    // returns: none
    // =====================================================
    public void startSavedGame(){
        System.out.println("\nStart saved game option selected.");
    }
    
    
    // The displaySaveGameView method
    // Purpose: Display list of saved games
    // parameters: none
    // returns: none
    // =====================================================
    public void displaySaveGameView(){
        System.out.println("\nDisplay list of saved games.");
    }

}
