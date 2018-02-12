/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roerobot;

import Communication.I2Cdev;

/**
 *
 * @author PerEspen
 */
public class Odroid {
    
    I2Cdev arduinoElevator;
    I2Cdev arduinoRobot;
    public void run()
    {
        arduinoElevator.initiate(I2Cdev.I2CBUS, I2Cdev.ARD_ELEV_ADDR);
       
        arduinoRobot.initiate(I2Cdev.I2CBUS, I2Cdev.ARD_ROBOT_ADDR);
        arduinoRobot.ardRobot.read();
    }

}
