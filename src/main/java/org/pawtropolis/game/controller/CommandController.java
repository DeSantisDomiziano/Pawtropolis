package org.pawtropolis.game.controller;

import org.pawtropolis.game.command.iface.Command;
import org.pawtropolis.game.command.classcommand.*;
import org.pawtropolis.game.command.classcommand.GoCommand;
import org.pawtropolis.game.entity.Bag;
import org.pawtropolis.game.entity.Player;

import java.util.HashMap;
import java.util.Map;


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

    protected void launchCommand(String input, Player player, MapController mapController, ExitCommand exitCommand){
        String[] tokens = input.split(" ");
        String parameter = tokens[tokens.length -1];
        String commandName = tokens[0];

        Map<String, Command> commands = new HashMap<>();
        commands.put("go", new GoCommand(mapController, player, parameter));
        commands.put("get", new GetCommand( mapController, bag, parameter));
        commands.put("drop", new DropCommand( mapController, bag, parameter));
        commands.put("look",  new LookCommand(mapController));
        commands.put("bag",  new BagCommand(bag));
        commands.put("help", new HelpCommand());
        commands.put("exit",  exitCommand);

        try{
            commands.get(commandName).execute();
        }catch (NullPointerException e){
            printInvalidCommand();
        }


    }


}

