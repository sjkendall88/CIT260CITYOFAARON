/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui260.aaron.control;
import byui.aaron.view.MainMenuView;
import byui260.aaron.model.CropData;
import static city.of.aaron.CityOfAaron.getCurrentGame;
import exceptions.CropException;
import java.util.Random;

/**
 *
 * @author James Rasmussen, JJ Hugh, and Sterling Kendall
 */
public class CropControl {
    
    //constants
    private static final int LAND_BASE = 17;
    private static final int LAND_RANGE = 10;
    private static final int RAT_RANGE = 100;
    private static final int LOW_BAR = 8;
    private static final int TO_PERC = 100;
    private static final int BUS_FEED = 20;
    private static final int CYCLE = 1;
   
    // random number generator
    private static Random random = new Random();
    
    // calcLandCost()method
    // Purpose: Calculate a random land price between 17 and 26 bushels/acre
    // Parameters: none
    // Returns: the land cost     
    public static int calcLandCost(){
        int landCost = random.nextInt(LAND_RANGE)+LAND_BASE;
        return landCost;
    }    
    
    // The sellLand method
    // Purpose: To sell land
    // Parameters: the price of land, the number of acres to sell, and 
    // a reference to a CropData object.
    // Returns: the number of acres owned after the sale
    // Pre-conditions: acres to sell must be positive
    // and  <= acresOwned
    
    public static int sellLand(int landPrice, int acresToSell, CropData cropData){
        
        // if acresToSell < 0, return -1
        if(acresToSell <0) {
            return -1;
        }
        
        // if acresToSell > acresOwned, return -1
        int owned = cropData.getAcresOwned();
        if(acresToSell > owned) {
            return -1;
        }
        
        // acresOwned -= acresToSell
        owned -= acresToSell;
        cropData.setAcresOwned(owned);
        
        // wheatInStore += (acresToSell * landPrice)
        int wheat = cropData.getWheatInStore();
        wheat += (acresToSell * landPrice);
        cropData.setWheatInStore(wheat);
        
        // return acresOwned
        return owned;
    }

    // The buyLand method
    // Purpose: to buy land
    // Parameters: the price of land, the number of acres to buy, and
    // the a reference to CropData.
    // Returns: The number of acres owned after purchase.
    // Pre-Conditions: acres to buy must be positive.
    public static void buyLand(int landPrice, int acresToBuy, CropData cropData) throws CropException{
                
        // if(acresToBuy < 0) throw exc
        if(acresToBuy < 0) {
            throw new CropException("A negative value was input");
        }
        
        // TotalCost = acresToBuy * landPrice
        int totalCost = acresToBuy * landPrice;
        
        // if totalCost > wheatOwned throw exc
        int wheatOwned = cropData.getWheatInStore();
        if(totalCost > wheatOwned) {
            throw new CropException("There is sufficient wheat "
                    + "to buy this much land");
        }
        
        // totalAcres = acresOwned + acresToBuy
        int acresOwned = cropData.getAcresOwned();
        int totalAcres = acresOwned + acresToBuy;

        // if population < totalAcres/10 throw exc
        int population = cropData.getPopulation();
        if(population < totalAcres/10) {
            throw new CropException("Not enough workers to work the fields");
        }

        // wheatOwned = wheatOwned - totalCost
        wheatOwned -= totalCost;
        cropData.setWheatInStore(wheatOwned);
        cropData.setAcresOwned(totalAcres);
    }
    
    // The AcresToPlant method
    // Purpose: to plant acres
    // Parameters: the number of acres to plant, and
    // the a reference to CropData.
    // Returns: The number of acres to plant.
    // Pre-Conditions: acres to plant must be positive.    
    // Auther: Sterling
    public static void AcresToPlant(int acresToPlant, CropData cropData) 
            throws CropException {
        
        // If (acresToPlant < 0) then return -1
        if(acresToPlant < 0) {
            throw new CropException ("Acres to plant must be a positive number. "
                    + "Please try again.");
        }
        
        // If (acresToPlant !<= acresOwned) then return -1
        int acresOwned = cropData.getAcresOwned();
        if(acresOwned < acresToPlant) {
            throw new CropException("You don't own enough acres to plant."
                    + "Please try again.");
        }
        
        // bushelsToPlant = acresToPlant / 2
        int bushelsToPlant = acresToPlant / 2;
        
        // If (wheatInStore !>= bushelsToPlant) then return -1
        int wheatInStore = cropData.getWheatInStore();
        if(wheatInStore < bushelsToPlant) {
            throw new CropException("You don't have enough Wheat to plant."
                    + "Please try again.");
        }
        
        // wheatInStore  = wheatInStore – bushelsToPlant
        wheatInStore -= bushelsToPlant;
        cropData.setWheatInStore(wheatInStore);
        
        // acresPlanted += acresToPlant
        cropData.setAcresPlanted(acresToPlant);        
    }
    
