/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roerobot;

/**
 *
 * @author Yngve
 */
public class Logics implements Runnable {

    private CoordinateSystem coordSyst;
    private RackRegiser rackRegister;
    private final int trayWidth = 900; //mm 
    private final int trayDepth = 330; //mm 
    private final int distUpperLowerPos = 0; // distanse from upper positon to the lowest position in the tray i mm. 
    private boolean calibButton = false;
    private boolean startButton = false;

    public Logics() {
        this.coordSyst = new CoordinateSystem();
        this.rackRegister = new RackRegiser();
    }

    @Override
    public void run() {
        if (calibButton) {
            this.commandCase("calibrate");
        }
    }
    
    /**
     * Command case works as a state machine for handeling the tasks for the
     * roebot.
     *
     * @param command
     */
    private void commandCase(String command) {
        switch (command.toLowerCase()) {
            case "still":
            case "calibrate":
                this.doCalibrate();
            case "wait":
            case "updatecalibrationdata":
            case "move":
            case "waitforpicture":
            case "calculatenewcoord":
            case "suck":
            case "updatevaluse":
        }
    }

    private void doCalibrate() {
        // TODO: Find the calibrate command in the command register. 
        // TODO: Call on a method in the communication class and deliver the 
        //       calibration command 
    }

    /**
     * Adds trays to register.
     */
    private void addTrayToRack(int upperPos) {
        Tray tray = new Tray(trayWidth, trayDepth, distUpperLowerPos, upperPos);
        this.rackRegister.addToRegister(tray);
    }

    /**
     * Set start button works as a start button for ststing the logics.
     *
     * @param startButton
     */
    public void setStartButton(boolean startButton) {
        this.startButton = startButton;
    }

    /**
     * Set calibration button works as a start button for ststing the logics.
     *
     * @param calibButton
     */
    public void setCalibButton(boolean calibButton) {
        this.calibButton = calibButton;
    }

}
