package org.pawtropolis.game.controller;
import org.pawtropolis.game.entity.Player;
import org.pawtropolis.game.entity.Room;
import org.pawtropolis.game.factory.ListAnimalFactory;
import org.pawtropolis.game.factory.ListItemFactory;

import java.util.Objects;

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


    public void createGraph() {


        Room room2 = new Room("salon", listItemFactory.getRandomItem(), listAnimalFactory.getRandomAnimal());
        Room room3 = new Room("bathroom", listItemFactory.getRandomItem(), listAnimalFactory.getRandomAnimal());
        Room room4 = new Room("bed", listItemFactory.getRandomItem(), listAnimalFactory.getRandomAnimal());
        Room room5 = new Room("evil corp alten", listItemFactory.getRandomItem(), listAnimalFactory.getRandomAnimal());


        currentRoom.addAdjacentRoom(room2);
        currentRoom.addAdjacentRoom(room3);
        currentRoom.addAdjacentRoom(room5);
        room2.addAdjacentRoom(currentRoom);
        room2.addAdjacentRoom(room4);
        room3.addAdjacentRoom(currentRoom);
        room3.addAdjacentRoom(room4);
        room4.addAdjacentRoom(room2);
        room4.addAdjacentRoom(room3);
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

