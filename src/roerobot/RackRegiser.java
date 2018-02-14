/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roerobot;

import java.util.ArrayList;

/**
 *
 * @author Yngve
 */
public class RackRegiser {
    private ArrayList<Tray> trayRegister;

    public RackRegiser() {
        this.trayRegister = new ArrayList<>();
    }
    
    /**
     * Adds tray to the rack register
     * @param tray 
     */
    public void addToRegister(Tray tray){
        this.trayRegister.add(tray);
    }
    
    /**
     * Retruns number of trays in the rack 
     * @return int 
     */
    public int getNumberOfTrays(){
        return this.trayRegister.size();
    }
    
    
}
