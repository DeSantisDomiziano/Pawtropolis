package org.java.animals.controller;

import org.java.animals.entity.Coordinate;
import org.java.animals.entity.Room;

import java.util.*;

public class MapController {
    Room room;

    public static Map<Coordinate, Room> roomMap = new HashMap<>();
    private static MapController instance = null;
    public static MapController getInstance() {
        if( instance == null) {
            instance = new MapController();
        }
        return instance;
    }

    public void createMap() {
        Coordinate coordinateOfStart = new Coordinate(0, 0);
        Coordinate coordinate1 = new Coordinate(0, 1);
        Coordinate coordinate2 = new Coordinate(1, 0);
        Coordinate coordinate3 = new Coordinate(1, 1);

        Room roomOfStart = new Room(" room of start");
        Room room2 = new Room("room 2");
        Room room3 = new Room("room 3");
        Room room4 = new Room("room 4");

        roomMap.put(coordinateOfStart, roomOfStart);
        roomMap.put(coordinate1, room2);
        roomMap.put(coordinate2, room3);
        roomMap.put(coordinate3, room4);
    }




}
