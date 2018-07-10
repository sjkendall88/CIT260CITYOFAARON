/*
 * The main () class file to the cityOfAaron project.
 * CIT-260
 * Spring 2018
 * Team members: JJ Hugh, James Rasmussen, and Sterling Kendall.
 */
package city.of.aaron;

import byui260.aaron.model.CropData;
import byui260.aaron.model.Game;
import byui260.aaron.model.ListItem;
import byui260.aaron.model.Location;
import byui260.aaron.model.Player;
import byui260.aaron.model.TeamMember;
import byui.aaron.view.*;

/**
 *
 * @author James Rasmussen, JJ Hugh, and Sterling Kendall
 */
public class CityOfAaron {
    
    // Variable for keeping a reference to the game object
    private static Game theGame = null;
    private static PrintWriter = null;
    private static BufferedReader = null;
    
    // main function - entry point for the program
    // runs the main menu
    public static void main(String[] args) {
        
        // Getter method
        
        /*
        //Player java bean
        Player playerOne = new Player();      
        playerOne.setPlayerName("Sterling");       
        String playerOneName = playerOne.getPlayerName();        
        System.out.println("Name = " + playerOneName);
        
        //TeamMember
        String memberName = TeamMember.one.getMemberName();
        String memberTitle = TeamMember.one.getMemberTitle();
        System.out.println(memberName + " " + memberTitle);
        
        //Location
        Location locationOne = new Location();
        locationOne.setDescription("Here");
        locationOne.setSymbol("City");
        String locationOneDescription = locationOne.getDescription();
        String locationOneSymbol = locationOne.getSymbol();
        System.out.println(locationOneSymbol + " " + locationOneDescription);
        
        
        //ListItem  
        ListItem listItemOne = new ListItem();
        listItemOne.setName("Help");
        listItemOne.setNumber(Integer.SIZE);
        String listItemOneName = listItemOne.getName();
        Integer listItemOneNumber = listItemOne.getNumber();
        System.out.println(listItemOneNumber + " " + listItemOneName);
        
        //CropData
        CropData cropDataOne = new CropData();
        cropDataOne.setYear(listItemOneNumber);
        cropDataOne.setPopulation(listItemOneNumber);
        cropDataOne.setAcresOwned(listItemOneNumber);
        cropDataOne.setCropYield(listItemOneNumber);
        cropDataOne.setWheatInStore(listItemOneNumber);
        cropDataOne.setNumberWhoDied(listItemOneNumber);
        cropDataOne.setNewPeople(listItemOneNumber);
        cropDataOne.setHarvest(listItemOneNumber);
        cropDataOne.setHarvestAfterOffering(listItemOneNumber);
        cropDataOne.setOffering(listItemOneNumber);
        cropDataOne.setOfferingBushels(listItemOneNumber);
        cropDataOne.setPeopleFed(listItemOneNumber);
        cropDataOne.setAcresPlanted(listItemOneNumber);
        cropDataOne.setNumStarved(listItemOneNumber);
        cropDataOne.setEatenByRats(listItemOneNumber);
        cropDataOne.setWheatForPeople(listItemOneNumber);
        
        //Getter
        Integer cropDataOneYear = cropDataOne.getYear();
        Integer cropDataOnePopulation = cropDataOne.getPopulation();
        Integer cropDataOneAcresOwned = cropDataOne.getAcresOwned();
        Integer cropDataOneCropYield = cropDataOne.getCropYield();
        Integer cropDataOneWheatInStore = cropDataOne.getWheatInStore();
        Integer cropDataNumberWhoDied = cropDataOne.getNumberWhoDied();
        Integer cropDataNewPeople = cropDataOne.getNewPeople();
        Integer cropDataHarvest = cropDataOne.getHarvest();
        Integer cropDataHarvestAfterOffering = cropDataOne.getHarvestAfterOffering();
        Integer cropDataOffering = cropDataOne.getOffering();
        Integer cropDataOfferingBushels = cropDataOne.getOfferingBushels();
        Integer cropDataPeopleFed = cropDataOne.getPeopleFed();
        Integer cropDataAcresPlanted = cropDataOne.getAcresPlanted();
        Integer cropDataNumStarved = cropDataOne.getNumStarved();
        Integer cropDataEatenByRats = cropDataOne.getEatenByRats();
        Integer cropDataWheatForPeople = cropDataOne.getWheatForPeople();
        System.out.println(cropDataOne.toString());
        */
        // Game java bean
        
        
        // Main Menu View
        MainMenuView mmv = new MainMenuView();
        mmv.displayMenu();
    }

    public static Game getCurrentGame() {
        return theGame;
    }

    public static void setCurrentGame(Game theGame) {
        CityOfAaron.theGame = theGame;
    }
    
    public static PrintWriter getOutFile(){
        return outFile;
    }
    
    public static void setOutFile(PrintWriter outfile){
        CityOfAaron.outFile = outFile;
    }
    
    public static BufferedReader getInFile(){
        return inFile;
    }
    
    public static void setInFile(BufferedReader inFile){
        CityOfAaron.inFile = inFile;
    }
}
