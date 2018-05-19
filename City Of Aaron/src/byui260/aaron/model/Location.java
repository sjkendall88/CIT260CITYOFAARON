/*
 * CIT-260
 * Spring 2018
 * Team members: James Rasmussen, Sterling Kendall, JJ Hugh
 */

package byui260.aaron.model;
import java.io.Serializable;

/**
 *
 * @author James Rasmussen
 */

public class Location implements Serializable{
    
    private String description;
    private String symbol;

    public Location(String description, String symbol) {
    }  

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    
}
