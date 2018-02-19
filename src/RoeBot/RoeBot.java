package RoeBot;

import Communication.Communication;
import GUI.HMI;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import ImageProcessing.ImageProcessing;
import roerobot.Logics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Main class, initiates the project. 
 * 
 * @author KristianAndreLilleindset
 * @ version 12-02-2018
 */
public class RoeBot 
{
    // creating variables for executor and number of threads
    private final int THREADS_IN_POOL = 10;
    private ScheduledExecutorService threadPool; 
    
    // creating variables for objects
    private Communication I2CCommunication; 
    private HMI humanMachineInterface; 
    private ImageProcessing imageProcessing;
    private Logics roeRobot;
 
    public static void main(String[] args)
    {
        RoeBot roeBot = new RoeBot();
        roeBot.initiate();
    }

    /**
     * Creating executor, objects and starting threads
     */
    private void initiate() 
    {
        this.threadPool = Executors.newScheduledThreadPool(THREADS_IN_POOL);
        
        this.I2CCommunication = new Communication();
        this.I2CCommunication.run();
        
        this.humanMachineInterface = new HMI();
        
        this.imageProcessing = new ImageProcessing();
        
        this.roeRobot = new Logics();
        
    }
}