    // The setOffering method
    // Purpose: To set an offering percentage
    // Parameters: desired offering amount and a reference
    // to the CropData object
    // Returns: integer of offering amount
    // Pre-conditions: offering must be between 0 and 100
    public static void setOffering(int offering, CropData cropData) throws CropException {
        
        // IF 0 > offering or offering > 100 return thrown exception
        if (offering < 0 || offering > 100) {
            throw new CropException ("Percentages must be between 0 and 100");
        }
        
        // Set offering
        cropData.setOffering(offering);
        int currentWheat = cropData.getWheatInStore();
        int offeringAmount = currentWheat * offering / 100;
        currentWheat -= offeringAmount;
        cropData.setWheatInStore(currentWheat);
        checkOffering(offering, cropData);
    }
    
    
    //The checkOffering method
    // Purpose: To check the afterHarvestOffering amount
    // Parameters: Whether there is an offering amount and a reference to the GetOffering
    // Return: integer of offering amount in the store house.
    // Pre-condition: offering must be 0 otherwise display amount.
    public static void checkOffering(int offering, CropData cropData){
        
          //Author: J.J. Hugh
        //Display a message when 0 is offered for the offerings.
        if (offering > 0 ){
            
            int afterMath;
            System.out.println ("The amount of wheat in your storehouse after your offering is " + cropData.getWheatInStore());
            //System.out.println ("The amount of offerings in the store house: " + getCurrentGame().getCrop().getOfferingBushels() );
        }
        
        if (offering == 0){
            
            cropData.setWheatInStore(0);
          System.out.println("\n|****************************************************************************************|\n"
                              +"|                                                                                        |\n"
                              +"|                                                                                        |\n"
                              +"|          You were asked to give offerings and have decided you were unable to do so.   |\n"
                              +"| As a result of your decision, I will send a typhoon that is nothing you've ever seen.  |\n"
                              +"| But I will show mercy unto all those who will see the light and repent of your ways    |\n"
                              +"|                                                                                        |\n"
                              +"|                                                                                        |\n"
                              +"|                                                                                        |\n"
                              +"|                                                                                        |\n"
                              +"|****************************************************************************************|\n");
        }
    }   
    // The harvestCrops Method
    // Purpose: To harvest crops
    // Parameters: reference to the crop data object
    // Returns: Failure (-1) or success (1)    
    public static int harvestCrops(CropData cropData) {
        //initialize variables for use
        int harvest;
        int offeringTier;
        int offering = cropData.getOffering();
        int wheatOwned = cropData.getWheatInStore();
        int acres = cropData.getAcresOwned();
        int harvestRange = 3;
        int harvestBase = 1;
        
        // Assign tier level of return to offering amount
        if(offering < 8) {
            offeringTier = 1;
        } else if(offering > 12) {
            offeringTier = 3;
        } else {
            offeringTier = 2;
        }
        
        // harvest wheat and add it to stores based on offeringTier      
        switch (offeringTier)
        {
            case 1:
                harvest = acres * (random.nextInt(harvestRange) + harvestBase);
                wheatOwned += harvest;
                cropData.setWheatInStore(wheatOwned);
                cropData.setHarvest(harvest);
                return 1;
            case 2:
                harvest = acres * (random.nextInt(harvestRange) + harvestBase);
                wheatOwned += harvest;
                cropData.setWheatInStore(wheatOwned);
                cropData.setHarvest(harvest);
                return 1;
            case 3:
                harvest = acres * (random.nextInt(harvestRange) + harvestBase);
                wheatOwned += harvest;
                cropData.setWheatInStore(wheatOwned);
                cropData.setHarvest(harvest);
                return 1;
        }          
        return -1;
    }
    
    // The feedPeople method
    // Purpose: to set aside wheat for the people.
    // Parameters: wheat set aside and a reference to CropData.
    // Returns: amount of wheatInStore with an update to wheatForPeople.
    // Pre-Conditions: amount of wheat set aside for the people, amount must be
    // positive.
    public static void feedPeople (int wheatSetAside, CropData cropData) throws CropException{

	// if (wheatSetAside < 0), then return -1
	if (wheatSetAside < 0) {
            throw new CropException("A negative value was input, please try again.");
        }

	// if (wheatSetAside > wheatInStore) then return -1
	int wheatInStore = cropData.getWheatInStore();
	if (wheatSetAside > wheatInStore) {
            throw new CropException("There is insufficient wheat set aside for the people");
        }
        
	
	//wheatInStore =  wheatInStore - wheatSetAside.
	wheatInStore -= wheatSetAside;
	
	//wheatForPeople = whatForPeople + wheatSetAside.
	
	cropData.setWheatForPeople(wheatInStore);
        cropData.setWheatInStore(wheatInStore);

    }
    
