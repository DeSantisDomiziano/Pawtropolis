package org.pawtropoliscity.game.entity;
import org.pawtropoliscity.game.controller.CommandController;

import java.util.ArrayList;
import java.util.List;

import static org.pawtropoliscity.game.controller.MapController.roomMap;
import static org.pawtropoliscity.game.controller.MoveController.userPosition;

public class Bag {

    private static List<Item> items = new ArrayList<>();
    private double slotsCapacity;

    public Bag(double slotsCapacity){
        setSlotsCapacity(slotsCapacity);
    }
    public Bag(List<Item> items, double slotsCapacity) {
        Bag.items = items;
        setSlotsCapacity(slotsCapacity);
    }


    public double getSlotsCapacity() {
        return slotsCapacity;
    }

    private void setSlotsCapacity(double slotsCapacity) {
        this.slotsCapacity = slotsCapacity;
    }

    public double getTotalWeightItem(){
        return items.stream()
                .mapToDouble(Item::getSlotsRequired)
                .sum();
    }

    public boolean checkWeight(Item item){
        if (getSlotsCapacity() >= getTotalWeightItem() + item.getSlotsRequired()){
            return true;
        }else {
            CommandController.notSpace();
            return false;
        }
    }

    public void lookBag(){
        if (items.isEmpty()) {
            CommandController.notItem();
        } else {
            items.stream()
                    .map(item -> items.indexOf(item) + 1 + ") " + item.getName())
                    .forEach(System.out::println);
        }
    }

    public static Item getItemFromBag(String itemName){
        return items.stream()
                .filter(item -> item.getName().equalsIgnoreCase(itemName))
                .findFirst()
                .orElse(null);
    }

    public void addItem(String itemName){
        Item item = roomMap.get(userPosition).getItemFromRoom(itemName);
        if (item != null){
            if (checkWeight(item)){
                items.add(item);
            }else {
                CommandController.notItem();

            }
        }
    }

    public void removeItem(String itemName){
        Item item = getItemFromBag(itemName);
        if (item != null){
            items.remove(item);
        }else {
            CommandController.notItem();

        }
    }

    public void printItem(){
        if (!items.isEmpty()){
            items.stream()
                    .map(item -> items.indexOf(item) + 1 + ") " + item.getName())
                    .forEach(System.out::println);
        }
    }
}