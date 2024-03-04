package org.pawtropolis.game.command.classcommand;

import org.pawtropolis.game.command.iface.Command;
import org.pawtropolis.game.controller.MapController;
import org.pawtropolis.game.entity.Player;

public class LookCommand implements Command {
    private final MapController mapController;
    private final Player player;

    public LookCommand(MapController mapController, Player player) {
        this.mapController = mapController;
        this.player = player;
    }

    private void lookRoom(){
        mapController.getRoom(player.getCurrentRoom()).printItems();
        mapController.getRoom(player.getCurrentRoom()).printAnimals();
    }

    @Override
    public void execute() {
        lookRoom();
    }
}
