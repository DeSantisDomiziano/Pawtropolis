package org.pawtropolis.game.controller;

import org.pawtropolis.game.command.iface.Command;
import org.pawtropolis.game.command.classcommand.*;
import org.pawtropolis.game.command.classcommand.GoCommand;
import org.pawtropolis.game.entity.Bag;
import org.pawtropolis.game.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;


public class CommandController {
    private static CommandController instance = null;
    private final Bag bag = new Bag();

    private CommandController(){

    }

    public static CommandController getInstance(){
        if (instance == null){
            instance = new CommandController();
        }
        return instance;
    }

    private void printInvalidCommand(){
        System.out.println("Invalid command\n");
    }

    protected void launchCommand(String input, MapController mapController, Player player, ExitCommand exitCommand){
        String[] splitInput = input.split(" ");
        String lastElement = splitInput[splitInput.length -1];
        String command = splitInput[0];

        Map<String, Supplier<Command>> commandMapper = new HashMap<>();
        commandMapper.put("go", () -> new GoCommand(mapController, player, lastElement));
        commandMapper.put("get", () -> new GetCommand(mapController, player, bag, lastElement));
        commandMapper.put("drop", () -> new DropCommand(mapController, player, bag, lastElement));
        commandMapper.put("look", () -> new LookCommand(mapController, player));
        commandMapper.put("bag", () -> new BagCommand(bag));
        commandMapper.put("help", HelpCommand::new);
        commandMapper.put("exit", () -> exitCommand);

        try{
            commandMapper.get(command).get().execute();
        }catch (NullPointerException e){
            printInvalidCommand();
        }


    }


}

