package org.java.animals.entity;

import org.java.animals.abst.Animal;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private String name;
    private List<Item> listItem = new ArrayList<>();
    private List<? extends Animal> listAnimal = new ArrayList<>();
    private List<Room> listRoom = new ArrayList<>();

    public Room(){}
    public Room(String name){
        setName(name);
    }

    public Room(String name, List<Item> listItem, List<? extends Animal> listAnimal) {
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

    public List<? extends Animal> getListAnimal() {
        return listAnimal;
    }

    public void setListAnimal(List<? extends Animal> listAnimal) {
        this.listAnimal = listAnimal;
    }

    public List<Room> getListRoom() {
        return listRoom;
    }

    public void setListRoom(List<Room> listRoom) {
        this.listRoom = listRoom;
    }
}