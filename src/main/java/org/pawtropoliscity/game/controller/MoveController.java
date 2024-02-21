package org.pawtropoliscity.game.controller;

import org.pawtropoliscity.game.entity.Coordinate;
import org.pawtropoliscity.game.entity.Direction;
import org.pawtropoliscity.game.entity.Room;
import java.util.HashMap;
import java.util.Map;

import static org.pawtropoliscity.game.controller.MapController.roomMap;
import static org.pawtropoliscity.game.entity.Player.player;

public class MoveController {

    private static MoveController instance = null;



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
    public void printCurrentLifeOfPoint(){
        System.out.println("your current life of point are : " + player.getLifePoints());
    }
    private void printGameOver(){
        System.out.println(" GAME OVER " );
    }

    private void commandNotFound(String input){
        System.out.println("Command not recognized: " + input);
    }

    public void currentLifePoints() {
        Room room = roomMap.get(player.getCoordinate());
        player.decrementLifePoints(room);
        printCurrentLifeOfPoint();

        if (player.isDead()){
            printGameOver();
            System.exit(0);
        }
    }

    private void printAdjacentRoom(int y, int x, String direction) {
        Coordinate adjacentCoordinate = new Coordinate(y, x);
        Room adjacentRoom = roomMap.get(adjacentCoordinate);
        if (adjacentRoom != null) {
            System.out.println(direction + ": " + adjacentRoom.getName());
        }
    }

    private final Map<String, Direction>  moveCommandMapper = new HashMap<>();;
    private MoveController(){

    }

    public static MoveController getInstance() {
        if( instance == null) {
            instance = new MoveController();
        }
        return instance;
    }

    private void executeCommand(String input) {
        Direction move = moveCommandMapper.get(input.toLowerCase().trim());

        if(move != null) {
            Runnable execute = () -> changeRoom(move);
            execute.run();
            currentLifePoints();
        } else  {
            commandNotFound(input);
        }
    }

    protected void moveCommand(String input){
        moveCommandMapper.put("go north", Direction.NORTH);
        moveCommandMapper.put("go south", Direction.SOUTH);
        moveCommandMapper.put("go east", Direction.EAST);
        moveCommandMapper.put("go west", Direction.WEST);
        moveCommandMapper.put("go north east", Direction.NORTH_EAST);
        moveCommandMapper.put("go north west", Direction.NORTH_WEST);
        moveCommandMapper.put("go south east", Direction.SOUTH_EAST);
        moveCommandMapper.put("go south west", Direction.SOUTH_WEST);

        executeCommand(input);
    }

    private void changeRoom(Direction direction) {
        Coordinate coordinate = new Coordinate(player.getCoordinate().getY() + direction.getY(),
                player.getCoordinate().getX() + direction.getX());

        if (roomMap.containsKey(coordinate)) {
            player.setCoordinate(coordinate);
            printCurrentRoomDescription();
        }else {
            printRoomNotFound();
        }
    }



}