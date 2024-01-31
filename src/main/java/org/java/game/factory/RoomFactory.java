package org.java.game.factory;

import org.java.animals.abst.Animal;
import org.java.animals.entity.Zoo;
import org.java.game.entity.Item;
import org.java.game.entity.Room;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RoomFactory {
    private static final Random random = new Random();
    private static final Zoo zoo = Zoo.getInstance();

    private static void addRandomItem(Room room, List<Item> itemList){
        int numItems = random.nextInt(1,5);
        for (int i = 0; i < numItems;  i++){
            room.getListItem().add(itemList.get(random.nextInt(itemList.size())));
        }
    }

    private static void addRandomAnimal(Room room){
        int numAnimal = random.nextInt(1,5);
        for (int i =  0; i < numAnimal; i++){
            room.getListAnimal().add(zoo.getAnimalsByClass(Animal.class).get(random.nextInt(zoo.getAnimalsByClass(Animal.class).size())));
        }
    }

    public static Room createRandomRoom(String name, List<Item> itemList){
        Room room = new Room(name, new ArrayList<>(), new ArrayList<>());
        addRandomItem(room, itemList);
        addRandomAnimal(room);

        return room;
    }

}