package org.pawtropolis.animal.abst;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public abstract class Animal {
    private String name;

    @Getter(AccessLevel.NONE)
    private String favouriteFood;

    @Getter(AccessLevel.NONE)
    private int age;

    @Getter(AccessLevel.NONE)
    private LocalDate dateAddedToTheZoo;

    private float weight;
    private float height;
}