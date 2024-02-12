package org.pawtropoliscity.game.entity;
import java.util.ArrayList;
import java.util.List;


public class Bag {
    private final List<Item> itemList;
    private int slotsCapacity;

    public Bag(List<Item> itemList, int slotsCapacity) {
        this.itemList = itemList;
        setSlotsCapacity(slotsCapacity);
    }

    public Bag(int slotsCapacity){
        this(new ArrayList<>(), slotsCapacity);
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

    public double getSlotsCapacityRemain(){
        return itemList.stream()
                .mapToDouble(Item::getSlotsRequired)
                .sum();
    }

    public List<String> getBagsItems(){
        return itemList.stream()
                .map(Item::getName)
                .toList();
    }

    public boolean checkSlotsCapacity(Item item){
        return getSlotsCapacity() >= getSlotsCapacityRemain() + item.getSlotsRequired();
    }

    public boolean checkItemInBag(Item item){
        return itemList.contains(item);
    }

    public boolean checkEmptyListItem(){
        return !itemList.isEmpty();
    }

}