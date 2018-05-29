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
/*    
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
*/    
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
        
        // return totalAcres
        return totalAcres;
        
    }
}
