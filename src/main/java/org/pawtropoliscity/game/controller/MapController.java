package org.pawtropoliscity.game.controller;

import org.pawtropoliscity.game.entity.Coordinate;
import org.pawtropoliscity.game.entity.Room;
import org.pawtropoliscity.game.factory.ListAnimalFactory;
import org.pawtropoliscity.game.factory.ListItemFactory;

import java.util.*;

public class MapController {

    public static Map<Coordinate, Room> roomMap = new HashMap<>();
    private static MapController instance = null;
    private final ListAnimalFactory listAnimalFactory = ListAnimalFactory.getInstance();
    private final ListItemFactory listItemFactory = ListItemFactory.getInstance();


    private MapController(){

    }

    public static MapController getInstance() {
        if (instance == null) {
            instance = new MapController();
        }
        return instance;
    }
    public void createRoom(){
        Coordinate coordinate1 = new Coordinate(0, 0);
        Coordinate coordinate2 = new Coordinate(1, 0);
        Coordinate coordinate3 = new Coordinate(0, 1);
        Coordinate coordinate4 = new Coordinate(1, 1);

        Room room1 = new Room("Room 1", listItemFactory.getRandomItemList(), listAnimalFactory.getRandomAnimalList());
        Room room2 = new Room("Room 2", listItemFactory.getRandomItemList(), listAnimalFactory.getRandomAnimalList());
        Room room3 = new Room("Room 3", listItemFactory.getRandomItemList(), listAnimalFactory.getRandomAnimalList());
        Room room4 = new Room("Room 4", listItemFactory.getRandomItemList(), listAnimalFactory.getRandomAnimalList());

        roomMap.put(coordinate1, room1);
        roomMap.put(coordinate2, room2);
        roomMap.put(coordinate3, room3);
        roomMap.put(coordinate4, room4);
    }
}

