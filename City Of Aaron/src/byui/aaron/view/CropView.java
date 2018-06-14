/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.aaron.view;
import byui260.aaron.model.*;
import byui260.aaron.control.*;
import java.util.Scanner;
import city.of.aaron.CityOfAaron;

/**
 *
 * @author JRome
 */
public class CropView {
    
//Create a Scanner object.
private static Scanner keyboard = new Scanner(System.in);

//Get references to the Game object and the CropData object.
private static Game theGame = CityOfAaron.getCurrentGame();
private static CropData cropData = theGame.getCropData();

// referential variable to stabilize value of Land value on a given round.
public static int sellLandPrice;

private String theMenu;
private int max;
    //The CropView constructor test method
    //Purpose: confirm working methods
    //Parameters: none
    //Return: none
    
    public CropView(){
        theMenu = "\n" + "**********************\n" 
                + "*Debug: CropView testing phase *\n"
                + "******************************\n"
                + "1 - buylandview\n"
                + "2 - feed peopleview\n"
                + "3 - plantCropView\n"
                + "4 - runCropView\n"
                + "5 - sellLandView\n"
                + "6 - exit to main menu\n";
                
        max = 6;
    }

    //The displayGameMenu method.
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
    
    public void doAction (int option){
        switch (option){
            case 1: //View the Map
                buyLandView();
                break;
            case 2: //View/Print a List
                feedPeopleView();
                break;
            case 3: //Move to a new location
                plantCropsView();
                break;
            case 4: //Manage the crops
                runCropsView();
                break;
            case 5: 
                sellLandView();
                break;
            case 6:
                
                //Return to the main menu
                // Main Menu View
                MainMenuView mmv = new MainMenuView();
                mmv.displayMenuView();
        }
    }
    

//The runCropsView method()
//Purpose: runs the Hamurabi game
//Parameters: none
//Return: none
public static void runCropsView()
{
    
//call the buyLandView() method
//buyLandView();

//add calls to the other crop view methods
//sellLandView();

// The feedPeopleView method
//feedPeopleView(){}

//plantCropsView();

//showStarvedView();
//displayCropsReportView();
}




//The buyLandView method
//Purpose: interface with the user input for buying land.
//Parameters: none
//Return: none
public static void buyLandView()
{
    //Get the cost of land for this round.
    int price = CropControl.calcLandCost();
    
    //Set value of land to sell as same as to buy
    sellLandPrice = price;
    
    //Prompt the user to enter the number of acres to buy
    System.out.format("Land is selling for %d bushels per acre. %n",price);
    System.out.format("\nHow many acres of land do you wish to buy?");
    
    //Get the user's input and save it.
    int toBuy;
    toBuy = keyboard.nextInt();
    
    //Call the buyLand() method in the control layer to buy the land. 
    CropControl.buyLand(price, toBuy, cropData);   
}

// The plantCropsView method
// Purpose: To interface with the user to plant crops
//      works with the AcresToPlant control method
// Parameters: none
// Return: AcresPlanted
// Author: Sterling Kendall
public static void plantCropsView() {
    // Prompt the user for acres of land to plant
    // One bushel will plant two acres of land
    System.out.println("It takes 1 bushel to plant 2 acres. "
            + "\nHow many acres would you like to plant?");
    // Get the user input 
    int acresToPlant = keyboard.nextInt();
    // call the AcresToPlant() method in the control layer
    int acresPlanted = CropControl.AcresToPlant(acresToPlant, cropData);
        while(acresPlanted == -1)
    {
        acresToPlant = keyboard.nextInt();
        acresPlanted = CropControl.AcresToPlant(acresToPlant, cropData);
    }
    // Display acres planted
    System.out.println(acresPlanted);
}

// the sellLandView method
// Purpose : to interface with use to the sell land methods
// parameters : none
// return : new acreage amount
// Author : James Rasmussen
public static void sellLandView()
{
    //Prompt the user to enter the number of acres to sell
    System.out.println("Land is selling for " + sellLandPrice
            + " bushels per acre.\n");
    System.out.format("\nHow many acres of land do you wish to sell?\n");
    
    //Get the user's input and save it.
    int toSell = keyboard.nextInt();
    
    //Call the sellLand() method in the control layer to sell the land. 
    int successCheck = CropControl.sellLand(sellLandPrice, toSell, cropData); 
    while(successCheck == -1)
    {
        toSell = keyboard.nextInt();
        successCheck = CropControl.sellLand(sellLandPrice, toSell, cropData);
    }
    System.out.format("You now own %d acres of land.", successCheck);
}

    //the feedPeopleView method
    //Purpose: To interface with the user to use feed people methods
    //Purpose: none
    //Return: amount of bushels of wheat for the people
    //Author: J.J. Hugh
public static void feedPeopleView(){
   
    //Get the Wheat in Store set aside for the people
    // int WheatInStore = CropControl.feedPeople();
    int wheatInStore = cropData.getWheatInStore();
    //Prompt the user for buschels of grain wanted to give to the people.
    //Display the amount of wheat set aside for the people.
    System.out.println("You currently have " + wheatInStore + " available in "
            + "your storehouse.");
    System.out.println("\nHow many bushels of grain do you want to give to the "
            + "people?\n");
    
    //Get user's input and save it.
    int forPeople = keyboard.nextInt();
    
    //call the feedPeople() method in the control layer to sell the land.
    int fedPeople = CropControl.feedPeople(forPeople, cropData);
        while(fedPeople == -1)
    {
        forPeople = keyboard.nextInt();
        fedPeople = CropControl.feedPeople(forPeople, cropData);
    }
    //Display wheat used for the people
    System.out.println("You curretnly have " + fedPeople 
            + " bushel in the store.");
    
}
}