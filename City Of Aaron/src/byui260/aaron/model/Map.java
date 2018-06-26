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
    private Location[][] locations;

    //Parameter Map constructor
    //Purpose:Set row & col values, create array of location objects
    //Parameters:Row and column count
    //Returns:none
    public Map(Integer _rows, Integer _cols) {
    
        rowCount = _rows;
        colCount = _cols;
        
        //create array of location objects
        locations = new Location[_rows][_cols];
        
        //Old code in this section, documented in case errors arise 
        /* public Map(Integer rowCount, Integer colCount, Location[][] locations) {
        this.rowCount = rowCount;
        this.colCount = colCount;
        this.locations = locations;
        */
    }
    
    //get location method
    //Purpose: returns the location object at the given row and column
    //Parameters:  a row and column
    //Returns: : a Location object
    public Location getLocation(int row, int col)
    {
        return locations[row][col];
    }
    
    public void setLocation(int row, int col, Location _location)
    {
        locations[row][col] = _location;
    }

    public Integer getRowCount() {
        return rowCount;
    }
/*  setters are included in constructor, these setters are now defunct
    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }
*/
    public Integer getColCount() {
        return colCount;
    }
/*
    public void setColCount(Integer colCount) {
        this.colCount = colCount;
    }
*/
    /* Changed requirements on location, this code is no longer needed?
    public Location[][] getLocations() {
        return locations;
    }
    */
/*
    public void setLocations(Location[][] locations) {
        this.locations = locations;
    }
*/    
    

    
}