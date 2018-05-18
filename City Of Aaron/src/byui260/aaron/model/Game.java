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
    private Player thePlayer;

    public Game(Player thePlayer) {
    }

    public Player getThePlayer() {
        return thePlayer;
    }

    public void setThePlayer(Player thePlayer) {
        this.thePlayer = thePlayer;
    }
    
    

}