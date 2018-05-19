/*
 * The main () class file to the cityOfAaron project.
 * CIT-260
 * Spring 2018
 * Team members: JJ Hugh, James Rasmussen, and Sterling Kendall.
 */
package city.of.aaron;

import byui260.aaron.model.CropData;
import byui260.aaron.model.ListItem;
import byui260.aaron.model.Location;
import byui260.aaron.model.Player;
import byui260.aaron.model.TeamMember;

/**
 *
 * @author James Rasmussen, JJ Hugh, and Sterling Kendall
 */
public class CityOfAaron {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Player java bean
        Player playerOne = new Player();      
        playerOne.setName("Sterling");       
        String playerOneName = playerOne.getName();        
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
    }
    
}
