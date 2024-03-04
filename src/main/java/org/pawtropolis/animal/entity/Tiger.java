package org.pawtropolis.animal.entity;

import org.pawtropolis.animal.abst.AnimalWithTail;

import java.time.LocalDate;

public class Tiger extends AnimalWithTail
{

    public Tiger(String name, String favouriteFood, int age, LocalDate dateAddedToTheZoo, float weight, float height, float tail) {
        super(name, favouriteFood, age, dateAddedToTheZoo, weight, height, tail);
    }
}
