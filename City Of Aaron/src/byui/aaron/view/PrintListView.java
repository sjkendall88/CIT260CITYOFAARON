/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.aaron.view;
import byui260.aaron.model.TeamMember;
import java.util.Scanner;

/**
 *
 * @author Sterling Kendall
 */
public class PrintListView extends MenuView {
    Scanner keyboard = new Scanner(System.in);
    private String theMenu;
    private int max;
 
    //The newGameMenuView Constructor
    //Purpose: Initialize the menu Data
    //Parameters: none
    //Return: none    
    public PrintListView(){
        super("\n" + "**********************\n" 
                + "*City of Aaron: View / Print List *\n"
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
                displayAnimals();
                break;                
            case 2: //View/Print List of Tools
                displayTools();
                break;
            case 3: //View / Print List of Provisions
                displayProvisions();
                break;                
            case 4: //Display the Authors of the code
                displayAuthors();
                break;
            case 5: 
                //Return to the main menu
                // Main Menu View
               //Display the game menu
        NewGameMenu ngmv = new NewGameMenu(); 
        ngmv.displayGameMenuView();
        } 
    }
    public void displayAnimals(){   
    System.out.println("\nI ain't got no stinkin animals.");
    }    
    public void displayTools(){
    System.out.println("\nTools, Ha who needs tools.");   
    }
    public void displayProvisions(){
    System.out.println("\nWhat Provisions");
    }
    public void displayAuthors(){
        //TeamMember java bean
        String memberName1 = TeamMember.one.getMemberName();
        String memberTitle1 = TeamMember.one.getMemberTitle();
        
        String memberName2 = TeamMember.two.getMemberName();
        String memberTitle2 = TeamMember.two.getMemberTitle();
        
        String memberName3 = TeamMember.three.getMemberName();
        String memberTitle3 = TeamMember.three.getMemberTitle();
       
    System.out.println(memberName1 + " " + memberTitle1 + "\n"+ memberName2 + " " + memberTitle2 + "\n" + memberName3 + " " + memberTitle3);
    }
}
