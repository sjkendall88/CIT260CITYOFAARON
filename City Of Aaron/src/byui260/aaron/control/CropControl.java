/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui260.aaron.control;
import java.util.Random;

/**
 *
 * @author Sterling Kendall, JJ Hugh, and James Rasmussen
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
    //Purpose: To sell land
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
}
