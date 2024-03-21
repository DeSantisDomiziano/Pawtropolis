package org.pawtropolis.game.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Player {

    @Setter
    private String name;
    @Setter
    private int lifePoints;
    private final Bag bag;

    public Player() {
        this("", 100, new Bag());
    }

    public boolean isDead() {
        return getLifePoints() == 0;
    }

    public void printCurrentLifePoints() {
        System.out.printf("Life Points: %s%n%n", getLifePoints());
    }

}