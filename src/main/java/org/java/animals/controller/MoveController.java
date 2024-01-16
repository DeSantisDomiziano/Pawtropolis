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
    public static Coordinate userPosition = new Coordinate(0,0);
    private Coordinate coordinate;
    int positionX = userPosition.getX();
    int positionY = userPosition.getY();


    private void goToNorth() {
        roomMap.get(userPosition);
        positionY -= 1;
        coordinate = new Coordinate(positionY, userPosition.getX());
        if(roomMap.containsKey(coordinate)) {
            userPosition.setY(positionY);
            System.out.println("you are here:  " + roomMap.get(coordinate).getName());
        }else {
            System.out.println("room not found");
        }
    }
    private void goToEast(){
        roomMap.get(userPosition);
        positionX += 1;
        coordinate = new Coordinate(userPosition.getY(), positionX);
        if(roomMap.containsKey(coordinate)) {
            userPosition.setX(positionX);
            System.out.println("you are here:  " + roomMap.get(coordinate).getName());
        }else {
            System.out.println("room not found");
        }
    }
    private void goToSouth(){
        roomMap.get(userPosition);
        positionY += 1;
        coordinate = new Coordinate(positionY, userPosition.getX());
        if(roomMap.containsKey(coordinate)) {
            userPosition.setY(positionY);
            System.out.println("you are here:  " + roomMap.get(coordinate).getName());
        }else {
            System.out.println("room not found");
        }
    }

    private void goToWest(){
        roomMap.get(userPosition);
        positionX -= 1;
        coordinate = new Coordinate(userPosition.getY(), positionX);
        if(roomMap.containsKey(coordinate)) {
            userPosition.setX(positionX);
            System.out.println("you are here: " + roomMap.get(coordinate).getName());
        }else {
            System.out.println("room not found");
        }
    }


    public void changeRoom(int inputPosition ){
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
        }
    }





}
