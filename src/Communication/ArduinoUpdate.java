/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Communication;

/**
 *
 * @author PerEspen
 */
public class ArduinoUpdate{
    
    private ArduinoUpdateListener listener;
    
    public ArduinoUpdate() {
        // set null or default listener or accept as argument to constructor
        this.listener = null; 
    }
	
    // Assign the listener implementing events interface that will receive the events
    public void setArduinoUpdateListener(ArduinoUpdateListener listener) {
        this.listener = listener;
    }
    
    public interface  ArduinoUpdateListener
    {    
        public void robotPosChanged();
      
        public void elevatorPosChanged();
     
        public void endStopTriggered(); 
    }
    
    
}
