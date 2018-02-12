/*
 * This is a interface used for notifying listeners of when new data is 
 * available in the I2C communication. 
 * Listeners must be added to the list of listeners in the communication object.
 */
package Communication;

/**
 *
 * @author KristianAndreLilleindset
 */
public interface I2CListener 
{
    /**
     * Method called on classes implementing this interface.
     */
    public void I2CDataAvailable();
}
