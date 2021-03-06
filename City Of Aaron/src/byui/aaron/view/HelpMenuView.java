/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.aaron.view;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class HelpMenuView extends MenuView {

    // Help Menu View method
    // Purpose : To save a menu view for the help menu
    // Parameters : none
    // returns :  none
    // Author : James
    public HelpMenuView() {
        
        //initialize HelpMenuView
        super("\n" + "*******************************\n"
                + "Help Menu:\n"
                + "\t1 - What are the goals of the game?\n"
                + "\t2 - What is the city of Aaron?\n"
                + "\t3 - How do I view the map?\n"
                + "\t4 - How do I move to another location?\n"
                + "\t5 - How do I display a list of animals, provisions,"
                + " and tools in the city storehouse?\n"
                + "\t6 - Back to the Main Menu.",
                6);
    }
    
    // The displayHelpMenuView method
    // Purpose: Display the help menu view
    // parameters: none
    // returns: none
    // Author : James
    // =====================================================
    public void displayHelpMenuView(){
        int option;
        // Display Menu after every option but quit
        do {
            
            //display the menu
            System.out.println(theMenu);
            
            //get user input
            option = getMenuOption();
            
            //execute appropriate menu option.
            doAction(option);
            
        } while(option != max);
    }
    

    
    // the doHelpMenuFunction
    // Purpose : Execute aid for weary player
    // Parameters : option selected
    // returns : none
    // Author : James
    
    @Override public void doAction(int option) {
        switch(option)
        {
            case 1: 
                gameHelp();
                break;
            case 2:
                whatIsCityHelp();
                break;
            case 3:
                mapHelp();
                break;
            case 4:
                movingHelp();
                break;
            case 5:
                possessionsHelp();
                break;
            case 6:
                System.out.println("Exiting help menu\n");
        }
    }
    
    // Help explanation methods
    public void gameHelp() {
        System.out.println("Goals of game help\n");
    }
    public void whatIsCityHelp() {
        System.out.println("What City of Aaron is help\n");
    }
    public void mapHelp() {
        System.out.println("Map viewing help\n");
    }
    public void movingHelp() {
        System.out.println("Moving location help\n");
    }
    public void possessionsHelp() {
        System.out.println("Display possessions help\n");
    }
}
