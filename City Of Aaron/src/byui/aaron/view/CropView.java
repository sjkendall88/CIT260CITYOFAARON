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
import exceptions.CropException;

/**
 *
 * @author JRome
 */
public class CropView extends MenuView {
    
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
        super( "\n" + "**********************\n" 
                + "*Debug: CropView testing phase *\n"
                + "******************************\n"
                + "1 - buylandview\n"
                + "2 - feed peopleview\n"
                + "3 - plantCropView\n"
                + "4 - setOfferingView\n"
                + "5 - sellLandView\n"
                + "6 - exit to main menu\n",
        6);
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
                runCropsView();
                break;
            case 4: //Manage the crops
                setOfferingView();
                break;
            case 5: 
                sellLandView();
                break;
            case 6:                
                //Return to the main menu
                // Main Menu View
                MainMenuView mmv = new MainMenuView();
                mmv.displayMenu();
        }
    }
    
//The setOfferingView method()
//Purpose: User sets offering
//Param: none
//return: none
public static void setOfferingView()
{
    int offering;
    boolean paramsNotOkay = false;
    
    //For loop until valid input
    do
    {
        
        System.out.println("Please set your offerings ot the Lord this year.");
        if(!paramsNotOkay)
            System.out.println("\n It should be a percentage between 0 and 100.");
        paramsNotOkay = false;
        offering = keyboard.nextInt();
        try
        {
            CropControl.setOffering(offering, cropData);
        }
        catch(CropException e)
        {
            System.out.println("\nI am sorry master, I cannot do this.");
            System.out.println(e.getMessage());
            paramsNotOkay = true;    
        }
    }while(paramsNotOkay);
    System.out.println("Thanks for your offering!");
}

//The runCropsView method()
//Purpose: runs the City of Aaron game
//Parameters: none
//Return: none
//Author: Sterling
public static void runCropsView(){
    
    /*
    //call the buyLandView() method
    buyLandView();

    //add calls to the other crop view methods
    sellLandView();

    //The feedPeopleView method
    feedPeopleView();

    //plantCropsView();
    plantCropsView();
    
    //setOffering()
    setOffering();
    
    //harvestCrops()
    harvestCrops();
    
    //payOffering()
    payOffering();
    
    //calcEatenByRats()
    calcEatenByRats();
    
    //growPopulation()
    growPopulation();
    
    //showStarvedView();
    showStarvedView();
    
    //displayCropsReportView();
    displayCropsReportView();
    */
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
    
    //initialize toBuy
    int toBuy;
    
    //Loop to get user input while input is valid
    boolean paramsNotOkay;
    do
    {
        paramsNotOkay = false;
        System.out.println("\nHow many acres of land do you wish to buy? ");
        toBuy = keyboard.nextInt();
        try
        {
            CropControl.buyLand(price, toBuy, cropData);
        }
        catch(CropException e)
        {
            System.out.println("I am sorry master, I cannot do this.");
            System.out.println(e.getMessage());
            paramsNotOkay = true;
        }
    } while(paramsNotOkay);
    System.out.println("Thank you for buying land!");
}

// The plantCropsView method
// Purpose: To interface with the user to plant crops
//      works with the AcresToPlant control method
// Parameters: none
// Return: AcresPlanted
// Author: Sterling Kendall
public static void plantCropsView() {
    int acresToPlant;
    boolean paramsNotOkay;
    
    // For loop until valid input
    do {
        
            paramsNotOkay = false;
            try{
                // Prompt the user for acres of land to plant
                // One bushel will plant two acres of land
                System.out.println("It takes 1 bushel to plant 2 acres. "
                + "\nHow many acres would you like to plant?");
                // Get the user input 
                acresToPlant = keyboard.nextInt();
                // call the AcresToPlant() method in the control layer
                CropControl.AcresToPlant(acresToPlant, cropData);
            }
            catch(CropException e)
            {
                System.out.println("Please enter a valid number");
                System.out.println(e.getMessage());
                paramsNotOkay = true;
            }
    }while(paramsNotOkay);
    System.out.println("Thank you for planting!");
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
        System.out.println("Please enter a valid number");
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
    int wheatInStore = cropData.getWheatInStore();
    //Prompt the user for buschels of grain wanted to give to the people.
    //Display the amount of wheat set aside for the people.
    System.out.println("You currently have " + wheatInStore + " available in "
            + "your storehouse.");
    System.out.println("\nHow many bushels of grain do you want to give to the "
            + "people?\n");
    
    int forPeople;
    boolean paramsNotOkay;
    
    do{
        
    //Get user's input and save it.
    paramsNotOkay = false;
    forPeople = keyboard.nextInt();
    try{
    //call the feedPeople() method in the control layer to sell the land.
    CropControl.feedPeople(forPeople, cropData);
       // while(fedPeople == -1)
    }
       
    catch(CropException e)
    {
        System.out.println("Please enter a valid number");
        System.out.println(e.getMessage());
        paramsNotOkay = true;
   
        }
    }while(paramsNotOkay);
    System.out.println("Thank you for feeding my people");
}

// The cropReportView() Method
// Purpose: To display the current data list
// Parameter: cropdata
// Returns: none
// Author: Sterling
public static void CropReportView() {
    // call to cropReport
    CropControl.CropReportView(cropData);
}
}
