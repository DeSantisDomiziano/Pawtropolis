package org.java.animals.controller;

import org.java.animals.entity.Coordinate;

import java.util.Locale;

import static org.java.animals.controller.MapController.roomMap;
public class MoveController {

    private static MoveController instance = null;
    public static MoveController getInstance() {
        if( instance == null) {
            instance = new MoveController();
        }
        return instance;
    }
    public static Coordinate userPosition = new Coordinate(1,0);

    private Coordinate coordinate;


    private void goToNorth() {
        coordinate = new Coordinate(userPosition.getY() - 1, userPosition.getX());

        if(roomMap.containsKey(coordinate)) {
            userPosition.minusY();
            System.out.println("you are here:  " + roomMap.get(userPosition).getName());
        }else {
            System.out.println("room not found");
        }
    }
    private void goToEast(){
        coordinate = new Coordinate(userPosition.getY(), userPosition.getX() + 1);

        if(roomMap.containsKey(coordinate)) {
            userPosition.plusX();
            System.out.println("you are here:  " + roomMap.get(userPosition).getName());
        }else {
            System.out.println("room not found");
        }
    }
    private void goToSouth(){
        coordinate = new Coordinate(userPosition.getY() + 1, userPosition.getX());

        if(roomMap.containsKey(coordinate)) {
            userPosition.plusY();
            System.out.println("you are here:  " + roomMap.get(userPosition).getName());
        }else {
            System.out.println("room not found");
        }
    }

    private void goToWest(){
        coordinate = new Coordinate(userPosition.getY(), userPosition.getX() - 1);

        if(roomMap.containsKey(coordinate)) {
            userPosition.minusX();
            System.out.println("you are here: " + roomMap.get(userPosition).getName());
        }else {
            System.out.println("room not found");
        }
    }


    public void changeRoom(String inputPosition ){
        String command = inputPosition.toLowerCase();

        switch (command) {
            case "go north":
                goToNorth();
                break;
            case "go south":
                goToSouth();
                break;
            case "go west":
                goToWest();
                break;
            case "go east":
                goToEast();
                break;
            default:
                System.out.println("command not found");
        }
    }





}
