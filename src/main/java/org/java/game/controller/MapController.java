package org.java.game.controller;

import org.java.animals.entity.Zoo;
import org.java.game.entity.Coordinate;
import org.java.game.entity.Item;
import org.java.game.entity.Room;
import org.java.game.factory.RoomFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapController {

    Zoo zoo = Zoo.getInstance();
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

        List<Item> itemList = new ArrayList<>();
        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);

        Room roomOfStart = RoomFactory.createRandomRoom("room of start", itemList, zoo.getAllAnimal());
        Room room2 = RoomFactory.createRandomRoom("room 2", itemList, zoo.getAllAnimal());
        Room room3 = RoomFactory.createRandomRoom("room 3", itemList, zoo.getAllAnimal());
        Room room4 = RoomFactory.createRandomRoom("room 4", itemList, zoo.getAllAnimal());

        roomMap.put(coordinateOfStart, roomOfStart);
        roomMap.put(coordinate1, room2);
        roomMap.put(coordinate2, room3);
        roomMap.put(coordinate3, room4);
    }

}

