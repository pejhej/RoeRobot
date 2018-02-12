/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Communication;

import java.util.concurrent.ScheduledExecutorService;

/**
 *
 * @author PerEspen
 */
public class Communication {
   
    //Variable holding the threadpool
    private ScheduledExecutorService threadpool;
            
    public int x_lastValue_Robot;
    public int x_newValue_Robot;
    
    I2Cdev i2cdevices = new I2Cdev();
    
    public void run()
    {
        x_newValue_Robot = i2cdevices.ardElevator.read();
        
        if(x_newValue_Robot != x_lastValue_Robot)
        { 
            updateinterface
                }           
         i2cdevices.ardElevator.
    }
    
}
