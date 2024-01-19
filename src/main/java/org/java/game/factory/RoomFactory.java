package org.java.game.factory;

import org.java.animals.abst.Animal;
import org.java.game.entity.Item;
import org.java.game.entity.Room;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoomFactory {
    public static Room createRandomRoom(String name, List<Item> items, List<Animal> animals) {
        List<Item> itemsCopy = new ArrayList<>(items);
        List<Animal> animalsCopy = new ArrayList<>(animals);
        Room room = new Room(name, new ArrayList<>(), new ArrayList<>());
        addRandomItems(room, itemsCopy);
        addRandomAnimals(room, animalsCopy);
        return room;
    }
    private static void addRandomItems(Room room, List<Item> items) {
        int maxItemsToAdd = Math.min(4, items.size());
        int numItemsToAdd = (maxItemsToAdd > 0) ? (int) (Math.random() * maxItemsToAdd) + 1 : 0;
        if (numItemsToAdd > 0) {
            Collections.shuffle(items);
            List<Item> randomItems = items.subList(0, numItemsToAdd);
            room.getListItem().addAll(randomItems);
        }
    }

    private static void addRandomAnimals(Room room, List<Animal> animals) {
        int maxAnimalsToAdd = Math.min(4, animals.size());
        int numAnimalsToAdd = (maxAnimalsToAdd > 0) ? (int) (Math.random() * maxAnimalsToAdd) + 1 : 0;

        if (numAnimalsToAdd > 0) {
            Collections.shuffle(animals);
            List<Animal> randomAnimals = animals.subList(0, numAnimalsToAdd);
            room.getListAnimal().addAll(randomAnimals);
        }
    }

}