package org.java.game.controller;

import org.java.game.entity.Coordinate;
import org.java.game.entity.Item;
import org.java.game.entity.Room;
import org.java.game.factory.RoomFactory;

import java.util.*;

public class MapController {

    public static Map<Coordinate, Room> roomMap = new HashMap<>();
    private static MapController instance = null;
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

        Item item1 = new Item("Torch", "is a torch", 3.0);
        Item item2 = new Item("Sword", "is a sword", 6.0);
        Item item3 = new Item("ball", "is a ball ", 1.2);
        Item item4 = new Item("collar", "is a collar", 5.0);
        Item item5 = new Item("helmet", "is an helmet", 5.0);
        Item item6 = new Item("poison", "is a poison", 20.0);



        List<Item> itemList = new ArrayList<>();
        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);
        itemList.add(item6);


        Room roomOfStart = RoomFactory.createRandomRoom("entrance room", itemList);
        Room room2 = RoomFactory.createRandomRoom("room 2", itemList);
        Room room3 = RoomFactory.createRandomRoom("room 3", itemList);
        Room room4 = RoomFactory.createRandomRoom("room 4", itemList);

        roomMap.put(coordinateOfStart, roomOfStart);
        roomMap.put(coordinate1, room2);
        roomMap.put(coordinate2, room3);
        roomMap.put(coordinate3, room4);
    }
}

