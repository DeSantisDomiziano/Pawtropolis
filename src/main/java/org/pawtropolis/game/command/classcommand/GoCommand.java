package org.pawtropolis.game.command.classcommand;

import lombok.AllArgsConstructor;
import org.pawtropolis.game.command.iface.CommandParameterized;
import org.pawtropolis.game.controller.MapController;
import org.pawtropolis.game.entity.Player;
import org.pawtropolis.game.entity.Room;

@AllArgsConstructor
public class GoCommand implements CommandParameterized {
    private final MapController mapController;
    private final Player player;

    private void printInvalidDirection() {
        System.out.println("You can't move in that direction.");
    }


    @Override
    public void execute(String roomName) {
        Room nextRoom = mapController.getAdjacentRoom(roomName);

        if (mapController.containsAdjacentRoom(nextRoom)) {
            mapController.setCurrentRoom(nextRoom);
            mapController.decrementLifePoints(nextRoom, player);
            mapController.handlePlayerGameOver(player);
        } else {
            printInvalidDirection();
        }
    }

    @Override
    public void execute() {

    }
}

