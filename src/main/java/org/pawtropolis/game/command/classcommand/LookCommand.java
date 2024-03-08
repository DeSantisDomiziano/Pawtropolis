package org.pawtropolis.game.command.classcommand;

import org.pawtropolis.game.command.iface.Command;
import org.pawtropolis.game.entity.Player;

public class LookCommand implements Command {
    private final Player player;

    public LookCommand( Player player) {
        this.player = player;
    }

    private void lookRoom(){
    player.getCurrentRoom().printItems();
    player.getCurrentRoom().printAnimals();
    }

    @Override
    public void execute() {
        lookRoom();
    }
}
