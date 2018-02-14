/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Communication;

import Communication.I2Cdev;
import com.pi4j.io.i2c.I2CDevice;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PerEspen
 */
public class Communication implements Runnable
{

    //Variable holding the threadpool
    private ScheduledExecutorService threadpool;

    /**
     * *** I2C Address variables ****
     */
    //Elevator controller(-C1)
    private static final byte SENSORDATA_C1_ADDR = 0x01;
    private static final byte SENSORS_ATTACHED_C1 = 6;
    private static final byte SENSORDATA_S03_1 = 0b00000001;  //Optical Sensor S3.1
    private static final byte SENSORDATA_S03_2 = 0b00000010;  //Optical Sensor S3.2
    private static final byte SENSORDATA_S04_1 = 0b00000100;  //Optical Sensor S4.1
    private static final byte SENSORDATA_S04_2 = 0b00001000;  //Optical Sensor S4.2
    private static final byte SENSORDATA_S05_1 = 0b00010000;  //Optical Sensor S5.1
    private static final byte SENSORDATA_S05_2 = 0b00100000;  //Optical Sensor S5.2
    
    private static final byte STEPPER_DM01_ACCL_R_ADDR = 0x10;
    private static final byte STEPPER_DM01_POS_R_ADDR = 0x11;
    private static final byte STEPPER_DM01_ACCL_W_ADDR = 0x50;
    private static final byte STEPPER_DM01_POS_W_ADDR = 0x51;
    
    
    
    //Linear robot controller(-C2)
    private static final byte SENSORDATA_C2_ADDR = 0x02;
    private static final byte SENSORS_ATTACHED_C2 = 4;
    private static final byte SENSORDATA_S06_1 = 0b00000001;  //Optical Sensor S6.1
    private static final byte SENSORDATA_S06_2 = 0b00000010;  //Optical Sensor S6.2
    private static final byte SENSORDATA_S07_1 = 0b00000100;  //Optical Sensor S7.1
    private static final byte SENSORDATA_S07_2 = 0b00001000;  //Optical Sensor S7.2
    private static final byte STEPPER_DM23_ACCL_R_ADDR = 0x12;
    private static final byte STEPPER_DM23_POS_R_ADDR = 0x13;
    private static final byte STEPPER_DM23_ACCL_W_ADDR = 0x50;
    private static final byte STEPPER_DM23_POS_W_ADDR = 0x51;

    private byte[] stdByte;
    private byte[] newBuffer;
    private byte[] lastBuffer;
    private static final int stdByteSize = 3;
    private int x_lastValue_Robot;
    private int x_newValue_Robot;

    /**
     * I2C Devices*
     */
    I2Cdev i2cdevices;
    I2CDevice arduElevtr;
    I2CDevice arduRobot;

    Sensor[] c1Sensors;
    Sensor[] c2Sensors;
    
    public Communication()
    {
        stdByte = new byte[4];
        this.i2cdevices = new I2Cdev();
        arduElevtr = i2cdevices.createDevice(I2Cdev.ARD_ELEV_ADDR);
        arduRobot = i2cdevices.createDevice(I2Cdev.ARD_ROBOT_ADDR);
        c1Sensors = fillSensors(SENSORDATA_C1_ADDR);
        c2Sensors = fillSensors(SENSORDATA_C2_ADDR);
        
    }

    public void run()
    {
        //requestSensorData(arduElevtr);
        //newBuffer = i2cdevices.readData(ardElevator, SENSORDATA_C1_ADDR, stdByteSize);
        //newBuffer = createBufferRegister(stdByteSize, SENSORDATA_C1_ADDR, 0, 0);

        //write(arduElevtr, newBuffer);
        
    
        
        //READ 
        read(arduElevtr, stdByte, stdByteSize, SENSORDATA_C1_ADDR);
        
        for(byte b : stdByte)
        {
            //System.out.println(Byte.toString(b));
           System.out.println(Byte.toUnsignedInt(b));
        }
        
        for(Sensor s : c1Sensors)
        {
            System.out.println(s.getStringAddress());
        }
        
        
    }

    /**
     * Read incomming message from the device
     *
     * @param deviceUsed Device to read from
     * @param address Address
     * @param buffer Buffer to save info in
     * @return Return the created buffer
     */
    private byte[] read(I2CDevice deviceUsed, byte[] buffer, int byteSize, byte registerAddr)
    {
        
        try
        {
        deviceUsed.read(registerAddr, buffer, 0, byteSize);
        } catch (IOException ex)
        {
            Logger.getLogger(Communication.class.getName()).log(Level.SEVERE, null, ex);
        }
        return buffer;
    }

