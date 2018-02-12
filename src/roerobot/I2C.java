/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roerobot;

import java.io.IOException;

import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CConstants;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;
import com.pi4j.platform.Platform;
import com.pi4j.platform.PlatformAlreadyAssignedException;
import com.pi4j.platform.PlatformManager;
import com.pi4j.util.Console;
import java.util.logging.Level;
import java.util.logging.Logger;
import static sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte0.runnable;

/**
 *
 * @author PerEspen
 */
public class I2C implements Runnable{

    //I2C addresses for devices on bus
    public static final int ARD_ELEV_ADDR = 0x01;
    public static final int ARD_ROBOT_ADDR = 0x02;
    //I2C bus line used(on odroid)
    public static final int I2CBUS = 4;

    public I2CDevice ardElevator = null;
    public I2CDevice ardRobot = null;

    
    
    /*
    Main function of the i2c
    */
    @Override
    public void run() {
        
        ardElevator = initiate(I2CBUS, ARD_ELEV_ADDR);
        ardRobot = initiate(I2CBUS, ARD_ELEV_ADDR);
        
        
    }

    
    
    /**
     *
     * @param I2CbusNr Bus nr-dev to be used
     * @param addrNr Address to set device object to
     * @return The created device
     *
     */
    public I2CDevice initiate(int I2CbusNr, int addrNr) /*throws PlatformAlreadyAssignedException, UnsupportedBusNumberException, IOException*/ {
        I2CDevice i2cDevice = null;

        try {
            //Set the platform running, checks if the platform is set already
            if(PlatformManager.getPlatform() != Platform.ODROID)    
            PlatformManager.setPlatform(Platform.ODROID);
            
        } catch (PlatformAlreadyAssignedException expl) {
            Logger.getLogger(I2C.class.getName()).log(Level.SEVERE, null, expl);
            System.out.println(expl.getCause().toString());
        }
        try {
            //Set the i2c bus to be used
            I2CBus i2c = I2CFactory.getInstance(I2CbusNr);
            i2cDevice = i2c.getDevice(addrNr);
        } catch (UnsupportedBusNumberException exdev) {
            Logger.getLogger(I2C.class.getName()).log(Level.SEVERE, null, exdev);
            System.out.println(exdev.getCause().toString());
        } catch (IOException exio) {
            Logger.getLogger(I2C.class.getName()).log(Level.SEVERE, null, exio);
            System.out.println(exio.getCause().toString());
        }

        return i2cDevice;
    }
}
