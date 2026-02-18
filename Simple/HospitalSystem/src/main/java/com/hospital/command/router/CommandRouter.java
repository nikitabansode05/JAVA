package com.hospital.command.router;

import java.util.Map;

import com.hospital.command.entity.Command;

import java.util.HashMap;
import com.hospital.command.entity.*;

public class CommandRouter {
    private final Map<String, Command> commandMap = new HashMap<>();
    public void register(String commandName,Command command){
        commandMap.put(commandName,command);
    }

    public boolean contains(String commandName){
        return commandMap.containsKey(commandName);
    }

    public int execute(String commandName,int a,int b){
        return commandMap.get(commandName).execute(a,b);
    }

    public void showHelp(){
        System.out.println("Available commands : ");
        commandMap.keySet().forEach(cmd -> System.out.println(" - " + cmd));

    }
}
