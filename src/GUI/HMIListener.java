/*
 * This interface is used for notifying listeners of the HMI.
 * Listeners must be added to the list of listeners in the HMI object
 */
package GUI;

/**
 *
 * @author KristianAndreLilleindset
 */
public interface HMIListener 
{
    /**
     * Method called on classes implementing this interface.
     */
    public void HMIEvent();
}
