/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.aaron.view;
import java.util.Scanner;


/**
 *
 * @author JRome
 */
public class NewGameMenu {
    Scanner keyboard = new Scanner(System.in);
    private String theMenu;
    private int max;
 
    //The newGameMenuView Constructor
    //Purpose: Initialize the menu Data
    //Parameters: none
    //Return: none
    
    public NewGameMenu(){
        theMenu = "\n" + "**********************\n" 
                + "*City of Aaron: Game Menu *\n"
                + "******************************\n"
                + "1 - View the Map\n"
                + "2 - View/Print a list\n"
                + "3 - Move to a new location\n"
                + "4 - Manae the crops \n"
                + "5 - Return to the main menu.\n";
                
        max = 5;
    }

    //THe displayGameMenu method.
    //Purpose dislays the menu, gets the user input 
    //        and does the selected action.
    //Parameters: none
    //Returns: none
    
    public void displayGameMenuView(){
        int menuOption;
        do{
            //display the menu
            System.out.println(theMenu);
            //Prompt user for input and get user input.
            menuOption = getGameMenuOption();
            //Perform the desire option
            doAction(menuOption);
            //Determine and display the next option.
        }while(menuOption != max); 
    }
    
    
     //the getGameMenuOption method
    //Purpose: get the user input
    //Parameters: None
    //Return: integers minus option selected
    
    public int getGameMenuOption(){
        //declare the variable to hold the input
        int userInput;
        
        //begin the loop
        do {
            //get user input from keyboard
            userInput = keyboard.nextInt();
            
            //If it is not a valid value output an error message.
            if (userInput < 1 || userInput > max){
            System.out.println( "\nOption must be beween 1 and " + max); 
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
    /*
    public void doAction (int option){
        switch (option){
            case 1: //View the Map
                displayMap();
                break;
            case 2: //View/Print a List
                displayList();
                break;
            case 3: //Move to a new location
                startMove();
                break;
            case 4: //Manage the crops
                startManageCrops();
                break;
            case 5: //Return to the main menu
                startReturnMain();
                break;
        }
    
    
    public void displayMap();   
    public void displayList();
    public void startMove();
    public void startManageCrops();
    public void startReturnMain();
      */     
     }       
            
            
            
            
            
            
            

















    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
