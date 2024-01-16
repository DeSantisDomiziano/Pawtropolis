package org.java.animals.abst;

import java.time.LocalDate;

public abstract class AnimalWithWings extends Animal{

    private float wingsSpan;

    public AnimalWithWings(String name, String favouriteFood, int age, LocalDate dateAddedToTheZoo, float weight, float height, float wingsSpan) {
        super(name, favouriteFood, age, dateAddedToTheZoo, weight, height);
        setWingsSpan(wingsSpan);
    }

    public float getWingsSpan() {
        return wingsSpan;
    }

    public void setWingsSpan(float wingsSpan) {
        this.wingsSpan = wingsSpan;
    }

    /*@Override
    public String toString() {
        return super.toString() + "cm, tailLength= " + getWingsSpan() + "cm}";
    }*/
}
