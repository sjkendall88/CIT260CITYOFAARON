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
 * @author James Rasmussen, JJ Hugh, and Sterling Kendall
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
    
    @Test
    public void testBuyLand() {
        System.out.println("testBuyLand");
        
        // Test 1 
        System.out.println("\tTest Case 1");
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
        
        // Test 2
        System.out.println("\tTest Case 2");
        theCrops.setAcresOwned(10);
        theCrops.setWheatInStore(100);
        theCrops.setPopulation(100);
        landPrice = 20;
        acresToBuy = -5;
        expResult = -1;
        result = CropControl.buyLand(landPrice, acresToBuy, theCrops);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
        
        // Test 3
        System.out.println("\tTest Case 3");
        theCrops.setAcresOwned(1);
        theCrops.setWheatInStore(60000);
        theCrops.setPopulation(1);
        landPrice = 20;
        acresToBuy = 3000;
        expResult = -1;
        result = CropControl.buyLand(landPrice, acresToBuy, theCrops);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
        
        // Test 4
        System.out.println("\tTest Case 4");
        theCrops.setAcresOwned(1);
        theCrops.setWheatInStore(100);
        theCrops.setPopulation(100);
        landPrice = 20;
        acresToBuy = 5000;
        expResult = -1;
        result = CropControl.buyLand(landPrice, acresToBuy, theCrops);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
        
        // Test 5
        System.out.println("\tTest Case 5");
        theCrops.setAcresOwned(0);
        theCrops.setWheatInStore(0);
        theCrops.setPopulation(0);
        landPrice = 20;
        acresToBuy = 0;
        expResult = 0;
        result = CropControl.buyLand(landPrice, acresToBuy, theCrops);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
        
        // Test 6
        System.out.println("\tTest Case 6");
        theCrops.setAcresOwned(10);
        theCrops.setWheatInStore(1000);
        theCrops.setPopulation(2);
        landPrice = 20;
        acresToBuy = 10;
        expResult = 20;
        result = CropControl.buyLand(landPrice, acresToBuy, theCrops);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
        
        // Test 7
        System.out.println("\tTest Case 7");
        theCrops.setAcresOwned(50);
        theCrops.setWheatInStore(1000);
        theCrops.setPopulation(10);
        landPrice = 20;
        acresToBuy = 50;
        expResult = 100;
        result = CropControl.buyLand(landPrice, acresToBuy, theCrops);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of AcresToPlant method, of class CropControl.
     */
    @Test
    public void testAcresToPlant() {
        System.out.println("AcresToPlant");
        
        // Test 1
        System.out.println("\tTest 1");
        CropData theCrops = new CropData();
        theCrops.setAcresPlanted(0);
        theCrops.setAcresOwned(15);
        theCrops.setWheatInStore(50);
        int acresToPlant = 10;
        int expResult = 10;
        int result = CropControl.AcresToPlant(acresToPlant, theCrops);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
        
        // Test 2
        System.out.println("\tTest 2");
        theCrops.setAcresPlanted(0);
        theCrops.setAcresOwned(15);
        theCrops.setWheatInStore(50);
        acresToPlant = -5;
        expResult = -1;
        result = CropControl.AcresToPlant(acresToPlant, theCrops);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");

        // Test 3
        System.out.println("\tTest 3");
        theCrops.setAcresPlanted(0);
        theCrops.setAcresOwned(15);
        theCrops.setWheatInStore(50);
        acresToPlant = 20;
        expResult = -1;
        result = CropControl.AcresToPlant(acresToPlant, theCrops);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");

        // Test 4
        System.out.println("\tTest 4");
        theCrops.setAcresPlanted(0);
        theCrops.setAcresOwned(15);
        theCrops.setWheatInStore(50);
        acresToPlant = 30;
        expResult = -1;
        result = CropControl.AcresToPlant(acresToPlant, theCrops);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");

        // Test 5
        System.out.println("\tTest 5");
        theCrops.setAcresPlanted(0);
        theCrops.setAcresOwned(10);
        theCrops.setWheatInStore(50);
        acresToPlant = 10;
        expResult = 10;
        result = CropControl.AcresToPlant(acresToPlant, theCrops);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");

        // Test 6
        System.out.println("\tTest 6");
        theCrops.setAcresPlanted(0);
        theCrops.setAcresOwned(15);
        theCrops.setWheatInStore(5);
        acresToPlant = 10;
        expResult = 10;
        result = CropControl.AcresToPlant(acresToPlant, theCrops);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
        
    }

    @Test
    public void testSetOffering() {
        System.out.println("Test setOffering()");
        
        // Test 1
        System.out.println("\tTest Case 1");
        CropData theCrops = new CropData();
        int offering = 10;
        int expResult = 10;
        int result = CropControl.setOffering(offering, theCrops);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");     
    }
}
