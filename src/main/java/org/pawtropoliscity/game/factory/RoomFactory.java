package org.pawtropoliscity.game.factory;

import org.pawtropoliscity.animals.abst.Animal;
import org.pawtropoliscity.animals.entity.Zoo;
import org.pawtropoliscity.game.controller.GameController;
import org.pawtropoliscity.game.entity.Item;
import org.pawtropoliscity.game.entity.Room;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RoomFactory {

    private static RoomFactory instance = null;
    private ItemFactory itemFactory = ItemFactory.getInstance();
    private AnimalFactoy animalFactoy = AnimalFactoy.getInstance();

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