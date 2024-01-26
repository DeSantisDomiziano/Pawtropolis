package org.java.game.entity;

import org.java.animals.abst.Animal;
import java.util.ArrayList;
import java.util.List;

public class Room {

    private String name;
    private List<Item> listItem = new ArrayList<>();
    private List<Animal> listAnimal = new ArrayList<>();

    public Room(String name, List<Item> listItem, List< Animal> listAnimal) {
        setName(name);
        setListAnimal(listAnimal);
        setListItem(listItem);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getListItem() {
        return listItem;
    }

    public void setListItem(List<Item> listItem) {
        this.listItem = listItem;
    }

    public List<Animal> getListAnimal() {
        return listAnimal;
    }
    public void setListAnimal(List<Animal> listAnimal) {
        this.listAnimal = listAnimal;
    }


}
