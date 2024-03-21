package org.pawtropolis.game.command.classcommand;

import org.pawtropolis.game.command.iface.Command;

public class HelpCommand implements Command {

    public HelpCommand() {
    }

    private void printHelpCommandsMessage() {
        System.out.println("""
                these are all commands:\s
                👀look
                👜bag
                🏃‍♀️go <choose direction> example -> 1)go north OR 2)go north_east
                🗑️drop <name item>
                🛒get <name item>
                exit
                """);
    }

    @Override
    public void execute() {
        printHelpCommandsMessage();
    }
}
