package org.pawtropolis.game.entity;

import lombok.Getter;
import lombok.Setter;
import org.pawtropolis.animal.abst.Animal;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Room {
    @Getter
    @Setter
    private String name;
    private final List<Item> itemList;

    private final List<Animal> animalList;
    private final List<Room> adjacentRooms;


    public Room(String name, List<Item> itemList, List<Animal> animalList) {
        setName(name);
        this.itemList = itemList;
        this.animalList = animalList;
        this.adjacentRooms = new ArrayList<>();
    }

    public void addItem(Item item) {
        itemList.add(item);
    }

    public void removeItem(Item item) {
        itemList.remove(item);
    }

    public Item getItemFromRoom(String name) {
        return itemList.stream()
                .filter(item -> item.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public boolean containsItemInRoom(Item item) {
        return itemList.contains(item);
    }

    public Item getPoisonItem() {
        for (Item item : itemList) {
            if (item.getName().equalsIgnoreCase("poison")) {
                if (itemList.contains(item)) {
                    return item;
                }
            }
        }
        return null;
    }

    private List<String> getRoomItems() {
        return itemList.stream()
                .map(Item::getName)
                .toList();
    }

    private List<String> getRoomAnimals() {
        return animalList.stream()
                .map(animal -> animal.getName() + " (" + animal.getClass().getSimpleName() + ")")
                .toList();
    }

    public void printItems() {

        String result;

        if (!getRoomItems().isEmpty()) {
            result = "Items: " + String.join(", ", getRoomItems()) + ".";
        } else {
            result = "you don't have items";
        }

        System.out.println(result);
    }

    public void printAnimals() {
        String result;

        if (!getRoomAnimals().isEmpty()) {
            result = "NPC: " + String.join(", ", getRoomAnimals()) + ".";
        } else {
            result = "you don't have items";
        }

        System.out.println(result);
        System.out.println();
    }

    public void addAdjacentRoom(Room room) {
        adjacentRooms.add(room);
    }

    public void printAdjacentRoom() {
        System.out.println("Adjacent Rooms:");
        adjacentRooms.stream()
                .map(Room::getName)
                .forEach(System.out::println);
        System.out.println();
    }

    public Room getRoom(String roomName) {
        return adjacentRooms.stream()
                .filter(room -> room.getName().equalsIgnoreCase(roomName))
                .findFirst()
                .orElse(null);
    }

    public boolean containsRoom(Room room) {
        return adjacentRooms.contains(room);
    }



}