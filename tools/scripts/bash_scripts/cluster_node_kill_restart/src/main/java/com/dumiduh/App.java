package com.dumiduh;


import java.util.Random;
/**
 * 
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      
        
        int elapse = new Random().nextInt(9)+1;
        elapse=elapse*60000;
        System.out.println("Application Started \t elapse : "+elapse);
        
        if(args[0].equals("restart"))
        {
        new java.util.Timer().schedule(new java.util.TimerTask() {
            @Override
            public void run() {
                Controller controller = new Controller();
                controller.restartWSO2Server();
            }
        }, 
        elapse);
        }
        else if (args[0].equals("kill"))
        {
            new java.util.Timer().schedule(new java.util.TimerTask() {
            @Override
            public void run() {
                Controller controller = new Controller();
                controller.findAndKill();
            }
        }, 
        elapse);
        }
        else if (args[0].equals("shutdown"))
        {
            new java.util.Timer().schedule(new java.util.TimerTask() {
            @Override
            public void run() {
                Controller controller = new Controller();
                controller.shutdownWSO2Server();
            }
        }, 
        elapse);
        }
        else
        {
            System.out.println("Please provide operation.");
        }
    }
}
