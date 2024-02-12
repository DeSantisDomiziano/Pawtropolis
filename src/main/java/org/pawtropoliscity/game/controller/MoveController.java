package org.pawtropoliscity.game.controller;

import org.pawtropoliscity.game.entity.Coordinate;
import org.pawtropoliscity.game.entity.Move;
import org.pawtropoliscity.game.entity.Room;
import java.util.Objects;

import static org.pawtropoliscity.game.controller.GameController.*;
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

    public void printYouAreHere() {

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
    public static void  printCommandNotFound(){System.out.println("Command not found. Repeat the command\n");}

    public void pointOfPlayer() {
        Room room = roomMap.get(player.getCoordinate());
        if(room.checkPoison()!= null) {
            player.setLifePoints((int) (player.getLifePoints() - Objects.requireNonNull(room.checkPoison()).getSlotsRequired()));
        }
        if (player.getLifePoints() == 0){
            printLifeOfPointFinish();
            System.exit(0);
        } else {
            printCurrentLifeOfPoint();
        }
    }



    public void movePlayer(Move move) {

        switch (move){
            case NORTH:
                coordinate = new Coordinate(player.getCoordinate().getY() + Move.NORTH.getY(), player.getCoordinate().getX());
                break;
            case SOUTH:
                coordinate = new Coordinate(player.getCoordinate().getY() + Move.SOUTH.getY(), player.getCoordinate().getX());
                break;
            case WEST:
                coordinate = new Coordinate(player.getCoordinate().getY(), player.getCoordinate().getX() + Move.WEST.getX());
                break;
            case EAST:
                coordinate = new Coordinate(player.getCoordinate().getY(), player.getCoordinate().getX() + Move.EAST.getX());
                break;
        }

        if (roomMap.containsKey(coordinate)) {
            player.setCoordinate(coordinate);
            printYouAreHere();
        }else {
            printRoomNotFound();
        }

    }
}