package org.java.game.controller;

import org.java.game.entity.Coordinate;
import org.java.game.entity.Room;

import java.util.InputMismatchException;

import static org.java.game.controller.GameController.*;
import static org.java.game.controller.MapController.roomMap;
public class MoveController {

    private static MoveController instance = null;
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
        System.out.println( GameController.player.getName() + " You are here:  " + roomMap.get(userPosition).getName() + "\n");

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
    public void  printCommandNotFound(){System.out.println("Command not found. Repeat the command\n");}



    private void goToNorth() {
        coordinate = new Coordinate(userPosition.getY() - 1, userPosition.getX());
        if(roomMap.containsKey(coordinate)) {
            userPosition = coordinate;
            printYouAreHere();
            pointOfPlayer();
        }else {
            printRoomNotFound();
        }
    }
    private void goToEast(){
        coordinate = new Coordinate(userPosition.getY(), userPosition.getX() + 1);
        if(roomMap.containsKey(coordinate)) {
            userPosition = coordinate;
            printYouAreHere();
            pointOfPlayer();
        }else {
            printRoomNotFound();
        }
    }
    private void goToSouth(){
        coordinate = new Coordinate(userPosition.getY() + 1, userPosition.getX());
        if(roomMap.containsKey(coordinate)) {
            userPosition = coordinate;
            printYouAreHere();
            pointOfPlayer();
        }else {
            printRoomNotFound();
        }
    }

    private void goToWest(){
        coordinate = new Coordinate(userPosition.getY(), userPosition.getX() - 1);
        if(roomMap.containsKey(coordinate)) {
            userPosition = coordinate;
            printYouAreHere();
            pointOfPlayer();
        }else {
            printRoomNotFound();
        }
    }

    public void changeRoom(int inputPosition){
      try{
        switch (inputPosition) {
            case 1:
                goToNorth();
                break;
            case 2:
                goToSouth();
                break;
            case 3:
                goToWest();
                break;
            case 4:
                goToEast();
                break;
            case 5:
                break;
            default:
                printCommandNotFound();
        }
      }catch (InputMismatchException | NumberFormatException e) {
          printInsertValidNumber();
          scanner.nextLine();
      }
    }





}
