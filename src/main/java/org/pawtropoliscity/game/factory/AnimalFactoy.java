package org.pawtropoliscity.game.factory;

import org.pawtropoliscity.animals.abst.Animal;
import org.pawtropoliscity.animals.entity.Zoo;
import org.pawtropoliscity.game.entity.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AnimalFactoy {

    private static AnimalFactoy instance = null;

    private AnimalFactoy(){}

    public static AnimalFactoy getInstance() {
        if( instance == null) {
            instance = new AnimalFactoy();
        }
        return instance;
    }

    private final Random random = new Random();

    public List<Animal> createRandomAnimalList(){
        int numIterator = random.nextInt(1, 6);
        List<Animal> randomAnimalList = new ArrayList<>();

        for (int i = 0; i < numIterator; i++){
            List<Animal> animalList = Zoo.getAnimalsByClass(Animal.class);
            int selectedIndex = random.nextInt(animalList.size());
            Animal animal = animalList.get(selectedIndex);
            randomAnimalList.add(animal);
        }
        return randomAnimalList;
    }
}
