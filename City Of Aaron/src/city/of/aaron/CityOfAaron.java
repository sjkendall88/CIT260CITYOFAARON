/*
 * The main () class file to the cityOfAaron project.
 * CIT-260
 * Spring 2018
 * Team members: JJ Hugh, James Rasmussen, and Sterling Kendall.
 */
package city.of.aaron;

import byui260.aaron.model.Player;

/**
 *
 * @author hotja
 */
public class CityOfAaron {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Player playerOne = new Player();
        
        playerOne.setName("Sterling");
        
        String playerOneName = playerOne.getName();
        
        System.out.println("Name = " + playerOneName);
    }
    
}
