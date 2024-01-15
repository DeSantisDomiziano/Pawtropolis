package org.java.animals.entity;

import org.java.animals.abst.AnimalWithTail;

import java.time.LocalDate;

public class Tiger extends AnimalWithTail
{

    public Tiger(String name, String favouriteFood, int age, LocalDate dateAddedToTheZoo, float weight, float height, float tail) {
        super(name, favouriteFood, age, dateAddedToTheZoo, weight, height, tail);
    }
}
