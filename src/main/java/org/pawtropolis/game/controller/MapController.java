package org.pawtropolis.game.controller;
import org.pawtropolis.game.entity.Player;
import org.pawtropolis.game.entity.Room;
import org.pawtropolis.game.factory.ListAnimalFactory;
import org.pawtropolis.game.factory.ListItemFactory;

public class MapController {

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


        room1.addAdjacentRoom(room2);
        room1.addAdjacentRoom(room3);
        room2.addAdjacentRoom(room1);
        room2.addAdjacentRoom(room4);
        room3.addAdjacentRoom(room1);
        room3.addAdjacentRoom(room4);
        room4.addAdjacentRoom(room2);
        room4.addAdjacentRoom(room3);
        player.setCurrentRoom(room1);

    }







}

