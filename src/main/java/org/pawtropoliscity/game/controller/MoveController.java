package org.pawtropoliscity.game.controller;

import org.pawtropoliscity.game.entity.Coordinate;
import org.pawtropoliscity.game.entity.Direction;
import org.pawtropoliscity.game.entity.Room;

import static org.pawtropoliscity.game.controller.MapController.roomMap;
import static org.pawtropoliscity.game.entity.Player.player;

public class MoveController {

    private static MoveController instance = null;

    private MoveController(){

    }

    public static MoveController getInstance() {
        if( instance == null) {
            instance = new MoveController();
        }
        return instance;
    }

    private Coordinate coordinate;



    public void printRoomNotFound(){
        System.out.println("Room not found\n");
    }

    public void printCurrentRoomDescription() {

        System.out.println( player.getName() + " You are here:  " + roomMap.get(player.getCoordinate()).getName() + "\n");

            System.out.println("Adjacent Rooms:");

            printAdjacentRoom(player.getCoordinate().getY() - 1, player.getCoordinate().getX(), "North");
            printAdjacentRoom(player.getCoordinate().getY() + 1, player.getCoordinate().getX(), "South");
            printAdjacentRoom(player.getCoordinate().getY(), player.getCoordinate().getX() - 1, "West");
            printAdjacentRoom(player.getCoordinate().getY(), player.getCoordinate().getX() + 1 , "East");

            System.out.println();
    }

    private void printAdjacentRoom(int y, int x, String direction) {
        Coordinate adjacentCoordinate = new Coordinate(y, x);
        Room adjacentRoom = roomMap.get(adjacentCoordinate);
        if (adjacentRoom != null) {
            System.out.println(direction + ": " + adjacentRoom.getName());
        }
    }


    public void changeRoom(Direction direction) {

        coordinate = new Coordinate(player.getCoordinate().getY() + direction.getY(), player.getCoordinate().getX() + direction.getX());

        if (roomMap.containsKey(coordinate)) {
            player.setCoordinate(coordinate);
            printCurrentRoomDescription();
        }else {
            printRoomNotFound();
        }

    }
}