package org.pawtropolis.game.command.classcommand;

import org.pawtropolis.game.command.iface.Command;
import org.pawtropolis.game.controller.MapController;

public class LookCommand implements Command {
    private final MapController mapController;

    public LookCommand( MapController mapController) {
        this.mapController = mapController;
    }

    private void lookRoom(){
        mapController.getCurrentRoom().printItems();
        mapController.getCurrentRoom().printAnimals();
    }

    @Override
    public void execute() {
        lookRoom();
    }
}