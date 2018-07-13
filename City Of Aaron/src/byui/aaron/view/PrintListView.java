/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.aaron.view;
import byui260.aaron.model.TeamMember;
import byui260.aaron.model.Game;
import byui260.aaron.model.ListItem;
import byui260.aaron.control.GameControl;
import java.util.Scanner;
import city.of.aaron.CityOfAaron;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Sterling Kendall
 */
public class PrintListView extends MenuView {
    private static Game theGame = CityOfAaron.getCurrentGame();
    //The newGameMenuView Constructor
    //Purpose: Initialize the menu Data
    //Parameters: none
    //Return: none    
    public PrintListView(){
        super("\n" + "*****************************\n" 
                + "*City of Aaron: LIST MENU*\n "
                + "******************************\n"
                + "1 - The animals in the storehouse\n"
                + "2 - The tools in the storehouse\n"
                + "3 - The provisions in the storehouse\n"
                + "4 - The authors of the game\n"
                + "5 - Return to the main menu.\n",
                5);
    }
    
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

    @Override public void doAction (int option){ 
        switch (option){
            case 1: //View / Print List of Animals
                if(offerChoice() == 0)
                    displayAnimals();
                else
                    listReport(theGame.getAnimals());
                break;                
            case 2: //View/Print List of Tools
                if(offerChoice() == 0){
                displayTools();
                }else {
                    printTools();
                }
                break;
            case 3: //View / Print List of Provisions
                if(offerChoice() == 0)
                    displayProvisions();
                else
                    listReport(theGame.getProvisions());
                break;                
            case 4: //Display the Authors of the code
                displayAuthors();
                break;
            case 5: 
                //Return to the main menu
                return;
        } 
    }
    
    public static int offerChoice() {
        int input = 2;
        System.out.println("Would you like to save the list to a disk,\n"
                + "or view it?\n Press 0 to View, or 1 to print");
        String joke = "To hear this message again, please input 7";
        do{
            input = keyboard.nextInt();
            if(input < 0 || input > 1)
            {
                System.out.println("\nPlease enter a valid option");
            }
        }
        while(input < 0 || input > 1);
        return input;
    }
    public static void displayAnimals(){   
        
//        System.out.println("\nYou have these animals: " 
//                            + GameControl.createAnimalList());
            ArrayList<ListItem> animals = theGame.getAnimals();       
            for (ListItem animal:animals){
            System.out.println(animal.getName()+" "+animal.getNumber());
        }
    }    
    public void displayTools(){
        // Sterling
//        System.out.println("These are the tools you have:"
//                + GameControl.createToolsList());      
        ArrayList<ListItem> tools = theGame.getTools();       
            for (ListItem tool:tools){
            System.out.println(tool.getName()+" "+tool.getNumber());
    }
    }
    public void printTools() {
        // Sterling
        ArrayList<ListItem> tools = theGame.getTools();
        
        keyboard.nextLine();
        // prompt user and get a file path
        System.out.println("\nPlease type the location to print the list");
        String fp = keyboard.nextLine();
        
        // call the setSavedGame() method in the Game Control class to
        // save the game
        // GameControl.setSavedGame(fp);
        // create a bufferedreader object for input object
        try(PrintWriter out = new PrintWriter(fp)){
            // Print title and column headings
            out.println("\n\n       Tools List         ");
            out.printf("%n%-20s%10s", "Name", "Quantity");
            out.printf("%n%-20s%10s", "----", "--------");
            
            // Print the Name and quantity of each item
            for(ListItem tool: tools){
                out.printf("%n%-20s%7d", tool.getName()
                                       , tool.getNumber());
            }
        }   catch(IOException ex){
            System.out.println("I/O error: unable to print list");
        }        
    }
    public void displayProvisions(){
        // System.out.println("\nHere are the provisions: " + GameControl.createProvisionsList());   
     ArrayList<ListItem> provisions = theGame.getProvisions();       
            for (ListItem provision:provisions){
            System.out.println(provision.getName()+" "+provision.getNumber());
            }
    }
    
    public void displayAuthors(){
        //TeamMember java bean
        String memberName1 = TeamMember.one.getMemberName();
        String memberTitle1 = TeamMember.one.getMemberTitle();
        
        String memberName2 = TeamMember.two.getMemberName();
        String memberTitle2 = TeamMember.two.getMemberTitle();
        
        String memberName3 = TeamMember.three.getMemberName();
        String memberTitle3 = TeamMember.three.getMemberTitle();
       
    System.out.println(memberName1 + " " + memberTitle1 + "\n"
            + memberName2 + " " + memberTitle2 + "\n" + memberName3 
            + " " + memberTitle3);
    }
    
    //The listWriter method
    //Purpose: to write a list to a drive
    //Parameters: ARRAY
    //Return: none  
    
    public void listReport(ArrayList<ListItem> list) {
        
    //declare a string to hold the file name
    String outputLocation;
    
    
    //prompt the user for a file name, get and save the users input
    System.out.println("Please enter a file name");
    keyboard.nextLine();
    outputLocation = keyboard.nextLine();
    
    try (PrintWriter out = new PrintWriter(outputLocation))
        {
            
        //output a heading for the report
            out.println("\n\n                  List Report               ");
            out.printf("%n%-20s%10s", "Description","Quantity");
            out.printf("%n%-20s%10s", "-----------", "--------");
            
            
        //use a for loop to get the data from the arrayList and output
            for (ListItem List : list) {
                out.printf("%n%-20s%7d", List.getName()
                                       , List.getNumber());
            }
            
        }
    catch(IOException ex)
        {
            System.out.println("I/O Error: " + ex.getMessage());
        }
    }    
}
