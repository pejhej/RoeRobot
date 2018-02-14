/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Communication;

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

/**
 * This opens, maintains and handles the communication and connection to the
 * Arduinos in use, via I2C protocol.
 *
 * @author PerEspen
 */
public class I2Cdev implements Runnable
{

    //I2C addresses for devices on bus
    public static final int ARD_ELEV_ADDR = 0x10;
    public static final int ARD_ROBOT_ADDR = 0x02;

    //I2C bus line used(on odroid)
    public static final int I2CBUS = 4;

    //
    private static I2CBus i2c;

    //I2C devices
    public I2CDevice ardElevator = null;
    public I2CDevice ardRobot = null;

    public I2Cdev()
    {
        try
        {
            //Set the platform running, checks if the platform is set already
            // if(PlatformManager.getPlatform() != Platform.ODROID)    
            PlatformManager.setPlatform(Platform.ODROID);

        } catch (PlatformAlreadyAssignedException expl)
        {
            Logger.getLogger(I2Cdev.class.getName()).log(Level.SEVERE, null, expl);
            System.out.println(expl.getCause().toString());
        }
        try
        {
            //Set the i2c bus to be used
            i2c = I2CFactory.getInstance(I2CBUS);
        } catch (UnsupportedBusNumberException exdev)
        {
            Logger.getLogger(I2Cdev.class.getName()).log(Level.SEVERE, null, exdev);
            System.out.println(exdev.getCause().toString());
        } catch (IOException exio)
        {
            Logger.getLogger(I2Cdev.class.getName()).log(Level.SEVERE, null, exio);
            System.out.println(exio.getCause().toString());
        }
    }

    /*
    Main function of the i2c
     */
    @Override
    public void run()
    {

    }

    /**
     * Read data using the specified device and parameters
     *
     * @param i2cdev I2C device to read from
     * @param readAddress Which address to read values from
     * @param bufferSize Size of the buffer
     * @return The read buffer
     */
    public byte[] readData(I2CDevice i2cdev, int readAddress, int bufferSize)
    {
        //Variable specifications for the i2c reading
        int offset = 0;
        //Buffer to hold values read
        byte[] buffer = null;

        try
        {
            i2cdev.read(readAddress, buffer, offset, bufferSize);
        } catch (IOException ex)
        {
            Logger.getLogger(I2Cdev.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
        }
        
        return buffer;
    }

    /**
     * Device to write data to
     *
     * @param i2cdev i2c device to wrtie to
     * @param writeAddress address to write to
     * @param bufferSize buffer size
     * @return Returns NOT NULL if no errors were thrown during writing
     */
    public byte[] writeData(I2CDevice i2cdev, int writeAddress, int bufferSize)
    {
        //Flag to check if writing was completed
        byte[] buffer = null;

        //Variable specifications for the i2c reading
        int offset = 0;
        //Does the writing to the i2c device, and sets the return statement
        try
        {
            i2cdev.write(writeAddress, buffer, offset, bufferSize);
        } catch (IOException ex)
        {
            Logger.getLogger(I2Cdev.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
        }

        return buffer;
    }

    /**
     *
     * @param I2CbusNr Bus nr-dev to be used
     * @param addrNr Address to set device object to
     * @return The created device
     *
     */
    /* public void initiate(int I2CbusNr) /*throws PlatformAlreadyAssignedException, UnsupportedBusNumberException, IOException*/ //{
    /*    I2CDevice i2cDevice = null;

 /*       try {
            //Set the platform running, checks if the platform is set already
          // if(PlatformManager.getPlatform() != Platform.ODROID)    
            PlatformManager.setPlatform(Platform.ODROID);
            
        } catch (PlatformAlreadyAssignedException expl) {
            Logger.getLogger(I2Cdev.class.getName()).log(Level.SEVERE, null, expl);
            System.out.println(expl.getCause().toString());
        }
        try {
            //Set the i2c bus to be used
            i2c = I2CFactory.getInstance(I2CbusNr);
        } catch (UnsupportedBusNumberException exdev) {
            Logger.getLogger(I2Cdev.class.getName()).log(Level.SEVERE, null, exdev);
            System.out.println(exdev.getCause().toString());
        } catch (IOException exio) {
            Logger.getLogger(I2Cdev.class.getName()).log(Level.SEVERE, null, exio);
            System.out.println(exio.getCause().toString());
        }
    } 
     */
    public I2CDevice createDevice(int addrNr)
    {
        I2CDevice i2cdev = null;
        try
        {
            i2cdev = i2c.getDevice(addrNr);
        } catch (IOException ex)
        {
            Logger.getLogger(I2Cdev.class.getName()).log(Level.SEVERE, null, ex);
        }

        return i2cdev;
    }

}
