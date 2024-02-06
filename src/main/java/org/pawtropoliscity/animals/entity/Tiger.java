package org.pawtropoliscity.animals.entity;

import org.pawtropoliscity.animals.abst.AnimalWithTail;

import java.time.LocalDate;

public class Tiger extends AnimalWithTail
{

    public Tiger(String name, String favouriteFood, int age, LocalDate dateAddedToTheZoo, float weight, float height, float tail) {
        super(name, favouriteFood, age, dateAddedToTheZoo, weight, height, tail);
    }
}
