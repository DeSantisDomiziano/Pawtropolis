package org.pawtropolis.game.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Data
public class Player {

    private String name;
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