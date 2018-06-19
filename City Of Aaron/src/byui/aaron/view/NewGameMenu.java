/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.aaron.view;
import java.util.Scanner;


/**
 *
 * @author J.J. Hugh
 */
public class NewGameMenu extends MenuView {
    
    //The newGameMenuView Constructor
    //Purpose: Initialize the menu Data
    //Parameters: none
    //Return: none
    
    public NewGameMenu(){

        super("\n" + "**********************\n" 
                + "*City of Aaron: Game Menu *\n"
                + "******************************\n"
                + "1 - View the Map\n"
                + "2 - View/Print a list\n"
                + "3 - Move to a new location\n"
                + "4 - Manage the crops \n"
                + "5 - Return to the game menu.\n",
                
                5);
    }

    //THe displayGameMenu method.
    //Purpose dislays the menu, gets the user input 
    //        and does the selected action.
    //Parameters: none
    //Returns: none
    
    @Override public void displayMenu(){
        int menuOption;
        do{
            //display the menu
            System.out.println(theMenu);
            //Prompt user for input and get user input.
            menuOption = getMenuOption();
            //Perform the desire option
            doAction(menuOption);
            //Determine and display the next option.
        }while(menuOption != max); 
    }
    
    
     //the getGameMenuOption method
    //Purpose: get the user input
    //Parameters: None
    //Return: integers minus option selected
    
    @Override public int getMenuOption(){
        //declare the variable to hold the input
        int userInput;
        
        //begin the loop
        do {
            //get user input from keyboard
            userInput = keyboard.nextInt();
            
            //If it is not a valid value output an error message.
            if (userInput < 1 || userInput > max){
            System.out.println( "\nOption must be between 1 and " + max); 
        }
            // loop back to top if input not valid
        }while (userInput < 1 || userInput > max);
        
        //return the value input by the user
        return userInput;
    }
    
    // doAction method
    //Purpose: performs the selected action
    //parameters: none
    //return: none
    
    @Override public void doAction (int option){
        switch (option){
            case 1: //View the Map
                displayMap();
                break;
                
            case 2: //View/Print a List
                PrintListView plv = new PrintListView(); 
                plv.displayPrintListView();
                break;
            case 3: //Move to a new location
                startMove();
                break;
            case 4: //Manage the crops
                CropView cv = new CropView();
                cv.displayGameMenuView();
                break;
            case 5: 
                //Return to the main menu
                // Main Menu View
                MainMenuView mmv = new MainMenuView();
                mmv.displayMenu();
        }
    }
    
    
    public void displayMap(){   
    System.out.println("\nDetails of the Map are to come.");
    }   
    
    public void startMove(){
    System.out.println("\nMoving to a new location Soon");
    }
    /*
    public void startManageCrops();
    */     
       
}      
            
      
            
            
            
            

















    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


