package org.pawtropoliscity.game.entity;

import org.pawtropoliscity.animals.abst.Animal;

import java.util.List;

import static org.pawtropoliscity.game.controller.MapController.roomMap;
import static org.pawtropoliscity.game.entity.Player.player;

public class Room {
    private String name;
    private final List<Item> itemList;

    private final List<Animal> animalList;

    public Room(String name, List<Item> itemList, List<Animal> animalList) {
        setName(name);
        this.itemList = itemList;
        this.animalList = animalList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addItem(Item item){
        itemList.add(item);
    }

    public void removeItem(Item item){
        itemList.remove(item);
    }

    public Item getItemFromRoom(String name){
        return itemList.stream()
                .filter(item -> item.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public boolean containsItemInRoom(Item item){
        return roomMap.get(player.getCoordinate()).itemList.contains(item);
    }

    public Item getPoisonItem() {
        Room room = roomMap.get(player.getCoordinate());
        List<Item> itemList = room.itemList;
        for (Item item : itemList) {
            if (item.getName().equalsIgnoreCase("poison")) {
                if (itemList.contains(item)) {
                    return item;
                }
            }
        }
        return null;
    }

    private List<String> getRoomItems(){
        return itemList.stream()
                .map(Item::getName)
                .toList();
    }

    private List<String> getRoomAnimals(){
        return animalList.stream()
                .map(animal -> animal.getName() + " (" + animal.getClass().getSimpleName() + ")")
                .toList();
    }

    public void printItems(){

        String result;

        if (!getRoomItems().isEmpty()) {
            result = "Items: " + String.join(", ", getRoomItems()) + ".";
        } else {
            result = "you don't have items";
        }

        System.out.println(result);
    }

    public void printAnimals(){
        String result;

        if (!getRoomAnimals().isEmpty()) {
            result = "NPC: " + String.join(", ", getRoomAnimals()) + ".";
        } else {
            result = "you don't have items";
        }

        System.out.println(result);
        System.out.println();
    }


}