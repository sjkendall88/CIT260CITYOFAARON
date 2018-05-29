/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui260.aaron.control;

import byui260.aaron.model.CropData;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hotja
 */
public class CropControlTest {
    
    public CropControlTest() {
    }

    /**
     * Test of sellLand method, of class CropControl.
     */
    @Test
    public void testSellLand() {
        System.out.println("sellLand");
        CropData theCrops = new CropData();
        theCrops.setWheatInStore(1000);
        theCrops.setAcresOwned(2800);
        int landPrice = 10;
        int acresToSell = 15;
        int expResult = 2785;
        int result = CropControl.sellLand(landPrice, acresToSell, theCrops);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of buyLand method, of class CropControl.
     */
    // Test 1
    @Test
    public void testBuyLand() {
        System.out.println("buyLand");
        CropData theCrops = new CropData();
        theCrops.setAcresOwned(10);
        theCrops.setWheatInStore(300);
        theCrops.setPopulation(10);
        int landPrice = 20;
        int acresToBuy = 10;
        int expResult = 20;
        int result = CropControl.buyLand(landPrice, acresToBuy, theCrops);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    
}
