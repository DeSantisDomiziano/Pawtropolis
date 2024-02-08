package org.pawtropoliscity;
import org.pawtropoliscity.animals.entity.*;
import org.pawtropoliscity.game.controller.GameController;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Tiger t1 = new Tiger("Sid", "eagle", 3, LocalDate.now(), 100.75f, 130, 30);
        Tiger t2 = new Tiger("Gino", "pony", 5, LocalDate.now(), 150.3f, 140, 55);
        Tiger t3 = new Tiger("George", "cat", 3, LocalDate.now(), 154.5f, 144, 39);

        Lion l1 = new Lion("Alex", "zebra", 6, LocalDate.now(), 80.8f, 110, 40);
        Lion l2 = new Lion("Manny", "dog", 2, LocalDate.now(), 63.8f, 94, 32);
        Lion l3 = new Lion("Annawrella", "human", 4, LocalDate.now(), 87.8f, 122, 46);

        Eagle e1 = new Eagle("Spirit", "worm", 4, LocalDate.now(), 22.35f, 60, 62);
        Eagle e2 = new Eagle("Bomber", "balls", 2, LocalDate.now(), 20.3f, 54, 55);
        Eagle e3 = new Eagle("Fulvio", "other", 5, LocalDate.now(), 23.35f, 62, 59);

        Zoo zoo = Zoo.getInstance();


        zoo.addAnimal(t1);
        zoo.addAnimal(t2);
        zoo.addAnimal(t3);

        zoo.addAnimal(l1);
        zoo.addAnimal(l2);
        zoo.addAnimal(l3);

        zoo.addAnimal(e1);
        zoo.addAnimal(e2);
        zoo.addAnimal(e3);

        GameController gameController = GameController.getInstance();
        gameController.startGame();
    }
}