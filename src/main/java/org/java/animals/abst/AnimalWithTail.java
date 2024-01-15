package org.java.animals.abst;

import java.time.LocalDate;

public abstract class AnimalWithTail extends Animal{

    private float tailLength;

    public AnimalWithTail(String name, String favouriteFood, int age, LocalDate dateAddedToTheZoo, float weight, float height, float tailLength) {
        super(name, favouriteFood, age, dateAddedToTheZoo, weight, height);
        setTailLength(tailLength);
    }

    public float getTailLength() {
        return tailLength;
    }

    public void setTailLength(float tailLength) {
        this.tailLength = tailLength;
    }

    @Override
    public String toString() {
        return super.toString() + "cm, tailLength= " + getTailLength() + "cm}";
    }
}
