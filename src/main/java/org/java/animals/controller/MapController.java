package org.java.animals.controller;

import org.java.animals.entity.*;

import java.time.LocalDate;
import java.util.*;

public class MapController {
    Room room;
    Zoo zoo = Zoo.getInstance();

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

        Item item1 = new Item("Torcia", "è una torcia", 3.0);
        Item item2 = new Item("Spada", "è una spada", 6.0);
        Item item3 = new Item("palla", "è una palla", 1.2);
        Item item4 = new Item("collare", "è una collare", 5.0);
        Item item5 = new Item("elmetto", "è una elmetto", 5.0);

        Tiger t1 = new Tiger("Sid", "eagle", 3, LocalDate.now(), 100.75f,130, 30);
        Tiger t2 = new Tiger("Gino", "pony", 5, LocalDate.now(), 150.3f,140, 55);
        Tiger t3 = new Tiger("George", "cat", 3, LocalDate.now(), 154.5f,144, 39);

        Lion l1 = new Lion("Alex", "zebra", 6, LocalDate.now(), 80.8f, 110,40);
        Lion l2 = new Lion("Manny", "dog", 2, LocalDate.now(), 63.8f, 94,32);
        Lion l3 = new Lion("Annarella", "human", 4, LocalDate.now(), 87.8f, 122,46);

        Eagle e1 = new Eagle("Spirit", "worm", 4, LocalDate.now(), 22.35f, 60, 62);
        Eagle e2 = new Eagle("Bomber", "balls", 2, LocalDate.now(), 20.3f, 54, 55);
        Eagle e3 = new Eagle("Fulvio", "other", 5, LocalDate.now(), 23.35f, 62, 59);

        List<Item> itemList = new ArrayList<>();
        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);
        List<Item> itemList1 = new ArrayList<>(itemList);
        List<Item> itemList2 = new ArrayList<>(itemList);
        List<Item> itemList3 = new ArrayList<>(itemList);



        zoo.addAnimal(t1);
        zoo.addAnimal(t2);
        zoo.addAnimal(t3);

        zoo.addAnimal(l1);
        zoo.addAnimal(l2);
        zoo.addAnimal(l3);

        zoo.addAnimal(e1);
        zoo.addAnimal(e2);
        zoo.addAnimal(e3);

        Room roomOfStart = new Room(" room of start", itemList, zoo.getAnimalsByClass(Lion.class));
        Room room2 = new Room("room 2", itemList1, zoo.getAnimalsByClass(Eagle.class));
        Room room3 = new Room("room 3", itemList2, zoo.getAnimalsByClass(Tiger.class));
        Room room4 = new Room("room 4", itemList3, zoo.getAnimalsByClass(Lion.class));

        roomMap.put(coordinateOfStart, roomOfStart);
        roomMap.put(coordinate1, room2);
        roomMap.put(coordinate2, room3);
        roomMap.put(coordinate3, room4);
    }






}
