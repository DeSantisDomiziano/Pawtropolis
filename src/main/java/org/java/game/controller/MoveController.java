package org.java.game.controller;

import org.java.game.entity.Coordinate;
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
        System.out.println("room not found");
    }
    public void printYouAreHere(){
        System.out.println("you are here:  " + roomMap.get(userPosition).getName());
    }
    public void  printCommandNotFound(){System.out.println("Command not found. Repeat the command");}
    private void goToNorth() {
        coordinate = new Coordinate(userPosition.getY() - 1, userPosition.getX());
        if(roomMap.containsKey(coordinate)) {
            userPosition = coordinate;
            printYouAreHere();
        }else {
            printRoomNotFound();
        }
    }
    private void goToEast(){
        coordinate = new Coordinate(userPosition.getY(), userPosition.getX() + 1);

        if(roomMap.containsKey(coordinate)) {
            userPosition = coordinate;
            printYouAreHere();

        }else {
            printRoomNotFound();
        }
    }
    private void goToSouth(){
        coordinate = new Coordinate(userPosition.getY() + 1, userPosition.getX());

        if(roomMap.containsKey(coordinate)) {
            userPosition = coordinate;
            printYouAreHere();
        }else {
            printRoomNotFound();
        }
    }

    private void goToWest(){
        coordinate = new Coordinate(userPosition.getY(), userPosition.getX() - 1);

        if(roomMap.containsKey(coordinate)) {
            userPosition = coordinate;
            printYouAreHere();
        }else {
            printRoomNotFound();
        }
    }

    public void changeRoom(int inputPosition){

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
            default:
                printCommandNotFound();
        }
    }





}
