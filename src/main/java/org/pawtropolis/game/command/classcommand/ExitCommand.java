package org.pawtropolis.game.command.classcommand;

import org.pawtropolis.game.command.iface.Command;

public class ExitCommand implements Command {
    private boolean exit = false;

    public ExitCommand() {

    }


    private void quitGame(){
        setExit(true);
    }

    public boolean isExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }

    @Override
    public void execute() {
        quitGame();
    }
}
