package org.pawtropolis.game.command.classcommand;

import org.pawtropolis.game.command.iface.Command;
import org.pawtropolis.game.controller.GameController;

public class ExitCommand implements Command {

    public ExitCommand() {
    }

    public void quitGame(){
        GameController.getInstance().setQuitGame(true);
    }

    @Override
    public void execute() {
        quitGame();
    }
}
