package org.pawtropoliscity.game.entity;
import java.util.ArrayList;
import java.util.List;


public class Bag {
    private final List<Item> itemList;
    private static final int MAX_SLOTS_CAPACITY = 20;

    private int slotsCapacity = MAX_SLOTS_CAPACITY;

    public Bag(List<Item> itemList){
        this.itemList = itemList;
    }

    public Bag(){
        this(new ArrayList<>());
    }

    public int getSlotsCapacity() {
        return slotsCapacity;
    }

    public void addItem(Item item){
        itemList.add(item);
    }

    public void removeItem(Item item){
        itemList.remove(item);
    }

    public Item getItemFromBag(String itemName){
        return itemList.stream()
                .filter(item -> item.getName().equalsIgnoreCase(itemName))
                .findFirst()
                .orElse(null);
    }

    private List<String> getBagsItems(){
        return itemList.stream()
                .map(Item::getName)
                .toList();
    }

    public boolean canFitInBag(Item item){
        return slotsCapacity >= item.getSlotsRequired();
    }

    public void decrementCurrentSlotsCapacity(Item item){
        slotsCapacity -= item.getSlotsRequired();
    }

    public void incrementCurrentSlotsCapacity(Item item){
        slotsCapacity += item.getSlotsRequired();
    }

    public boolean containsItemInBag(Item item){
        return itemList.contains(item);
    }

    public void printItems(){
        String result;

        if (!getBagsItems().isEmpty()) {
            result = "Items: " + String.join(", ", getBagsItems()) + ".";
        } else {
            result = "you don't have items";
        }

        System.out.println(result);
    }

}