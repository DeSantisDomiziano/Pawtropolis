package org.pawtropolis.game.command.classcommand;

import org.pawtropolis.game.command.iface.Command;
import org.pawtropolis.game.controller.MapController;
import org.pawtropolis.game.entity.Player;
import org.pawtropolis.game.entity.Room;


public class GoCommand implements Command {
    private final MapController mapController;
    private final Player player;
    private final String roomName;

    private void printInvalidDirection() {
        System.out.println("You can't move in that direction.");
    }


    public GoCommand(MapController mapController, Player player, String roomName) {
        this.player = player;
        this.roomName = roomName;
        this.mapController = mapController;
    }

    @Override
    public void execute() {
        Room nextRoom = mapController.getAdjacentRoom(roomName);

        if (mapController.containsAdjacentRoom(nextRoom)) {
            mapController.setCurrentRoom(nextRoom);
            mapController.decrementLifePoints(nextRoom, player);
            mapController.changeGameOver(player);
        } else {
            printInvalidDirection();
        }
    }

}

