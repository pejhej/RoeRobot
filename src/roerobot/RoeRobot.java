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
public class RoeRobot implements Runnable {

    private CoordinateSystem coordSyst;
    private RackRegiser rackRegister;
    private final int trayWidth = 900; //mm 
    private final int trayDepth = 330; //mm 
    private final int distUpperLowerPos = 0; // distanse from upper positon to the lowest position in the tray i mm. 
    
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    private void calibrate(){
        // More to the lowest endpoints. x- y- z- 
        
        // Wait for the divise to return done signal
        
        // Uppdate 
    }
    
   
    /**
     * Adds trays to register.
     */
    private void addTrayToRack(int upperPos) {
        Tray tray = new Tray(trayWidth, trayDepth, distUpperLowerPos, upperPos);
        this.rackRegister.addToRegister(tray);
    }
}
