/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui260.aaron.model;

/**
 *
 * @author hotja
 */
public class ListItem {
    
    private String name;
    private Integer number;

    public ListItem(String name, Integer number) {
        this.name = name;
        this.number = number;
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
