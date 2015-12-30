/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dumiduh;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author dumiduh
 */
public class Controller {
private ArrayList<NodeDTO> nodes;
private int noNodes;
private int nodeSelection;
private final String FINDPIDSCRIPT="sh "+new File("").getAbsolutePath()+"/resources/findpid.sh"; 
private final String KILLPROSSCRIPT="sh "+new File("").getAbsolutePath()+"/resources/killprocess.sh";
private final String FINDANDKILL="sh "+new File("").getAbsolutePath()+"/resources/findandkill.sh";
private final String RESTARTSERVER="sh "+new File("").getAbsolutePath()+"/resources/restart.sh";
private final String SHUTDOWNSERVER="sh "+new File("").getAbsolutePath()+"/resources/shutdown.sh";
private final String NODESXML="resources/Nodes.xml";
private String PID;

public Controller()
{
    ConfigurationReader confReader = new ConfigurationReader(NODESXML);
    confReader.readConfig();
    nodes=confReader.getNodes();
    noNodes=nodes.size();
    
    Random ran = new Random();
    nodeSelection = ran.nextInt(noNodes);
}


public void findPID()
{   
    
    
    String cmd =FINDPIDSCRIPT+" "+nodes.get(nodeSelection).getKeyPath()+" "+nodes.get(nodeSelection).getUsername()+" "+nodes.get(nodeSelection).getIp()+" "+nodes.get(nodeSelection).getKeyword();
    ShellExecutor executor = new ShellExecutor(cmd);
       
    PID = executor.execute();
    

    //write check to see if valid.
    
    String[] pidV= PID.split("\\s+");
    PID=pidV[0];
    
}


public void findAndKill()
{
    String cmd =FINDANDKILL+" "+nodes.get(nodeSelection).getKeyPath()+" "+nodes.get(nodeSelection).getUsername()+" "+nodes.get(nodeSelection).getIp()+" "+nodes.get(nodeSelection).getKeyword();
    ShellExecutor executor = new ShellExecutor(cmd);
    System.out.println("process killed on "+nodes.get(nodeSelection).getIp()+" for keyword "+nodes.get(nodeSelection).getKeyword());
    String result = executor.execute();
}

public void restartWSO2Server()
{
    String resPath = new File("").getAbsolutePath()+"/resources";
    String cmd =RESTARTSERVER+" "+nodes.get(nodeSelection).getKeyPath()+" "+nodes.get(nodeSelection).getUsername()+" "+nodes.get(nodeSelection).getIp()+" "+resPath;
    ShellExecutor executor = new ShellExecutor(cmd);
    String result = executor.execute();
    System.out.println(result);
    
    
}

public void shutdownWSO2Server()
{
    String resPath = new File("").getAbsolutePath()+"/resources";
    String cmd =SHUTDOWNSERVER+" "+nodes.get(nodeSelection).getKeyPath()+" "+nodes.get(nodeSelection).getUsername()+" "+nodes.get(nodeSelection).getIp()+" "+resPath;
    ShellExecutor executor = new ShellExecutor(cmd);
    String result = executor.execute();
    System.out.println(result);
}

}
