/*
 * The main () class file to the cityOfAaron project.
 * CIT-260
 * Spring 2018
 * Team members: JJ Hugh, James Rasmussen, and Sterling Kendall.
 */
package city.of.aaron;

import byui260.aaron.model.ListItem;
import byui260.aaron.model.Location;
import byui260.aaron.model.Player;
import byui260.aaron.model.TeamMember;

/**
 *
 * @author hotja
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
        listItemOne.setName("");
        listItemOne.setNumber(Integer.SIZE);
        String listItemOneName = listItemOne.getName();
        Integer listItemOneNumber = listItemOne.getNumber();
        System.out.println(listItemOneNumber + " " + listItemOneName);
        
        //CropData
    }
    
}
