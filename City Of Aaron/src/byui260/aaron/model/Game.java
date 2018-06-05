/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui260.aaron.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Sterling, JJ, James
 */
public class Game implements Serializable{
    // Class instance variable.
    private Player thePlayer;
    private Map theMap;
    private CropData cropData;
    private ArrayList<ListItem> animals;
    private ArrayList<ListItem> tools;
    private ArrayList<ListItem> provisions;

    public Game(){
    }    

    public Player getThePlayer() {
        return thePlayer;
    }

    public void setThePlayer(Player thePlayer) {
        this.thePlayer = thePlayer;
    }

    public Map getTheMap() {
        return theMap;
    }

    public void setTheMap(Map theMap) {
        this.theMap = theMap;
    }

    public CropData getCropData() {
        return cropData;
    }

    public void setCropData(CropData cropData) {
        this.cropData = cropData;
    }
/*
    public <any> getAnimals() {
        return animals;
    }

    public void setAnimals(<any> animals) {
        this.animals = animals;
    }

    public <any> getTools() {
        return tools;
    }

    public void setTools(<any> tools) {
        this.tools = tools;
    }

    public <any> getProvisions() {
        return provisions;
    }

    public void setProvisions(<any> provisions) {
        this.provisions = provisions;
    }
 */   
}