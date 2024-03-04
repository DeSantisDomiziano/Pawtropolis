package org.pawtropolis.game.factory;


import org.pawtropolis.animal.abst.Animal;
import org.pawtropolis.animal.entity.Zoo;

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

    public List<Animal> getRandomAnimal() {
        int numIterator = random.nextInt(1, 6);
        List<Animal> randomAnimal = new ArrayList<>();

        for (int i = 0; i < numIterator; i++) {
            int selectedIndex = random.nextInt(animalList.size());
            Animal animal = animalList.get(selectedIndex);

            if (!randomAnimal.contains(animal)) {
                randomAnimal.add(animal);
            }
        }
        return randomAnimal;
    }
}
