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

// referential variable to stabilize value of Land value on a given round.
public static int sellLandPrice;
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

// the sellLandView method
// Purpose : to interface with use to the sell land methods
// parameters : none
// return : new acreage amount
// Author : James Rasmussen
public static void sellLandView()
{
    //Prompt the user to enter the number of acres to sell
    System.out.format("Land is selling for %d bushels per "
            + "acre. %n",sellLandPrice);
    System.out.format("\nHow many acres of land do you wish to sell?");
    
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
    int WheatInStore = CropControl.feedPeople();
    
    //Prompt the user for buschels of grain wanted to give to the people.
    //Display the amount of wheat set aside for the people.
    System.out.println("You currently have" + WheatInStore + "available in your storehouse.");
    System.out.println("\nHow many bushels of grain do you want to give to the people");
    
    //Get user's input and save it.
    int forPeople = keyboard.nextInt();
    
    //call the feedPeople() method in the control layer to sell the land.
    int WheatUsed = CropControl.feedPeople(forPeople, cropData);
    
    //Display wheat used for the people
    System.out.println("you have" +  WheatUsed + "for the people");
    
}
}