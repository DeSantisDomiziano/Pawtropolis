package org.java.animals.controller;

import org.java.animals.entity.Bag;
import org.java.animals.entity.Item;
import org.java.animals.entity.Room;

import static org.java.animals.controller.MapController.roomMap;

import static org.java.animals.controller.MoveController.userPosition;

public class ActionController {
    private Bag bag;
    private Room room;

    private static ActionController instance = null;
    public static ActionController getInstance() {
        if( instance == null) {
            instance = new ActionController();
        }
        return instance;
    }

    private double getTotalWeightItem(){
        double totalWeight = 0;

        for (Item item : bag.getItems()){
            totalWeight += item.getSlotsRequired();
        }
        return totalWeight;

        /*return bag.getItems().stream()
                .mapToDouble(Item::getSlotsRequired)
                .sum();*/
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







}
