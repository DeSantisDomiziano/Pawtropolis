package org.pawtropolis.game.controller;
import org.pawtropolis.game.entity.Player;
import org.pawtropolis.game.entity.Room;
import org.pawtropolis.game.entity.RoomNode;
import org.pawtropolis.game.factory.ListAnimalFactory;
import org.pawtropolis.game.factory.ListItemFactory;

import java.util.*;

public class MapController {

    private final Map<RoomNode, Room> roomMap = new HashMap<>();
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


    public void createGraph(Player player) {


        Room room1 = new Room("kitchen", listItemFactory.getRandomItem(), listAnimalFactory.getRandomAnimal());
        Room room2 = new Room("salon", listItemFactory.getRandomItem(), listAnimalFactory.getRandomAnimal());
        Room room3 = new Room("bathroom", listItemFactory.getRandomItem(), listAnimalFactory.getRandomAnimal());
        Room room4 = new Room("bed", listItemFactory.getRandomItem(), listAnimalFactory.getRandomAnimal());

        RoomNode roomNode1 = new RoomNode(room1.getName());
        RoomNode roomNode2 = new RoomNode(room2.getName());
        RoomNode roomNode3 = new RoomNode(room3.getName());
        RoomNode roomNode4 = new RoomNode(room4.getName());

        roomMap.put(roomNode1, room1);
        roomMap.put(roomNode2, room2);
        roomMap.put(roomNode3, room3);
        roomMap.put(roomNode4, room4);

        roomNode1.addAdjacentRoom(roomNode2);
        roomNode1.addAdjacentRoom(roomNode3);
        roomNode2.addAdjacentRoom(roomNode1);
        roomNode2.addAdjacentRoom(roomNode4);
        roomNode3.addAdjacentRoom(roomNode1);
        roomNode3.addAdjacentRoom(roomNode4);
        roomNode4.addAdjacentRoom(roomNode2);
        roomNode4.addAdjacentRoom(roomNode3);
        player.setCurrentRoom(roomNode1);
    }


    public RoomNode getRoomNode(String roomName) {
        for (RoomNode node : roomMap.keySet()) {
            if (node.getName().equalsIgnoreCase(roomName)) {
                return node;
            }
        }
        return null;
    }

    public Room getRoom(RoomNode roomNode) {
        return roomMap.get(roomNode);
    }





}

