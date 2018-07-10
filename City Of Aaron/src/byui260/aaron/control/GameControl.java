/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui260.aaron.control;

import java.util.ArrayList;
import city.of.aaron.CityOfAaron;
import byui260.aaron.model.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 *
 * @author User
 */
public class GameControl {
    //size of locations array
    private static final int MAX_ROW = 5;
    private static final int MAX_COL = 5;
    private static ArrayList animals;
    private static ArrayList provisions;

    //reference to a game object
    private static Game theGame;
    
    public static void createNewGame( String name)
    {
        //create game object. Save in main driver file
        theGame = new Game();
        CityOfAaron.setCurrentGame(theGame);
        
        //create player object. Save in game object.
        Player thePlayer = new Player();
        thePlayer.setPlayerName(name);
        theGame.setThePlayer(thePlayer);
        
        //create CropData object
        createCropDataObject();
        
        //create list of animals
        animals = createAnimalList();
        
        //create list of tools
        createToolsList();
        
        //create list of provisions
        provisions = createProvisionsList();
        
        //create the Locations and the Map object.
        createMap();
    }
    
    // the getSavedGame method
    // Purpose: load a saved game from disk
    // Parameters: the file path
    // Returns: none
    // Side Effect: the game reference in the driver is updated 
    public static void getSavedGame(String filePath)
    {
        Game theGame = null;
        try (FileInputStream fips = new FileInputStream(filePath))
        {
            ObjectInputStream input = new ObjectInputStream(fips);
            theGame = (Game)  input.readObject();
            CityOfAaron.setCurrentGame(theGame);
        }catch(Exception e)
        {
            System.out.println("\nThere was an error "
                    + "reading the saved game file");
        }
    }
    
    // the setSavedGame method
    // Purpose: savethe current game to disk
    // Parameters: the file path
    // Returns: none
    // Side Effect: the game reference in the driver is updated 
    public static void setSavedGame(String filePath)
    {
        Game theGame = null;
        try (FileOutputStream fops = new FileOutputStream(filePath))
        {
            ObjectOutputStream output = new ObjectOutputStream(fops);
            theGame = (Game)  output.writeObject(theGame);
        }catch(Exception e)
        {
            System.out.println("\nThere was an error "
                    + "saving the game file");
        }
    }

    //PROLOGUE
    public static void createCropDataObject()
    {
        CropData theCrops = new CropData();
        
        theCrops.setYear(0);
        theCrops.setPopulation(100);
        theCrops.setNewPeople(5);
        theCrops.setCropYield(3);
        theCrops.setNumberWhoDied(0);
        theCrops.setOffering(10);
        theCrops.setWheatInStore(2700);
        theCrops.setAcresOwned(1000);
        theCrops.setAcresPlanted(1000);
        theCrops.setHarvest(3000);
        theCrops.setOfferingBushels(300);
        theCrops.setAcresPlanted(1000); 

        theGame.setCropData(theCrops);         
    }
    
    //The createAnimalList method
    //Purpose: creates an array list of animals
    //Parameters: none
    //Returns: animal list
    public static ArrayList createAnimalList()
    {
        ArrayList<ListItem> animals = new ArrayList<>();
        
        animals.add(new ListItem("Cureloms", 5));
        animals.add(new ListItem("Half eaten cucumber", 1));
        animals.add(new ListItem("Pet rocks", 327));
        animals.add(new ListItem("Universal Answers", 42));
        theGame.setAnimals(animals);
         return animals;
    }


    //The createToolsList method
    //Purpose: creates an array list of tools
    //Parameters: none
    //Returns: none
    public static ArrayList createToolsList()
    {
        ArrayList<ListItem> tools = new ArrayList<>();
        
        tools.add(new ListItem("Hammer", 13));
        tools.add(new ListItem("Half eaten cucumber", 1));
        tools.add(new ListItem("HackSaw", 7));
        tools.add(new ListItem("Measuring Tape", 1000));
        
        theGame.setTools(tools);
        return tools;
    }
    
