package org.pawtropolis.game.controller;

import org.pawtropolis.game.command.iface.Command;
import org.pawtropolis.game.command.classcommand.*;
import org.pawtropolis.game.command.classcommand.GoCommand;
import org.pawtropolis.game.entity.Bag;
import org.pawtropolis.game.entity.Player;
import org.pawtropolis.game.entity.Room;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;


public class CommandController {
    private static CommandController instance = null;
    private final Bag bag = new Bag();

    private CommandController(){}

    public static CommandController getInstance(){
        if (instance == null){
            instance = new CommandController();
        }
        return instance;
    }

    private void printInvalidCommand(){
        System.out.println("Invalid command\n");
    }

    protected void launchCommand(String input, Room room, Player player, ExitCommand exitCommand){
        String[] splitInput = input.split(" ");
        String lastElement = splitInput[splitInput.length -1];
        String command = splitInput[0];

        Map<String, Supplier<Command>> commandActionMap = new HashMap<>();
        commandActionMap.put("go", () -> new GoCommand(room, player, lastElement));
        commandActionMap.put("get", () -> new GetCommand( player, bag, lastElement));
        commandActionMap.put("drop", () -> new DropCommand( player, bag, lastElement));
        commandActionMap.put("look", () -> new LookCommand(player));
        commandActionMap.put("bag", () -> new BagCommand(bag));
        commandActionMap.put("help", HelpCommand::new);
        commandActionMap.put("exit", () -> exitCommand);

        try{
            commandActionMap.get(command).get().execute();
        }catch (NullPointerException e){
            printInvalidCommand();
        }


    }


}

