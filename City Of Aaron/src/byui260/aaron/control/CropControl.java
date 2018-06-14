/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui260.aaron.control;
import byui260.aaron.model.CropData;
import java.util.Random;

/**
 *
 * @author James Rasmussen, JJ Hugh, and Sterling Kendall
 */
public class CropControl {
    
    //constants
    private static final int LAND_BASE = 17;
    private static final int LAND_RANGE = 10;
    
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
        if(acresToSell <0)
            return -1;
        
        // if acresToSell > acresOwned, return -1
        int owned = cropData.getAcresOwned();
        if(acresToSell > owned)
            return -1;
        
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
    public static int buyLand(int landPrice, int acresToBuy, CropData cropData){
                
        // if(acresToBuy < 0) return -1
        if(acresToBuy < 0)
            return -1;
        
        // TotalCost = acresToBuy * landPrice
        int totalCost = acresToBuy * landPrice;
        
        // if totalCost > wheatOwned return -1
        int wheatOwned = cropData.getWheatInStore();
        if(totalCost > wheatOwned)
            return -1;
        
        // totalAcres = acresOwned + acresToBuy
        int acresOwned = cropData.getAcresOwned();
        int totalAcres = acresOwned + acresToBuy;

        // if population < totalAcres/10 return -1
        int population = cropData.getPopulation();
        if(population < totalAcres/10)
            return -1;

        // wheatOwned = wheatOwned - totalCost
        wheatOwned -= totalCost;
        cropData.setWheatInStore(wheatOwned);
        cropData.setAcresOwned(totalAcres);
        
        // return totalAcres
        return totalAcres;
        
    }
    
    // The AcresToPlant method
    // Purpose: to plant acres
    // Parameters: the number of acres to plant, and
    // the a reference to CropData.
    // Returns: The number of acres to plant.
    // Pre-Conditions: acres to plant must be positive.    
    public static int AcresToPlant(int acresToPlant, CropData cropData){
        
        // If (acresToPlant < 0) then return -1
        if(acresToPlant < 0)
            return -1;
        
        // If (acresToPlant !<= acresOwned) then return -1
        int acresOwned = cropData.getAcresOwned();
        if(acresOwned < acresToPlant)
            return -1;
        
        // bushelsToPlant = acresToPlant / 2
        int bushelsToPlant = acresToPlant / 2;
        
        // If (wheatInStore !>= bushelsToPlant) then return -1
        int wheatInStore = cropData.getWheatInStore();
        if(wheatInStore < bushelsToPlant)
            return -1;
        
        // wheatInStore  = wheatInStore – bushelsToPlant
        wheatInStore -= bushelsToPlant;
        cropData.setWheatInStore(wheatInStore);
        
        // acresPlanted += acresToPlant
        int acresPlanted = cropData.getAcresPlanted();
        acresPlanted = acresToPlant;
        cropData.setAcresPlanted(acresPlanted);
        
        // Return acresPlanted
        return acresPlanted;        
    }
    
    // The setOffering method
    // Purpose: To set an offering percentage
    // Parameters: desired offering amount and a reference
    // to the CropData object
    // Returns: integer of offering amount
    // Pre-conditions: offering must be between 0 and 100
    public static int setOffering(int offering, CropData cropData) {
        
        // IF 0 > offering or offering > 100 return -1
        if (offering < 0 || offering > 100)
            return -1;
        
        // RETURN offering
        cropData.setOffering(offering);
        return offering;
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
        if(offering < 8)
            offeringTier = 1;
        else if(offering > 12)
            offeringTier = 3;
        else offeringTier = 2;
        
        // harvest wheat and add it to stores based on offeringTier      
        switch (offeringTier)
        {
            case 1:
                harvest = acres * (random.nextInt(harvestRange) + harvestBase);
                wheatOwned += harvest;
                cropData.setWheatInStore(wheatOwned);
                return 1;
            case 2:
                harvest = acres * (random.nextInt(harvestRange) + ++harvestBase);
                wheatOwned += harvest;
                cropData.setWheatInStore(wheatOwned);
                return 1;
            case 3:
                harvest = acres * (random.nextInt(++harvestRange) + ++harvestBase);
                wheatOwned += harvest;
                cropData.setWheatInStore(wheatOwned);
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
    public static int feedPeople (int wheatSetAside, CropData cropData){

	// if (wheatSetAside < 0), then return -1
	if (wheatSetAside < 0) {
            return -1;
        }

	// if (wheatSetAside > wheatInStore) then return -1
	int wheatInStore = cropData.getWheatInStore();
	if (wheatSetAside > wheatInStore) {
            return -1;
        }
	
	//wheatInStore =  wheatInStore - wheatSetAside.
	wheatInStore -= wheatSetAside;
	
	//wheatForPeople = whatForPeople + wheatSetAside.
	int wheatForPeople = cropData.getWheatForPeople();
	wheatForPeople += wheatSetAside;
        cropData.setWheatForPeople(wheatForPeople);
        cropData.setWheatInStore(wheatInStore);

	//Return wheat used for people remaining.
	return wheatInStore;
    }

    //public static int feedPeople() {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}
}
