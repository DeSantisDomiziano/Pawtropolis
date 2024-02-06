package org.pawtropoliscity.game.entity;

import org.pawtropoliscity.animals.abst.Animal;
import java.util.ArrayList;
import java.util.List;

import static org.pawtropoliscity.game.controller.MapController.roomMap;
import static org.pawtropoliscity.game.controller.MoveController.userPosition;

public class Room {

    private String name;
    private List<Item> listItem = new ArrayList<>();
    private List<Animal> listAnimal = new ArrayList<>();

    public Room(String name, List<Item> listItem, List<Animal> listAnimal) {
        setName(name);
        setListAnimal(listAnimal);
        this.listItem = listItem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Animal> getListAnimal() {
        return listAnimal;
    }

    public void setListAnimal(List<Animal> listAnimal) {
        this.listAnimal = listAnimal;
    }


    public void lookRoom() {
        System.out.println("You are here: " + roomMap.get(userPosition).getName() + "\n"
                + "\nItems: " + roomMap.get(userPosition).listItem.toString()
                + "\nNPC: " + roomMap.get(userPosition).getListAnimal().toString() + "\n");
    }

    public void printItems() {
        if (!roomMap.get(userPosition).listItem.isEmpty()) {
            roomMap.get(userPosition).listItem.stream()
                    .map(item -> roomMap.get(userPosition).listItem.indexOf(item) + 1 + ") " + item.getName())
                    .forEach(System.out::println);
        }
    }

    public boolean isItems() {
        roomMap.get(userPosition);
        if (!listItem.isEmpty()) {
            return true;
        } else {
            System.out.println("Items not found\n");
            return false;
        }
    }

    public void addItem(String itemName) {
        Item item = Bag.getItemFromBag(itemName);
        if (item != null) {
            roomMap.get(userPosition).listItem.add(item);
        } else {
            System.out.println("There are no items\n");
        }
    }


    public Item getItemFromRoom(String itemName) {
        return listItem.stream()
                .filter(item -> item.getName().equalsIgnoreCase(itemName))
                .findFirst()
                .orElse(null);
    }

    public void removeItem(String itemName) {
        Item item = roomMap.get(userPosition).getItemFromRoom(itemName);
        if (item != null) {
            roomMap.get(userPosition).listItem.remove(item);
        } else {
            System.out.println("Item not found");
        }

    }

    public static Item checkPoison() {
        Room room = roomMap.get(userPosition);
        List<Item> itemList = room.listItem;
        for (Item item : itemList) {
            if (item.getName().equalsIgnoreCase("poison")) {
                if (itemList.contains(item)) {
                    return item;
                }
            }
        }
        return null;
    }


}