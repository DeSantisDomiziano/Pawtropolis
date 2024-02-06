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

    public Room(String name, List<Item> listItem, List< Animal> listAnimal) {
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



    public void lookRoom(){
        System.out.println("You are here: " + roomMap.get(userPosition).getName() + "\n"
                + "\nItems: " + roomMap.get(userPosition).getListItem().toString()
                + "\nNPC: " + roomMap.get(userPosition).getListAnimal().toString() + "\n");
    }

    public void printItems(){
        if (!roomMap.get(userPosition).getListItem().isEmpty()){
            roomMap.get(userPosition).getListItem().stream()
                    .map(item -> roomMap.get(userPosition).getListItem().indexOf(item) + 1 + ") " + item.getName())
                    .forEach(System.out::println);
        }
    }

    public boolean isItems(){
        if (!roomMap.get(userPosition).getListItem().isEmpty()){
            return true;
        }else {
            System.out.println("Items not found\n");
            return false;
        }
    }

}