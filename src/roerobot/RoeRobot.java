/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roerobot;

/**
 *
 * @author Yngve
 */
public class RoeRobot implements Runnable{
    private CoordinateSystem coordSyst; 
    private RackRegiser rackRegister; 
    
    
    
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    /**
     * Adds trays to register. 
     * 
     */
    private void addTrayToRack(){
        Tray tray = new Tray(100, 100, 100);
        this.rackRegister.addToRegister(tray);
    }
    
}
