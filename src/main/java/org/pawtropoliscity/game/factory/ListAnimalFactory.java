package org.pawtropoliscity.game.factory;


import org.pawtropoliscity.animals.abst.Animal;
import org.pawtropoliscity.animals.entity.Zoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListAnimalFactory {
    private static ListAnimalFactory instance = null;
    private final List<Animal> animalList = Zoo.getAnimalsByClass(Animal.class);
    private final Random random = new Random();

    private ListAnimalFactory() {
    }

    public static ListAnimalFactory getInstance() {
        if (instance == null) {
            instance = new ListAnimalFactory();
        }
        return instance;
    }

    public List<Animal> getRandomAnimalList() {
        int numIterator = random.nextInt(1, 6);
        List<Animal> randomAnimalList = new ArrayList<>();

        for (int i = 0; i < numIterator; i++) {
            int selectedIndex = random.nextInt(animalList.size());
            Animal animal = animalList.get(selectedIndex);

            if (!randomAnimalList.contains(animal)) {
                randomAnimalList.add(animal);
            } else {
                randomAnimalList.remove(animal);
                randomAnimalList.add(animal);
            }
        }
        return randomAnimalList;
    }
}
