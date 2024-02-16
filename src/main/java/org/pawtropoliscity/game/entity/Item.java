package org.pawtropoliscity.game.entity;

public class Item {
    private String name;
    private String description;
    private int slotsRequired;
    public Item(String name, String description, int slotsRequired) {
        setName(name);
        setDescription(description);
        setSlotsRequired(slotsRequired);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @SuppressWarnings("unused")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSlotsRequired() {
        return slotsRequired;
    }

    public void setSlotsRequired(int slotsRequired) {
        this.slotsRequired = slotsRequired;
    }

    @Override
    public String toString() {
        return "name: " + getName();
    }
}