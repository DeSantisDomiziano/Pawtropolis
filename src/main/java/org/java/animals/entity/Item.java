package org.java.animals.entity;

public class Item {

    private String name;
    private String description;
    private double slotsRequired;

    public Item(String name, String description, double slotsRequired) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSlotsRequired() {
        return slotsRequired;
    }

    public void setSlotsRequired(double slotsRequired) {
        this.slotsRequired = slotsRequired;
    }

    @Override
    public String toString() {
        return "name: " + getName();
    }
}