    /**
     * Write to the i2c device
     *
     * @param deviceUsed
     * @param address
     * @param buffer
     */
    private void write(I2CDevice deviceUsed, byte[] writebuff)
    {
        try
        {
            //deviceUsed.write(address, buffer, 0, size);
            deviceUsed.write(writebuff);
        } catch (IOException ex)
        {
            Logger.getLogger(Communication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private byte[] createBufferRegister(int byteSize, byte registerAddr, int valueX, int valueY)
    {
        //Create the byte
        byte[] newByte = new byte[byteSize];
        //ADD Values to the byte, registerAddrs is always one byte.
        newByte[0] = registerAddr;
        // newByte[0] = {registerAddr};

        newByte[1] = (byte) valueX;
        newByte[2] = (byte) valueY;
        
        //ByteBuffer b = ByteBuffer.allocate(byteSize);
        //b.order(ByteOrder.BIG_ENDIAN); // optional, the initial order of a byte buffer is always BIG_ENDIAN.
        //b.putInt(registerAddr);

        //byte[] result = b.array();
        //System.out.println(result);
       // System.out.println(Byte.toUnsignedInt(newByte[0]));
       // System.out.println(Byte.toUnsignedInt(newByte[1]));

        return newByte;
    }

    
    private boolean isNew(I2CDevice device)
    {
        boolean fakeNews = false;

        return fakeNews;
    }

    
    /**
     * Return the bit set in the position in byte ID. Shifts bit >> to position,
     * does AND bitwise check, returns 1 if set and 0 if not.
     *
     * @param position Position to check bit at
     * @param ID The byte to check bit from
     * @return Returns the bit set in the position of byte ID.
     */
    public byte getBit(int position, byte ID)
    {
        return (byte) ((ID >> position) & 1);
    }
    
    /**
     *  Uses the device, and sends request sensordata regarding what device is 
     * used to request the data.
     * @param device
     * @return returns 
     */
    private void requestSensorData(I2CDevice device)
    {
        byte[] readBuffer = new byte[stdByteSize];
       //Check what controller is used 
       if(device.getAddress() == i2cdevices.ARD_ELEV_ADDR)
       {
           read(device, readBuffer, stdByteSize, SENSORDATA_C1_ADDR);
       }
       else if(device.getAddress() == i2cdevices.ARD_ROBOT_ADDR)
       {
           read(device, readBuffer, stdByteSize, SENSORDATA_C2_ADDR);
       }
        
        //return  readBuffer[1];  
    }
    
    /**
     * 
     * @param SENSORDATA_C1_ADDR
     * @param c1Sensors 
     */
    private Sensor[] fillSensors(byte controller)
    {
        Sensor[] sensorArr = null;
        int cnt = 0; //Counter
        //Check which controller is attached to these sensors
        if(controller == SENSORDATA_C1_ADDR)
        {
            //Create the sensor array
            sensorArr = new Sensor[SENSORS_ATTACHED_C1];
            //Create all the sensors
            Sensor Sensor1 = new Sensor("C1", "Optical(S03_1)", SENSORDATA_S03_1);
            Sensor Sensor2 = new Sensor("C1", "Optical(S03_2)", SENSORDATA_S03_2);
            Sensor Sensor3 = new Sensor("C1", "Optical(S04_1)", SENSORDATA_S04_1);
            Sensor Sensor4 = new Sensor("C1", "Optical(S04_2)", SENSORDATA_S04_2);
            Sensor Sensor5 = new Sensor("C1", "Optical(S05_1)", SENSORDATA_S05_1);
            Sensor Sensor6 = new Sensor("C1", "Optical(S05_2)", SENSORDATA_S05_2);
            //Fill the array with the sensors
            sensorArr[0] = Sensor1;
            sensorArr[1] = Sensor2;
            sensorArr[2] = Sensor3;
            sensorArr[3] = Sensor4;
            sensorArr[4] = Sensor5;
            sensorArr[5] = Sensor6;            
        }
        else if(controller == SENSORDATA_C2_ADDR)
        {
            //Create the sensor array
            sensorArr = new Sensor[SENSORS_ATTACHED_C2];
            //Create all the sensors
            Sensor Sensor1 = new Sensor("C2", "Optical(S06_1)", SENSORDATA_S06_1);
            Sensor Sensor2 = new Sensor("C2", "Optical(S06_2)", SENSORDATA_S06_2);
            Sensor Sensor3 = new Sensor("C2", "Optical(S07_1)", SENSORDATA_S07_1);
            Sensor Sensor4 = new Sensor("C2", "Optical(S07_2)", SENSORDATA_S07_2);
      
            //Fill the array with the sensors
            sensorArr[0] = Sensor1;
            sensorArr[1] = Sensor2;
            sensorArr[2] = Sensor3;
            sensorArr[3] = Sensor4;         
        }
        

        
        return sensorArr;
    }

}
