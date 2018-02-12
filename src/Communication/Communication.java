/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Communication;

import com.pi4j.io.i2c.I2CDevice;
import java.util.concurrent.ScheduledExecutorService;

/**
 *
 * @author PerEspen
 */
public class Communication 
{
   
    //Variable holding the threadpool
    private ScheduledExecutorService threadpool;
    
    /***** I2C Address variables *****/
    //Elevator controller(-C1)
    private static final int SENSORDATA_C1_ADDR = 0x01;
    private static final int STEPPER_DM01_ACCL_ADDR = 0x10;
    private static final int STEPPER_DM01_POS_R_ADDR = 0x11;
    private static final int STEPPER_DM01_ACCL_W_ADDR = 0x50;
    private static final int STEPPER_DM01_POS_W_ADDR = 0x51;
    
    //Linear robot controller(-C2)
    private static final int SENSORDATA_C2_ADDR = 0x02;
    private static final int STEPPER_DM23_ACCL_R_ADDR = 0x12;
    private static final int STEPPER_DM23_POS_R_ADDR = 0x13;
    private static final int STEPPER_DM23_ACCL_W_ADDR = 0x50;
    private static final int STEPPER_DM23_POS_W_ADDR = 0x51;
    
    private final byte[] stdByte;
    private byte[] newBuffer;
      private byte[] lastBuffer;
    private static final int stdByteSize = 3;
    private int x_lastValue_Robot;
    private int x_newValue_Robot;
    
    /**I2C Devices**/
    I2Cdev i2cdevices = new I2Cdev();
    I2CDevice arduElevtr;
    I2CDevice arduRobot;


    public Communication() {
        stdByte = new byte[4];
        this.i2cdevices = new I2Cdev();
        arduElevtr = i2cdevices.initiate(I2Cdev.I2CBUS, I2Cdev.ARD_ELEV_ADDR);
        arduRobot = i2cdevices.initiate(I2Cdev.I2CBUS, I2Cdev.ARD_ROBOT_ADDR);
    }
    
    public void run()
    {
        newBuffer = i2cdevices.readData(ardElevator, SENSORDATA_C1_ADDR, stdByteSize);
        
        if(x_newValue_Robot != x_lastValue_Robot)
        { 
           
        }           

    }
    
    
    
    
    private byte[] reading(I2Cdev i2cDevices, I2CDevices deviceUsed)
        {
            arduElevtr.read(stdByteSize, newBuffer, stdByteSize, stdByteSize)
        }
    
    private boolean isNew()
            {
                
            }
    
}
