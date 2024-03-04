package org.pawtropolis.game.controller;

import org.pawtropolis.game.entity.Coordinate;
import org.pawtropolis.game.entity.Room;
import org.pawtropolis.game.factory.ListAnimalFactory;
import org.pawtropolis.game.factory.ListItemFactory;

import java.util.*;

public class MapController {

    private final Map<Coordinate, Room> roomMap = new HashMap<>();
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

        Room room1 = new Room("Room 1", listItemFactory.getRandomItem(), listAnimalFactory.getRandomAnimal());
        Room room2 = new Room("Room 2", listItemFactory.getRandomItem(), listAnimalFactory.getRandomAnimal());
        Room room3 = new Room("Room 3", listItemFactory.getRandomItem(), listAnimalFactory.getRandomAnimal());
        Room room4 = new Room("Room 4", listItemFactory.getRandomItem(), listAnimalFactory.getRandomAnimal());

        roomMap.put(coordinate1, room1);
        roomMap.put(coordinate2, room2);
        roomMap.put(coordinate3, room3);
        roomMap.put(coordinate4, room4);
    }

    public boolean containsCoordinate(Coordinate coordinate){
        return roomMap.containsKey(coordinate);
    }

    public Room getRoom(Coordinate coordinate){
        return roomMap.get(coordinate);
    }
}

