package org.pawtropoliscity.game.controller;

import org.pawtropoliscity.game.entity.Coordinate;
import org.pawtropoliscity.game.entity.Room;
import org.pawtropoliscity.game.factory.RoomFactory;

import java.util.*;

public class MapController {

    public static Map<Coordinate, Room> roomMap = new HashMap<>();
    private static MapController instance = null;
    private RoomFactory roomFactory = RoomFactory.getInstance();

    private MapController(){

    }

    public static MapController getInstance() {
        if (instance == null) {
            instance = new MapController();
        }
        return instance;
    }
    public void createMap() {

        Coordinate coordinateOfStart = new Coordinate(0, 0);
        Coordinate coordinate1 = new Coordinate(0, 1);
        Coordinate coordinate2 = new Coordinate(1, 0);
        Coordinate coordinate3 = new Coordinate(1, 1);


        Room roomOfStart = roomFactory.createRandomRoom("entrance room");
        Room room2 = roomFactory.createRandomRoom("room 2");
        Room room3 = roomFactory.createRandomRoom("room 3");
        Room room4 = roomFactory.createRandomRoom("room 4");

        roomMap.put(coordinateOfStart, roomOfStart);
        roomMap.put(coordinate1, room2);
        roomMap.put(coordinate2, room3);
        roomMap.put(coordinate3, room4);
    }
}

