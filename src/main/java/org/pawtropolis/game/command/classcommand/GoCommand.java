package org.pawtropolis.game.command.classcommand;

import org.pawtropolis.game.command.iface.Command;
import org.pawtropolis.game.controller.MapController;
import org.pawtropolis.game.entity.RoomNode;
import org.pawtropolis.game.entity.Player;


    public class GoCommand implements Command {
        private final MapController mapController;
        private final Player player;
        private final String direction;

        private void invalidDirection() {
            System.out.println("You can't move in that direction.");
        }


        public GoCommand(MapController mapController, Player player, String direction) {
            this.mapController = mapController;
            this.player = player;
            this.direction = direction;
        }

        @Override
        public void execute() {
            RoomNode nextRoomNode = getAdjacentRoomNode( direction);

            if (nextRoomNode != null) {
                player.setCurrentRoom(nextRoomNode);
            } else {
                invalidDirection();
            }
        }

        private RoomNode getAdjacentRoomNode(String direction) {
            return mapController.getRoomNode(direction);
        }
    }

