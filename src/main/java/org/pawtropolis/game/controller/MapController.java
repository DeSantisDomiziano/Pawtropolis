package org.pawtropolis.game.controller;
import org.pawtropolis.game.entity.Player;
import org.pawtropolis.game.entity.Room;
import org.pawtropolis.game.factory.ListAnimalFactory;
import org.pawtropolis.game.factory.ListItemFactory;

import java.util.*;

public class MapController {

    private static MapController instance = null;
    private final ListAnimalFactory listAnimalFactory = ListAnimalFactory.getInstance();
    private final ListItemFactory listItemFactory = ListItemFactory.getInstance();
    private Room currentRoom = new Room("Outer Courtyard", listItemFactory.getRandomItem(), listAnimalFactory.getRandomAnimal());


    private MapController(){

    }

    public static MapController getInstance() {
        if (instance == null) {
            instance = new MapController();
        }
        return instance;
    }

    private void printGameOver(){
        System.out.println("game over");}


    public void createGraph() {
        List<Room> rooms = new ArrayList<>();
        String[] roomNames = {"Entrance Room", "Bedroom", "Living Room", "Kitchen", "Bathroom",
                "Dining Room", "Study", "Guest Room", "Game Room", "Laundry Room", "Home Office"};

        for (String roomName : roomNames) {
            Room room = new Room(roomName, listItemFactory.getRandomItem(), listAnimalFactory.getRandomAnimal());
            rooms.add(room);
        }


        currentRoom.addAdjacentRoom(rooms.get(0));
        rooms.get(0).addAdjacentRoom(currentRoom);


        for (int i = 1; i < rooms.size(); i++) {
            Room nextRoom = rooms.get(i);
            Room previousRoom = rooms.get(i - 1);

            nextRoom.addAdjacentRoom(previousRoom);
            previousRoom.addAdjacentRoom(nextRoom);
        }
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Room getAdjacentRoom(String roomName){
        return currentRoom.getRoom(roomName);
    }

    public boolean containsAdjacentRoom(Room room){
        return currentRoom.containsRoom(room);
    }

    public void decrementLifePoints(Room room, Player player){
        if(room.getPoisonItem()!= null) {
            player.setLifePoints((player.getLifePoints() - Objects.requireNonNull(room.getPoisonItem()).getSlotsRequired()));
        }
    }


    public void handlePlayerGameOver(Player player){
        if (player.isDead()) {
            printGameOver();
            System.exit(0);
        }
    }


}

