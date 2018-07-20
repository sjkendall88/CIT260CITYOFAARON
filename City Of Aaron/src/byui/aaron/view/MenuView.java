/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *The MenuView class - base abstract class for all menu views
 *Authors: James Rassmussen, Sterling Kendall, J.J. Hugh
 *Date: June 19 2018
 */
package byui.aaron.view;
import city.of.aaron.CityOfAaron;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;
    
public abstract class MenuView implements ViewInterface {
    protected final static Scanner keyboard = new Scanner(System.in);
    // protected final BufferedReader keyboard = CityOfAaron.getInFile();
    // protected final PrintWriter console = CityOfAaron.getOutFile();
    protected String theMenu; //this string holds the menu string 
    protected int max; // this int holds the max input value
    
    //MenuView Constructor
    //Purpose: Initialize the view object with the menu string
    //Parameters: the menu string and the max value
    //Return: none
    public MenuView(String _menu, int _max){
        theMenu = _menu;
        max = _max;
    }
    
    // The displayMainMenu method
    // Purpose: displays the menu, gets the user input
    //          and does the selected action
    // Parameters: none
    // Returns: none
    // ========================================
    @Override public void displayMenu(){
        
        //execute this loop as long as the selected option is not max
        int menuOption = 0;
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
    @Override public int getMenuOption(){
        //declare a variable to hold the input
        int userInput;
        // begin loop
        do {
            System.out.format("\nPlease enter an option(1 - %d):", max);
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
}
