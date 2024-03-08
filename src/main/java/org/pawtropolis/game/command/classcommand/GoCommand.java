package org.pawtropolis.game.command.classcommand;

import org.pawtropolis.game.command.iface.Command;
import org.pawtropolis.game.entity.Player;
import org.pawtropolis.game.entity.Room;


public class GoCommand implements Command {
    private final Room room;
    private final Player player;
    private final String roomName;

    private void printInvalidDirection() {
        System.out.println("You can't move in that direction.");
    }
    private void printGameOver(){
        System.out.println("game over");}


    public GoCommand(Room room, Player player, String roomName) {
        this.player = player;
        this.roomName = roomName;
        this.room = room;
    }

    @Override
    public void execute() {
        Room nextRoom = getAdjacentRoom();

        if (room.containsRoom(player, nextRoom)) {
            player.setCurrentRoom(nextRoom);
            player.decrementLifePoints(nextRoom);
            gameOver();
        } else {
            printInvalidDirection();
        }
    }

    public void gameOver(){
        if (player.isDead()) {
            printGameOver();
            System.exit(0);
        }
    }

    private Room getAdjacentRoom() {
        return room.getRoom(player, roomName);
    }
}

