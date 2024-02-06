package org.pawtropoliscity.game.factory;

import org.pawtropoliscity.game.entity.Room;

public class RoomFactory {

    private static RoomFactory instance = null;
    private final ItemFactory itemFactory = ItemFactory.getInstance();
    private final AnimalFactoy animalFactoy = AnimalFactoy.getInstance();

    private RoomFactory(){}

    public static RoomFactory getInstance() {
        if( instance == null) {
            instance = new RoomFactory();
        }
        return instance;
    }

    public Room createRandomRoom(String name){
        return new Room(name, itemFactory.createRandomItemList(), animalFactoy.createRandomAnimalList());

    }
}