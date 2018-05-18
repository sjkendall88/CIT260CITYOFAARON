/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui260.aaron.model;

import java.io.Serializable;

/**
 *
 * @author hotja
 */
public class Map implements Serializable{
    
    private Integer rowCount;
    private Integer colCount;
    private Location locations[][];

    public Map(Integer rowCount, Integer colCount, Location[][] locations) {
        this.rowCount = rowCount;
        this.colCount = colCount;
        this.locations = locations;
    }
    
    

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    public Integer getColCount() {
        return colCount;
    }

    public void setColCount(Integer colCount) {
        this.colCount = colCount;
    }

    public Location[][] getLocations() {
        return locations;
    }

    public void setLocations(Location[][] locations) {
        this.locations = locations;
    }
    
    

}