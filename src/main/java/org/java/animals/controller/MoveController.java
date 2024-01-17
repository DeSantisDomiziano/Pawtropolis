package org.java.animals.controller;

import org.java.animals.entity.Coordinate;

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
                System.out.println("command not found");
        }
    }





}
