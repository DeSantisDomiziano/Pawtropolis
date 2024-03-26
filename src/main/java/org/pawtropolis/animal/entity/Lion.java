package org.pawtropolis.animal.entity;

import org.pawtropolis.animal.abst.AnimalWithTail;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Lion extends AnimalWithTail
{
    public Lion(String name, String favouriteFood, int age, LocalDate dateAddedToTheZoo, float weight, float height, float tailLength) {
        super(name, favouriteFood, age, dateAddedToTheZoo, weight, height, tailLength);
    }
}
