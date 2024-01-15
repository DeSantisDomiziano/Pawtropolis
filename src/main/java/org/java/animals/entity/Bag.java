package org.java.animals.entity;

import java.util.ArrayList;
import java.util.List;

public class Bag {

    private List<Item> items = new ArrayList<>();
    private double slotBag;

    public Bag(List<Item> items, double slotBag) {
        setItems(items);
        setSlotBag(slotBag);
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getSlotBag() {
        return slotBag;
    }

    private void setSlotBag(double slotBag) {
        this.slotBag = slotBag;
    }
}
