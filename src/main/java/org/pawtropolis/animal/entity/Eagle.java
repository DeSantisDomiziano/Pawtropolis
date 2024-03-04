package org.pawtropolis.animal.entity;

import org.pawtropolis.animal.abst.AnimalWithWings;

import java.time.LocalDate;

public class Eagle extends AnimalWithWings
{
    public Eagle(String name, String favouriteFood, int age, LocalDate dateAddedToTheZoo, float weight, float height, float wingsSpan) {
        super(name, favouriteFood, age, dateAddedToTheZoo, weight, height, wingsSpan);
    }
}
