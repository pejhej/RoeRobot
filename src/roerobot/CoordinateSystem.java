/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roerobot;

/**
 * This Class is a representation of a cartetian coordinate system. It has
 * stored the upper and the lover boundries for the coordinate system.
 *
 * @author Yngve
 */
public class CoordinateSystem {

    private final int XUpperLimit, YUpperLimit, ZUpperLimit;
    private final int XLowerLimit = 0, YLowerLimit = 0, ZLowerLimit = 0;

    public CoordinateSystem(int XUpperLimit, int YUpperLimit, int ZUpperLimit) {
        this.XUpperLimit = XUpperLimit;
        this.YUpperLimit = YUpperLimit;
        this.ZUpperLimit = ZUpperLimit;
    }

    /**
     * @return X upper limit
     */
    public int getXUpperLimit() {
        return XUpperLimit;
    }

    /**
     * @return Y upper limit
     */
    public int getYUpperLimit() {
        return YUpperLimit;
    }

    /**
     * @return Z upper limit
     */
    public int getZUpperLimit() {
        return ZUpperLimit;
    }

    /**
     * @return X lower limit
     */
    public int getXLowerLimit() {
        return XLowerLimit;
    }

    /**
     * @return Y lower limit
     */
    public int getYLowerLimit() {
        return YLowerLimit;
    }

    /**
     * @return lower limit
     */
    public int getZLowerLimit() {
        return ZLowerLimit;
    }

}
