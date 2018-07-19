/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.aaron.view;
import byui260.aaron.model.Game;
import byui260.aaron.model.Location;
import byui260.aaron.model.Map;
import city.of.aaron.CityOfAaron;
import java.util.Scanner;


/**
 *
 * @author J.J. Hugh
 */
public class NewGameMenu extends MenuView {
    
    //reference to game object
    private static Game theGame;
    
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
    
    // the displayMap method
    // purpose: Display map of region at users whim, and explain map
    // parameters: none
    // return: none
    public void displayMap(){
        
        //obtain references needed
        theGame = CityOfAaron.getCurrentGame();
        Map theMap = theGame.getTheMap();
        
        //output header for map
        System.out.println("\n ********HERE IS THE MAP********\n" +
                "     1     2     3     4     5");
        
        //begin loops to display map
        int x = 0;
        int y = 0;
        for(; y < 5; y++)
        {
            System.out.print("\n " + (y + 1) + " | ");
            for(; x < 5; x++)
            {
                System.out.print(theMap.getLocation(x, y).getSymbol() +
                        " | ");
            }
        x = 0;
        }
        
        //display legend
        System.out.println("\nLegend:\n'~~~' = River\n'^^^' = DarkWood Forest" +
                "\n'www' = Swamp\n'mmm' = Rolling Hills\n'JJJ' = CandyCane " +
                "Forest\n'---' = Desert\n'===' = Dessert\n'L_>' = Asics Oasis" +
                "\n'!!!' = Plains\n\nFor more information, type a co-ordinate" +
                "or simply \"0\" to return.");
        /*
        * THIS IS EXTRA BONUS CODE. I figured it'd be neat to also see the 
        * discription of certain areas on the map. It's complete in terms of 
        * giving descriptions when integers are input, but I'm still on the 
        * fence if it deserves the hassle of a try-catch and new method 
        * in case users feel String happy in place of 'int's. As it's extra
        * I may not get around to it.
        */
        Boolean again = true;
        x = 6;
        do
        {
            do
            {
                System.out.println("An X position of ?");
                x = keyboard.nextInt();                       ;
                if(x < 0 || x > 5)
                    System.out.println("Numbers between 0 and 5 please");
            }while(x < 0 || x > 5);
            if(x == 0)
                again = false;
            else
            {
                do{
                    System.out.println("And a position for Y?");
                    y = keyboard.nextInt();
                    if(y < 1 || y > 5)
                        System.out.println("Numbers between 1 and 5 please");
                } while (y < 1 || y > 5);
                System.out.println(
                        theMap.getLocation((x - 1), (y - 1)).getDescription()
                + "\n");
            }
        }while(again);
        
        
        
        //here = theMap.getLocation(0, 0);
        //System.out.println(here.getSymbol());
        //System.out.println(theMap.getLocation(0, 1).getSymbol());
        
    }   
    
    public void startMove(){
    System.out.println("\nMoving to a new location Soon");
    }
    /*
    public void startManageCrops();
    */     
       
}      
