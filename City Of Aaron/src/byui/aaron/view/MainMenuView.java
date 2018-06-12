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
    public void displayMenuView(){
        int menuOption;
        do{
            // Display the Menu
            System.out.println(theMenu);
            // Prompt the user for input and get user input
            menuOption = getMenuOption();
            // Perform the desired action
            doAction(menuOption);
            // Determine and Display the next action
        }while(menuOption != max);
    }
    // the getMenuoption method
    // Purpose get the user input
    // Parameters: none
    // Return: integers minus option selected
    // ===========================================
    public int getMenuOption(){
        //declare a variable to hold the input
        int userInput;
        
        // begin loop
        do {
            // get user input from keyboard
            userInput = keyboard.nextInt();
            
            // if it is not a valid value output an error message.
            if(userInput < 1 || userInput > max)
            {
                System.out.println("\noption must be between 1 and " + max);
            }
            // loop back to top if input not valid
        } while(userInput < 1 || userInput > max);
        
        // return the value input by the user
        return userInput;
    }
    
    // The doAction method
    // Purpose: performs the selected action
    // parameters: none
    // return: none
    // ======================================================
    
    public void doAction(int option){
        switch(option){
            case 1: // if the option is 1, call startNewGame()
                startNewGame();
                break;
            case 2: // if the option is 2, call startSavedGame()
                startSavedGame();
                break;
            case 3: // if the option is 3, call displayHelpMenu()
                displayHelpMenuView();
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
        
        //create a CropData object,
        CropData cropData = new CropData();
        
        cropData.setYear(0);
        cropData.setPopulation(100);
        cropData.setNewPeople(5);
        cropData.setCropYield(3);
        cropData.setNumberWhoDied(0);
        cropData.setOffering(10);
        cropData.setWheatInStore(2700);
        cropData.setAcresOwned(1000);
        cropData.setAcresPlanted(1000);
        cropData.setHarvest(3000);
        cropData.setOfferingBushels(300);
        cropData.setAcresPlanted(1000);
        
        //save a reference to it in the Game.
        theGame.setCrop(cropData);
        
        
        
        // create a new Player object
        Player thePlayer = new Player();    
        
        // Prompt for and get the user's name.
        String name;
        System.out.println("\nPlease type in your first name: ");
        name = keyboard.next();
        
        // Save the user's name in the Player object
        thePlayer.setPlayerName(name);
        
        // Save a reference to the player object in the Game object.
        theGame.setThePlayer(thePlayer);
        
        // Display a welcome message
        System.out.println("\nWelcome " + name + " have fun.");
        
        // Display the game menu
        
    }
    
    // The startSavedGame method
    // Purpose: locate game object and starts saved game
    // parameters: none
    // returns: none
    // =====================================================
    public void startSavedGame(){
        System.out.println("\nStart saved game option selected.");
    }
    // The displayHelpMenuView method
    // Purpose: Display the help menu view
    // parameters: none
    // returns: none
    // =====================================================
    public void displayHelpMenuView(){
        System.out.println("\nDisplay the help menu view.");
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
