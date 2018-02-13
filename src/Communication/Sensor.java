/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Communication;

/**
 * This class contains all information regarding sensors
 * @author PerEspen
 */
public class Sensor
{
    //All the fields(information) which a sensor can hold
    private final String controller;
    private final String type;
    private int bitNr;
    //private int value;
    private boolean state;
    //Address for this sensor
    private final byte SENSOR_ADDRESS;
    
    public Sensor(String controllerName,String type, byte address)
    {
        this.controller = controllerName;
        this.type = type;
        this.bitNr = 0;
        this.state = false;
        this.SENSOR_ADDRESS = address;
    }
    
    /**
     * Returns the controller name connected to the sensor - String
     * @return Returns the controller name connected to the sensor - String
     */
    public String getController()
    {
        return this.controller;
    }
    /**
     * Returns the type of sensor in String
     * @return Returns the type of sensor in String
     */
    public String getType()
    {
        return this.type;
    }
    
    /**
     * Set the bit nr in the sensordata byte which is this sensor
     * @param bitNr Set the bit nr in the sensordata byte which holds information of this sensor
     */
    public void setBitNr(int bitNr)
    {
        this.bitNr = bitNr;
    }
    
    /**
     * Returns the bit nr in the sensordata byte where this sensor is represented
     * @return Returns the bit nr in the sensordata byte where this sensor is represented
     */
    public int getBitNr()
    {
        return this.bitNr;
    }
    
    /**
     * Set the state of the sensor(HIGH / LOW)
     * @param state The state wished to set upon this sensor
     */
     public void setState(boolean state)
    {
        if(state == true && this.state != true)
        this.state = state;
        
        if(state != true && this.state == true)
        this.state = state;
    }
    
     /**
      * Returns the state of the sensor(HIGH / LOW)
      * @return Returns the state of the sensor(HIGH / LOW)
      */
    public boolean getState()
    {
        return this.state;
    }
    
    /**
     * Return String representation of Sensor Address field
     * @return Return String representation of Sensor Address field
     */
    public String getStringAddress()
    {
        return Byte.toString(SENSOR_ADDRESS);
    }
    /**
     * Returns Address field for this sensor
     * @return Returns Address field in single byte for this sensor
     */
    public byte getAddress()
    {
        return this.SENSOR_ADDRESS;
    }
    
    /*
        public void setValue(int inValue)
    {
        this.value = inValue;
    }
    
    public int getValue()
    {
        return this.value;
    }
    */
}
