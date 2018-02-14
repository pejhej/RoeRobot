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

    private final int width, hight, depth; // defined in mm 
    private int upperPos, lowerPos;        // defined in mm parallel to the Z-axis 
    private int nrOfRemovedRoe;

    public Tray(int width, int hight, int depth) {
        this.width = width;
        this.hight = hight;
        this.depth = depth;
    }

    /**
     * Set upper position setts the upper position of the tray relative to a
     * global coordinatsystem defined in mm
     *
     * @param upperPos
     */
    public void setUpperPos(int upperPos) {
        this.upperPos = upperPos;
    }

    /**
     * Set lower positon setts the lower position of the tray relative to a
     * global coordinatsystem defined in mm
     *
     * @param lowerPos
     */
    public void setLowerPos(int lowerPos) {
        this.lowerPos = lowerPos;
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
     * Get lower position Returns the lower limit position of the tray defined
     * in mm from the bottom of a global coordinat system
     *
     * @return int with lower positon.
     */
    public int getLowerPos() {
        return lowerPos;
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
     * @return width of tray
     */
    public int getWidth() {
        return width;
    }

    /**
     * Get hight returns the width of the tray
     * @return hight of tray
     */
    public int getHight() {
        return hight;
    }

    /**
     * Get depth returns the width of the tray
     * @return depth of tray
     */
    public int getDepth() {
        return depth;
    }

}
