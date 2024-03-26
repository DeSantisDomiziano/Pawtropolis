package org.pawtropolis.game.factory;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.pawtropolis.animal.abst.Animal;
import org.pawtropolis.animal.controller.ZooController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ListAnimalFactory {
    private static ListAnimalFactory instance = null;
    private final List<Animal> animalList = ZooController.getAnimalsByClass(Animal.class);
    private final Random random = new Random();

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
