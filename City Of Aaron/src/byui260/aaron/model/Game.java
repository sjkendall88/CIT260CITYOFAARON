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
public class Game implements Serializable{
    // Class instance variable.
    private map theMap;
    private Player thePlayer;
    private cropData cropData;
    private ArrayList<ListItem> animals;
    private ArrayList<ListItem> provisions;

    public Game(map theMap, Player thePlayer, cropData cropData, <any> animals, <any> provisions) {
        this.theMap = theMap;
        this.thePlayer = thePlayer;
        this.cropData = cropData;
        this.animals = animals;
        this.provisions = provisions;
    }

    public map getTheMap() {
        return theMap;
    }

    public void setTheMap(map theMap) {
        this.theMap = theMap;
    }

    public Player getThePlayer() {
        return thePlayer;
    }

    public void setThePlayer(Player thePlayer) {
        this.thePlayer = thePlayer;
    }

    public cropData getCropData() {
        return cropData;
    }

    public void setCropData(cropData cropData) {
        this.cropData = cropData;
    }

    public <any> getAnimals() {
        return animals;
    }

    public void setAnimals(<any> animals) {
        this.animals = animals;
    }

    public <any> getProvisions() {
        return provisions;
    }

    public void setProvisions(<any> provisions) {
        this.provisions = provisions;
    }
    
    
    
}
