package org.pawtropolis.game.controller;

import org.pawtropolis.game.command.iface.Command;
import org.pawtropolis.game.command.classcommand.*;
import org.pawtropolis.game.command.classcommand.GoCommand;
import org.pawtropolis.game.command.iface.CommandParameterized;
import org.pawtropolis.game.entity.Player;

import java.util.HashMap;
import java.util.Map;


public class CommandController {
    private static CommandController instance = null;
    private final Map<String, Command> commands;

    private CommandController(MapController mapController, Player player){
        commands = new HashMap<>();
        commands.put("go", new GoCommand(mapController, player));
        commands.put("get", new GetCommand(mapController, player.getBag()));
        commands.put("drop", new DropCommand(mapController, player.getBag()));
        commands.put("look",  new LookCommand(mapController));
        commands.put("bag",  new BagCommand(player.getBag()));
        commands.put("help", new HelpCommand());
        commands.put("exit",  new ExitCommand());
    }

    public static CommandController getInstance(MapController mapController, Player player){
        if (instance == null){
            instance = new CommandController(mapController, player);
        }
        return instance;
    }

    private void printInvalidCommand(){
        System.out.println("Invalid command\n");
    }

    protected void launchCommand(String input) {
        String[] tokens = input.split("\\s+", 2);
        String parameter = tokens[tokens.length - 1];
        String commandName = tokens[0];

        Command command = commands.get(commandName);
        if (command == null) {
            printInvalidCommand();
            return;
        }
        if (command instanceof CommandParameterized) {
            ((CommandParameterized) command).execute(parameter);
        } else {
            command.execute();
        }
    }
}

