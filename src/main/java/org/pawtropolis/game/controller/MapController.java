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
    private Room currentRoom = new Room("kitchen", listItemFactory.getRandomItem(), listAnimalFactory.getRandomAnimal());


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


    private final String[] names = {"Entrance Room", "Bedroom", "Living Room", "Kitchen", "Bathroom",
            "Dining Room", "Study", "Guest Room", "Game Room", "Laundry Room", "Home Office"};

    public void createGraph() {
        currentRoom.setName("Room 1");
        List<Room> rooms = new ArrayList<>();

        for (String roomName : names) {
            Room room = new Room(roomName, listItemFactory.getRandomItem(), listAnimalFactory.getRandomAnimal());
            rooms.add(room);
        }


        if (!rooms.isEmpty()) {
            currentRoom.addAdjacentRoom(rooms.get(0));
            rooms.get(0).addAdjacentRoom(currentRoom);
            currentRoom.addAdjacentRoom(rooms.get(rooms.size() - 1));
            rooms.get(rooms.size() - 1).addAdjacentRoom(currentRoom);

            for (int i = 1; i < rooms.size(); i++) {
                Room nextRoom = rooms.get(i);
                Room previousRoom = rooms.get(i - 1);

                nextRoom.addAdjacentRoom(previousRoom);
                previousRoom.addAdjacentRoom(nextRoom);
            }
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

    public boolean isDead(Player player){
        return player.getLifePoints() == 0;
    }

    public void changeGameOver(Player player){
        if (isDead(player)) {
            printGameOver();
            System.exit(0);
        }
    }

    public void printCurrentLifePoints(Player player){
        System.out.printf("Life Points: %s%n%n", player.getLifePoints());
    }
}

