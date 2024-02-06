package org.pawtropoliscity.game.controller;

import org.pawtropoliscity.game.entity.Coordinate;
import org.pawtropoliscity.game.entity.Room;
import java.util.Objects;

import static org.pawtropoliscity.game.controller.CommandController.*;
import static org.pawtropoliscity.game.controller.MapController.roomMap;
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

    public static Coordinate userPosition = new Coordinate(0,0);

    private Coordinate coordinate;



    public void printRoomNotFound(){
        System.out.println("Room not found\n");
    }

    public void printYouAreHere() {
        System.out.println( CommandController.player.getName() + " You are here:  " + roomMap.get(userPosition).getName() + "\n");

            System.out.println("Adjacent Rooms:");

            printAdjacentRoom(userPosition.getY() - 1, userPosition.getX(), "North");
            printAdjacentRoom(userPosition.getY() + 1, userPosition.getX(), "South");
            printAdjacentRoom(userPosition.getY(), userPosition.getX() - 1, "West");
            printAdjacentRoom(userPosition.getY(), userPosition.getX() + 1, "East");

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
        if(Room.checkPoison()!= null) {
            player.setLifePoints((int) (player.getLifePoints() - Objects.requireNonNull(Room.checkPoison()).getSlotsRequired()));
        }
        if (player.getLifePoints() == 0){
            printLifeOfPointFinish();
            System.exit(0);
        } else {
            printCurrentLifeOfPoint();
        }
    }

    public void goToNorth() {
        coordinate = new Coordinate(userPosition.getY() - 1, userPosition.getX());
        if(roomMap.containsKey(coordinate)) {
            userPosition = coordinate;
            printYouAreHere();
            pointOfPlayer();
        }else {
            printRoomNotFound();
        }
    }
    public void goToEast(){
        coordinate = new Coordinate(userPosition.getY(), userPosition.getX() + 1);
        if(roomMap.containsKey(coordinate)) {
            userPosition = coordinate;
            printYouAreHere();
            pointOfPlayer();
        }else {
            printRoomNotFound();
        }
    }
    public void goToSouth(){
        coordinate = new Coordinate(userPosition.getY() + 1, userPosition.getX());
        if(roomMap.containsKey(coordinate)) {
            userPosition = coordinate;
            printYouAreHere();
            pointOfPlayer();
        }else {
            printRoomNotFound();
        }
    }

    public void goToWest(){
        coordinate = new Coordinate(userPosition.getY(), userPosition.getX() - 1);
        if(roomMap.containsKey(coordinate)) {
            userPosition = coordinate;
            printYouAreHere();
            pointOfPlayer();
        }else {
            printRoomNotFound();
        }
    }






}
