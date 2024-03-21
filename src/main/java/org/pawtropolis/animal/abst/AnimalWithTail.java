package org.pawtropolis.animal.abst;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public abstract class AnimalWithTail extends Animal {

    private float tailLength;

    public AnimalWithTail(String name, String favouriteFood, int age, LocalDate dateAddedToTheZoo, float weight, float height, float tailLength) {
        super(name, favouriteFood, age, dateAddedToTheZoo, weight, height);
        setTailLength(tailLength);
    }
}