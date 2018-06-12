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
    
  //feedPeopleView method
    
    

//Create a Scanner object.
private static Scanner keyboard = new Scanner(System.in);

//Get references to the Game object and the CropData object.
private static Game theGame = CityOfAaron.getCurrentGame();
private static CropData cropData = theGame.getCropData();

//The runCropsView method()
//Purpose: runs the Hamurabi game
//Parameters: none
//Return: none
public static void runCropsView()
{
    
//call the buyLandView() method
buyLandView();

//add calls to the other crop view methods
//sellLandView();

// The feedPeopleView method
//feedPeopleView(){}

plantCropsView();

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
    //Prompt the user to enter the number of acres to buy
    System.out.format("Land is selling for %d bushels per acre. %n",price);
    System.out.format("\nHow many acres of land do you wish to buy?");
    
    //Get the user's input and save it.
    int toBuy;
    toBuy = keyboard.nextInt();
    
    //Call the buyLand() method in the control layer to buy the land. 
    CropControl.buyLand(toBuy, price, cropData);   
}

// The plantCropsView method
// Purpose: To interface with the user to plant crops
//      works with the AcresToPlant control method
// Parameters: none
// Return: AcresPlanted
// Author: Sterling Kendall
public static void plantCropsView () {
    // Prompt the user for acres of land to plant
    // One bushel will plant two acres of land
    System.out.println("It takes 1 bushel to plant 2 acres. "
            + "\nHow many acres would you like to plant?");
    // Get the user input 
    int acresToPlant = keyboard.nextInt();
    // call the AcresToPlant() method in the control layer
    int acresPlanted = CropControl.AcresToPlant(acresToPlant, cropData);
    // Display acres planted
    System.out.println(acresPlanted);
}

}