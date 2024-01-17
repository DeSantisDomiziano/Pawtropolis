package org.java.animals.controller;

import org.java.animals.entity.Bag;
import org.java.animals.entity.Item;
import org.java.animals.entity.Room;

import java.util.ArrayList;
import java.util.List;

import static org.java.animals.controller.MapController.roomMap;

import static org.java.animals.controller.MoveController.userPosition;

public class ActionController {
    private Bag bag = new Bag(new ArrayList<Item>(), 20.0);
    private Room room;

    private static ActionController instance = null;
    public static ActionController getInstance() {
        if( instance == null) {
            instance = new ActionController();
        }
        return instance;
    }

    private double getTotalWeightItem(){

        return bag.getItems().stream()
                .mapToDouble(Item::getSlotsRequired)
                .sum();
    }

    public void addItem(Item item){
        if (bag.getSlotBag() > getTotalWeightItem() + item.getSlotsRequired()){
            bag.getItems().add(item);
            roomMap.get(userPosition).getListItem().remove(item);
        }else {
            System.out.println("Not enough space");
        }
    }

    public void removeItem(Item item){

        if (bag.getItems().contains(item)){

            bag.getItems().remove(item);
            roomMap.get(userPosition).getListItem().add(item);

        }else {
            System.out.println("Item not found");
        }
    }

    public void lookRoom(){
        System.out.println("You are in " + roomMap.get(userPosition).getName()
                            + "\nItems: " + roomMap.get(userPosition).getListItem().toString()
                            + "\nNPC: " + roomMap.get(userPosition).getListAnimal().toString());
    }

    public Item getItemFromBag(int i){
        return bag.getItems().get(i);
    }

    public void lookBag(){

        if (bag.getItems().isEmpty()) {
            System.out.println("you don't have anything madaffakka");
        } else {
            System.out.print("bag: ");
            for (int i = 0; i < bag.getItems().size(); i++) {
                System.out.print(i + 1 + ")" +bag.getItems().get(i).getName() + " ");
            }
            System.out.println();
        }
    }

    public void lookItems(){

        for(int i = 0; i < roomMap.get(userPosition).getListItem().size() ; i++){

            System.out.println(i + 1 + ")"  + roomMap.get(userPosition).getListItem().get(i).getName());
        }
    }


}
