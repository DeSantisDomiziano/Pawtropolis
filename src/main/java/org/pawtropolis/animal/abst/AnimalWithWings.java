package org.pawtropolis.animal.abst;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public abstract class AnimalWithWings extends Animal {

    private float wingsSpan;

    public AnimalWithWings(String name, String favouriteFood, int age, LocalDate dateAddedToTheZoo, float weight, float height, float wingsSpan) {
        super(name, favouriteFood, age, dateAddedToTheZoo, weight, height);
        setWingsSpan(wingsSpan);
    }



}