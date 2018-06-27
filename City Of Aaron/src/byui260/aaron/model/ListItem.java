/*
 * CIT-260
 * Spring 2018
 * Team members: James Rasmussen, Sterling Kendall, JJ Hugh
 */

package byui260.aaron.model;
import java.io.Serializable;

/**
 *
 * @author JJ Hugh
 */

public class ListItem implements Serializable{
    
    private String name;
    private Integer number;


    public ListItem(String name, int number) {
    this.name = name;
    this.number = number;
    }

    @Override
    public String toString() {
        return number + " " + name + "(s)";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
   
    }
