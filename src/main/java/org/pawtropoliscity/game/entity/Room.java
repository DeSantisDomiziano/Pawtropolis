package org.pawtropoliscity.game.entity;

import org.pawtropoliscity.animals.abst.Animal;
import java.util.ArrayList;
import java.util.List;

import static org.pawtropoliscity.game.controller.MapController.roomMap;
import static org.pawtropoliscity.game.controller.MoveController.userPosition;

public class Room {

    private String name;
    private static List<Item> listItem = new ArrayList<>();
    private List<Animal> listAnimal = new ArrayList<>();

    public Room(String name, List<Item> listItem, List< Animal> listAnimal) {
        setName(name);
        setListAnimal(listAnimal);
        Room.listItem = listItem;
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



    public void lookRoom(){
        System.out.println("You are here: " + roomMap.get(userPosition).getName() + "\n"
                + "\nItems: " + roomMap.get(userPosition).listItem.toString()
                + "\nNPC: " + roomMap.get(userPosition).getListAnimal().toString() + "\n");
    }

    public void printItems(){
        if (!roomMap.get(userPosition).listItem.isEmpty()){
            roomMap.get(userPosition).listItem.stream()
                    .map(item -> roomMap.get(userPosition).listItem.indexOf(item) + 1 + ") " + item.getName())
                    .forEach(System.out::println);
        }
    }

    public boolean isItems(){
        roomMap.get(userPosition);
        if (!Room.listItem.isEmpty()){
            return true;
        }else {
            System.out.println("Items not found\n");
            return false;
        }
    }

    public void addItem(String itemName){
        Item item = Bag.getItemFromBag(itemName);
        if (item != null){
                listItem.add(item);
            }else {
                System.out.println("There are no items\n");
            }
    }


    public static Item getItemFromRoom(String itemName){
        return listItem.stream()
                .filter(item -> item.getName().equalsIgnoreCase(itemName))
                .findFirst()
                .orElse(null);
    }

    public void removeItem(String itemName){
        Item item = getItemFromRoom(itemName);
        if (item != null){
            listItem.remove(item);
        }else {
            System.out.println("Item not found");
        }

    }


}