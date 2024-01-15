package org.java.animals.entity;

import org.java.animals.abst.AnimalWithTail;

import java.time.LocalDate;

public class Lion extends AnimalWithTail
{
    public Lion(String name, String favouriteFood, int age, LocalDate dateAddedToTheZoo, float weight, float height, float tailLength) {
        super(name, favouriteFood, age, dateAddedToTheZoo, weight, height, tailLength);
    }
}
