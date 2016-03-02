/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dumiduh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author dumiduh
 */
public class ShellExecutor {
private String command;
 
public ShellExecutor(String cmd)
{
    this.command=cmd;
}


public String execute()
{
    StringBuilder output = new StringBuilder();
    Process p;
    try
    {
        p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader = 
                            new BufferedReader(new InputStreamReader(p.getInputStream()));
 
                        String line = "";			
			while ((line = reader.readLine())!= null) {
				output.append(line + "\n");
			}
    }
    catch(IOException e)
    {
        e.printStackTrace();
    }
    catch(InterruptedException e)
    {
        e.printStackTrace();
    }
    
    return output.toString();
}
}
