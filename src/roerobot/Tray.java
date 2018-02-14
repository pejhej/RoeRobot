/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roerobot;

/**
 * Class represents a tray. The tray has a width, hight and a depth. The tray
 * will also know where it is plased in a coordinate system by knowing its upper
 * and lower posistion.
 *
 * @author Yngve
 */
public class Tray {

    private final int width, depth; // defined in mm 
    private final int distUpperLowerPos; // Distanse form the upper position to the lowest point in the tray
    private final int upperPos; // defined in mm parallel to the Z-axis 
    private final int lowerPos; // defined in mm parallel to the Z-axis
    private int nrOfRemovedRoe;

    public Tray(int width, int depth, int distUpperLowerPos, int upperPos) {
        this.width = width;
        this.depth = depth;
        this.distUpperLowerPos = distUpperLowerPos;
        this.upperPos = upperPos;
        this.lowerPos = this.upperPos - this.distUpperLowerPos;
    }

    /**
     * Get upper position returns the upper limit position of the tray defined
     * in mm from the bottom of a global coordinat system
     *
     * @return
     */
    public int getUpperPos() {
        return upperPos;
    }

    /**
     * Get lower position returns the lower limit position of the tray defined
     * in mm from the bottom of a global coordinat system
     *
     * @return
     */
    public int getLowerPos() {
        return lowerPos;
    }

    /**
     * Get distanse between upper and lower position
     *
     * @return int with lower positon.
     */
    public int getDistUpperLowerPos() {
        return distUpperLowerPos;
    }

    /**
     * Increase the number of removed dead roe in the tray.
     *
     * @param removedRoe is the number of dead roe witch has been removed.
     */
    public void increaseNrOfRemovedRoe(int removedRoe) {
        this.nrOfRemovedRoe = this.nrOfRemovedRoe + removedRoe;
    }

    /**
     * Get number of removed roe returns the total number of dead roe witch has
     * been removed from the tray.
     *
     * @return number of removed roe.
     */
    public int getNrOfRemovedRoe() {
        return nrOfRemovedRoe;
    }

    /**
     * Get width returns the width of the tray
     *
     * @return width of tray
     */
    public int getWidth() {
        return width;
    }

    /**
     * Get depth returns the width of the tray
     *
     * @return depth of tray
     */
    public int getDepth() {
        return depth;
    }

}
