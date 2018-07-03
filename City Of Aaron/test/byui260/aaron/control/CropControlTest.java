/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui260.aaron.control;

import byui260.aaron.model.CropData;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author James Rasmussen, JJ Hugh, and Sterling Kendall
 */
public class CropControlTest {
    
    public CropControlTest() {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
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
        //int result = CropControl.buyLand(landPrice, acresToBuy, theCrops);
        //assertEquals(expResult, result);
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
        //result = CropControl.buyLand(landPrice, acresToBuy, theCrops);
        //assertEquals(expResult, result);
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
        //result = CropControl.buyLand(landPrice, acresToBuy, theCrops);
        //assertEquals(expResult, result);
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
        //result = CropControl.buyLand(landPrice, acresToBuy, theCrops);
        //assertEquals(expResult, result);
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
        //result = CropControl.buyLand(landPrice, acresToBuy, theCrops);
        //assertEquals(expResult, result);
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
        //result = CropControl.buyLand(landPrice, acresToBuy, theCrops);
        //assertEquals(expResult, result);
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
        //result = CropControl.buyLand(landPrice, acresToBuy, theCrops);
        //assertEquals(expResult, result);
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
        
        // Test 2
        System.out.println("\tTest Case 2");
        offering = -5;
        expResult = -1;
        result = CropControl.setOffering(offering, theCrops);
        assertEquals(expResult, result);
        
        // Test 3
        System.out.println("\tTest Case 3");
        offering = 105;
        expResult = -1;
        result = CropControl.setOffering(offering, theCrops);
        assertEquals(expResult, result);
        
        // Test 4
        System.out.println("\tTest Case 4");
        offering = 0;
        expResult = 0;
        result = CropControl.setOffering(offering, theCrops);
        assertEquals(expResult, result);
        
        // Test 5
        System.out.println("\tTest Case 5");
        offering = 100;
        expResult = 100;
        result = CropControl.setOffering(offering, theCrops);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");     
    }

    @Test
    public void testHarvestCrops() {
        System.out.println("Test harvestCrops()");
        
        // Test 1
        CropData theCrops = new CropData();
        theCrops.setWheatInStore(100);
        theCrops.setAcresOwned(1);
        theCrops.setOffering(7);
        int expResult = 1;
        int expRange = 100;
        int expRange2 = 104;
        int result = CropControl.harvestCrops(theCrops);
        int result2 = theCrops.getWheatInStore();
        assertEquals(expResult, result);
        boolean check = false;
        if(result2 > expRange && result2 < expRange2)
            check = true;
        assertEquals(check, true);
        System.out.println(result2);
        
        // Test 2
        theCrops.setWheatInStore(100);
        theCrops.setAcresOwned(1);
        theCrops.setOffering(8);
        expResult = 1;
        expRange = 101;
        expRange2 = 105;
        result = CropControl.harvestCrops(theCrops);
        result2 = theCrops.getWheatInStore();
        assertEquals(expResult, result);
        check = false;
        if(result2 > expRange && result2 < expRange2)
            check = true;
        assertEquals(check, true);
        System.out.println(result2);
        
        // Test 3
        theCrops.setWheatInStore(100);
        theCrops.setAcresOwned(1);
        theCrops.setOffering(13);
        expResult = 1;
        expRange = 101;
        expRange2 = 106;
        result = CropControl.harvestCrops(theCrops);
        result2 = theCrops.getWheatInStore();
        assertEquals(expResult, result);
        check = false;
        if(result2 > expRange && result2 < expRange2)
            check = true;
        assertEquals(check, true);
        System.out.println(result2);
    }
    
    /**
     * Test of feedPeople method, of class CropControl.
     */
    @Test
    public void testFeedPeople() {
        System.out.println("feedPeople");
        System.out.println("\tTest 1");
        CropData theCrops = new CropData();
        theCrops.setWheatInStore(2000);
        theCrops.setWheatForPeople(800);
        int wheatSetAside = 300;
        int expResult = 1700;
        int result = CropControl.feedPeople(wheatSetAside, theCrops);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        System.out.println("\tTest 2");
        theCrops.setWheatInStore(1700);
        theCrops.setWheatForPeople(660);
        wheatSetAside = 400;
        expResult = 1300;
        result = CropControl.feedPeople(wheatSetAside, theCrops);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
         System.out.println("\tTest 3");
        theCrops.setWheatInStore(1300);
        theCrops.setWheatForPeople(1300);
        wheatSetAside = 1100;
        expResult = 200;
        result = CropControl.feedPeople(wheatSetAside, theCrops);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
         System.out.println("\tTest 4");
        theCrops.setWheatInStore(100);
        theCrops.setWheatForPeople(100);
        wheatSetAside = 200;
        expResult = -1;
        result = CropControl.feedPeople(wheatSetAside, theCrops);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
         System.out.println("\tTest 5");
        theCrops.setWheatInStore(0);
        theCrops.setWheatForPeople(20);
        wheatSetAside = -20;
        expResult = -1;
        result = CropControl.feedPeople(wheatSetAside, theCrops);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
         System.out.println("\tTest 6");
        theCrops.setWheatInStore(-300);
        theCrops.setWheatForPeople(100);
        wheatSetAside = -300;
        expResult = -1;
        result = CropControl.feedPeople(wheatSetAside, theCrops);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
         System.out.println("\tTest 7");
        theCrops.setWheatInStore(800);
        theCrops.setWheatForPeople(500);
        wheatSetAside = 1600;
        expResult = -1;
        result = CropControl.feedPeople(wheatSetAside, theCrops);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        //Minimum Test
         System.out.println("\tTest 8");
        theCrops.setWheatInStore(10);
        theCrops.setWheatForPeople(200);
        wheatSetAside = 0;
        expResult = 10;
        result = CropControl.feedPeople(wheatSetAside, theCrops);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
         System.out.println("\tTest 9");
        theCrops.setWheatInStore(6500);
        theCrops.setWheatForPeople(660);
        wheatSetAside = 6500;
        expResult = 0;
        result = CropControl.feedPeople(wheatSetAside, theCrops);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
}
