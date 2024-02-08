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
        this.name = name;
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

    public void printItemList(){
        System.out.printf("Item: %s%n", itemList);
    }

    public void printAnimalList(){
        System.out.printf("NPC: %s%n", animalList);
    }

    public boolean checkEmptyListItem(){
        return !roomMap.get(player.getCoordinate()).itemList.isEmpty();
    }

    public boolean checkItemInRoom(Item item){
        return roomMap.get(player.getCoordinate()).itemList.contains(item);
    }

    public Item checkPoison() {
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


}