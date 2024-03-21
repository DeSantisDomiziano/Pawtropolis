package org.pawtropolis.game.command.classcommand;

import lombok.NoArgsConstructor;
import org.pawtropolis.game.command.iface.Command;
import org.pawtropolis.game.controller.GameController;

@NoArgsConstructor
public class ExitCommand implements Command {

    public void quitGame(){
        GameController.getInstance().setQuitGame(true);
    }

    @Override
    public void execute() {
        quitGame();
    }
}
