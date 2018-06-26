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
                plv.displayMenu();
                break;
            case 3: //Move to a new location
                startMove();
                break;
            case 4: //Manage the crops
                CropView cv = new CropView();
                cv.displayGameMenuView();
                break;
            case 5: System.out.println("\nReturn to the Main Menu");
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