    //The createProvisionsList method
    //Purpose: creates an array list of provisions
    //Parameters: none
    //Returns: none
    public static ArrayList<ListItem> createProvisionsList()
    {
        ArrayList<ListItem> provisions = new ArrayList<>();
        
        provisions.add(new ListItem("Bacon in Pounds", 200));
        provisions.add(new ListItem("Half eaten cucumber", 1));
        provisions.add(new ListItem("Strawberries", 19));
        provisions.add(new ListItem("Lego Bricks", 3596473));
        
        theGame.setProvisions(provisions);
   
        theGame.setProvisions(provisions);
        return provisions;
    }
    
    //The createMap method
    //Purpose: creates the location objects and the map
    //Parameters: none
    //Returns: none
    public static void createMap()
    {
        //create the Map object, it is 5x5
        Map theMap = new Map(MAX_ROW, MAX_COL);
        
        //Map discriptors
        String river = "\nA winding river stretches before you.\nIt's super"
                + " fresh, and provides much needed water to the city";
        String darkWoodForest = "\nThis forest looks ominous, but "
                + "on the\nother hand, it's obviously very good at growing"
                + "things. Good for wood too.";
        String swamp = "\nswamp";
        String rollingHills = "\nrHills";
        String candyCaneForest = "\nccForest";
        String desert = "\nDesert";
        String dessert = "\nDessert";
        String asicsOasis = "\nAsicsOasis";
        String plain = "\nplain";
        String kFC = "\nKFC";
        
        //create a new Location object
        Location loc = new Location();
        
        //use setters in the location class to set the description and symbol 
        loc.setDescription(river );
        loc.setSymbol("~~~");
        
        theMap.setLocation(2, 0, loc);
        for(int i = 2; i < MAX_ROW; i++)
        {
            theMap.setLocation(i, 1, loc);
        }
        
        loc = new Location();
        loc.setDescription(darkWoodForest);
        loc.setSymbol("^^^");
        theMap.setLocation(0, 1, loc);
        theMap.setLocation(0, 2, loc);
        theMap.setLocation(1, 1, loc);
        
        loc = new Location();
        loc.setDescription(swamp);
        loc.setSymbol("www");
        theMap.setLocation(1,0, loc);
        
        loc = new Location();
        loc.setDescription(rollingHills);
        loc.setSymbol("mmm");
        theMap.setLocation(3, 0, loc);
        theMap.setLocation(4, 0, loc);
        theMap.setLocation(1, 3, loc);
        
        loc = new Location();
        loc.setDescription(candyCaneForest);
        loc.setSymbol("JJJ");
        theMap.setLocation(0, 0, loc);
        
        loc = new Location();
        loc.setDescription(desert);
        loc.setSymbol("---");
        for(int i = 3; i < MAX_COL; i++)
        {
             theMap.setLocation(i, 3, loc);
        }
        theMap.setLocation(2, 4, loc);
        theMap.setLocation(4, 2, loc);
        
        loc = new Location();
        loc.setDescription(dessert);
        loc.setSymbol("===");
        theMap.setLocation(3, 4, loc);
        
        loc = new Location();
        loc.setDescription(asicsOasis);
        loc.setSymbol("L_>");
        theMap.setLocation(4, 4, loc);
        
        loc = new Location();
        loc.setDescription(plain);
        loc.setSymbol("!!!");
        for(int i = 1; i < 4; i++)
        {
             theMap.setLocation(i, 2, loc);
        }
        theMap.setLocation(0, 3, loc);
        theMap.setLocation(1, 4, loc);
        theMap.setLocation(2, 3, loc);
        
        loc = new Location();
        loc.setDescription(plain);
        loc.setSymbol("KFC");
        theMap.setLocation(0, 4, loc);
        
        theGame.setTheMap(theMap);
    }
    
}