    // The payOffering Method
    // Purpose: To figure the real number to remove from
    //      the the harvest to pay the offering.
    // Parameters: Gets game data to figure offering
    // Returns: no returns
    // Author: Sterling
    public static void payOffering(CropData cropData){
        // Get percentage of offering
        // Get number of bushels harvested
        // Get wheatInStore
        int offPerc = cropData.getOffering();
        int harvest = cropData.getHarvest();
        int wheatInStore = cropData.getWheatInStore();
        
        // Multiply percentage by harvest
        int offering = (offPerc * harvest) / 100;
        
        // Subtract offering from harvest
        harvest -= offering;
        
        // Add remaining harvest to store
        wheatInStore += harvest;
        cropData.setWheatInStore(wheatInStore);
        cropData.setOfferingBushels(offering);
    }
    
    // The CalcEatenByRats method
    // Pupose: To calculate wheat eaton by rats
    // Parameters: Gets game data from Cropdata
    // Returns: no returns
    // Author: Sterling
    public static void calcEatonByRats (CropData cropData){
        // Generate Random Number
        double eatRats;
        int offRange;
        int offBase;
        int offCheck;
        // Get Offering
        int offering = cropData.getOffering();
        int wheatInStore = cropData.getWheatInStore();
        double ratsAte = wheatInStore;
        // For loop to concerning offering percentage
        if(offering < LOW_BAR){
            // Rats eat random 6-10% wheatInStore
            offRange = 5;
            offBase = 5;
            offCheck = random.nextInt(offRange)+ offBase;
            eatRats = (offCheck / TO_PERC);
        }else if(offering > 12){
            // Rats eat random 3-5% wheatInStore
            offRange = 3;
            offBase = 2;
            offCheck = random.nextInt(offRange)+ offBase;
            eatRats = (offCheck / TO_PERC);
        }else{
            // Rats eat random 3-7% wheatInStore
            offRange = 5;
            offBase = 2;
            offCheck = random.nextInt(offRange)+ offBase;
            eatRats = (offCheck / TO_PERC);
        }
        
        // Subtract eatRats from wheatInStore
        eatRats *= ratsAte;
        wheatInStore -= eatRats;
        cropData.setWheatInStore(wheatInStore);
    }
    
    // The growPopuluation() method
    // Pupose: To grow the population based on harvest
    // Parameters: cropdata
    // Return: none
    // Author: Sterling Kendall
    public static void growPopulation(CropData cropData){
        // Determine random number
        int newPeople;
        double growPop = random.nextInt(5);
        double people = cropData.getPopulation();
        
        // Number of people increased 
        growPop /= TO_PERC;
        newPeople = (int) (people * growPop);
        
        // Save people increased
        cropData.setNewPeople(newPeople);
        
        // Add to current population
        int pop = (int) (people + newPeople);
        
        // Save to current population
        cropData.setPopulation(pop);
    }
    
    // The calcStarved() method
    // Purpose: to calculate the amount of people that starved
    // Parameters: cropData
    // Return: none
    // Author: Sterling
    public static void calcStarved(CropData cropData){
        // Get variables
        int pop = cropData.getPopulation();
        int wheatAside = cropData.getWheatForPeople();
        int pepFed;
        int pepAlive;
        int pepDead;
        
        // Calculate the number of peopleFed 20 bushels = 1 person
        pepFed = wheatAside / BUS_FEED;
        pepAlive = pop - pepFed;
        pepDead = pop - pepAlive;
        cropData.setNumStarved(pepDead);
        
        // Check Population
        if(pepAlive == 0){
            // End game message
            System.out.println("Your City has fallen to starvation, "
                    + "and so have you. Game Over, please play again.");
            // End Game
            System.exit(0);
        }else if(pepAlive > 0 && pepAlive < pop){
            // subtact starved from population
            pop -= pepDead;
            cropData.setPopulation(pop);
        }else{
            // Set population because everyone lived, this time.
            cropData.setPopulation(pop);
        }        
    }
    // This Method adds a year for each turn
    // Pupose: to track game rounds
    // Parameters:
    // Returns:
    // Author: Sterling
    public static void addYear(CropData cropData){
        // Get year
        int year = cropData.getYear();
        
        // Add a year
        year += CYCLE;
        
        // Set year
        cropData.setYear(year);
    }
}
