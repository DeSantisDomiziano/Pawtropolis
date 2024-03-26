package org.pawtropolis.animal.entity;

import lombok.ToString;
import org.pawtropolis.animal.abst.AnimalWithWings;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@ToString
public class Eagle extends AnimalWithWings
{

    public Eagle( String name, String favouriteFood, int age, LocalDate dateAddedToTheZoo, float weight, float height, float wingsSpan) {
        super(name, favouriteFood, age, dateAddedToTheZoo, weight, height, wingsSpan);
    }

}
