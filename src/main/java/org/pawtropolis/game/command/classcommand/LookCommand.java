package org.pawtropolis.game.command.classcommand;

import lombok.AllArgsConstructor;
import org.pawtropolis.game.command.iface.Command;
import org.pawtropolis.game.controller.MapController;

@AllArgsConstructor
public class LookCommand implements Command {
    private final MapController mapController;

    private void lookRoom(){
        mapController.getCurrentRoom().printItems();
        mapController.getCurrentRoom().printAnimals();
    }

    @Override
    public void execute() {
        lookRoom();
    }
}