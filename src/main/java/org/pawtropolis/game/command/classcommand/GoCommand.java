package org.pawtropolis.game.command.classcommand;

import org.pawtropolis.game.command.iface.Command;
import org.pawtropolis.game.controller.MapController;
import org.pawtropolis.game.entity.Coordinate;
import org.pawtropolis.game.entity.Direction;
import org.pawtropolis.game.entity.Player;
import org.pawtropolis.game.entity.Room;

import java.util.HashMap;
import java.util.Map;

public class GoCommand  implements Command {
    private final MapController mapController;
    private final Player player;
    private final Map<String, Direction> moveCommandMapper = new HashMap<>();
    private final String direction;

    public GoCommand(MapController mapController, Player player, String direction) {
        this.mapController = mapController;
        this.player = player;
        this.direction = direction;

        moveCommandMapper.put("north", Direction.NORTH);
        moveCommandMapper.put("south", Direction.SOUTH);
        moveCommandMapper.put("east", Direction.EAST);
        moveCommandMapper.put("west", Direction.WEST);
        moveCommandMapper.put("north east", Direction.NORTH_EAST);
        moveCommandMapper.put("north west", Direction.NORTH_WEST);
        moveCommandMapper.put("south east", Direction.SOUTH_EAST);
        moveCommandMapper.put("south west", Direction.SOUTH_WEST);

    }

    public void printRoomNotFound(){
        System.out.println("Room not found\n");
    }

    private void commandNotFound(String input){
        System.out.println("Command not recognized: " + input);
    }


    private void printAdjacentRoom(int y, int x, String direction) {
        Coordinate adjacentCoordinate = new Coordinate(y, x);
        Room adjacentRoom = mapController.getRoom(adjacentCoordinate);
        if (adjacentRoom != null) {
            System.out.println(direction + ": " + adjacentRoom.getName());
        }
    }

    public void printCurrentRoomDescription() {
        System.out.println( player.getName() + " You are here:  " + mapController.getRoom(player.getCoordinate()).getName() + "\n");

        System.out.println("Adjacent Rooms:");

        printAdjacentRoom(player.getCoordinate().getY() - 1, player.getCoordinate().getX(), "North");
        printAdjacentRoom(player.getCoordinate().getY() + 1, player.getCoordinate().getX(), "South");
        printAdjacentRoom(player.getCoordinate().getY(), player.getCoordinate().getX() - 1, "West");
        printAdjacentRoom(player.getCoordinate().getY(), player.getCoordinate().getX() + 1 , "East");

        System.out.println();
    }

    public void printCurrentLifeOfPoint(){
        System.out.println("your current life of point are : " + player.getLifePoints());
    }
    private void printGameOver(){
        System.out.println(" GAME OVER " );
    }

    public void currentLifePoints() {
        Room room = mapController.getRoom(player.getCoordinate());
        player.decrementLifePoints(room);
        printCurrentLifeOfPoint();

        if (player.isDead()){
            printGameOver();
            System.exit(0);
        }
    }

    protected void changeRoom(Direction direction) {
        Coordinate coordinate = new Coordinate(player.getCoordinate().getY() + direction.getY(),
                player.getCoordinate().getX() + direction.getX());

        if (mapController.containsCoordinate(coordinate)) {
            player.setCoordinate(coordinate);
            printCurrentRoomDescription();
            currentLifePoints();
        }else {
            printRoomNotFound();
        }
    }


    @Override
    public void execute() {
        Direction move = moveCommandMapper.get(direction.toLowerCase().trim());
        System.out.println(direction);

        if(move != null) {
            changeRoom(move);
        } else  {
            commandNotFound(direction);
        }
    }
}
