package org.java.animals.entity;

import org.java.animals.abst.Animal;
import org.java.animals.abst.AnimalWithTail;
import org.java.animals.abst.AnimalWithWings;

import java.util.*;

public class Zoo {

    //Start Bill Pugh Singleton
    private Zoo(){}

    private static class SingletonHelper {
        private static final Zoo INSTANCE = new Zoo();
    }

    public static Zoo getInstance() {
        return  SingletonHelper.INSTANCE;
    }
    //End Bill Pugh Singleton

    private Map<Class<? extends Animal>, ArrayList<Animal>> allAnimals = new HashMap<>();

    public void addAnimal(Animal animal) {
        allAnimals.computeIfAbsent(animal.getClass(), k -> new ArrayList<>()).add(animal);
    }

    public <T extends Animal> ArrayList<T> getAnimalsByClass(Class<T> clazz){
        return (ArrayList<T>) allAnimals.get(clazz);
    }

    public <T extends Animal> T getHeaviestByClass(Class<T> clazz){

        return getAnimalsByClass(clazz).stream()
                .map(clazz::cast)
                .max(Comparator.comparing(Animal::getWeight))
                .orElse(null);

    }

    public <T extends Animal> T getLightestByClass(Class<T> clazz) {

        return getAnimalsByClass(clazz).stream()
                .map(clazz::cast)
                .min(Comparator.comparing(Animal::getWeight))
                .orElse(null);
    }

    public <T extends Animal> T getTallestByClass(Class<T> clazz) {

        return getAnimalsByClass(clazz).stream()
                .map(clazz::cast)
                .max(Comparator.comparing(Animal::getHeight))
                .orElse(null);
    }

    public  <T extends Animal> T getShortestByClass(Class<T> clazz) {

        return getAnimalsByClass(clazz).stream()
                .map(clazz::cast)
                .min(Comparator.comparing(Animal::getHeight))
                .orElse(null);
    }


    public <T extends AnimalWithTail> T getLongestTailByClass(Class<T> clazz){

        return getAnimalsByClass(clazz).stream()
                .filter(Objects::nonNull)
                .map(clazz::cast)
                .max(Comparator.comparing(AnimalWithTail::getTailLength))
                .orElse(null);
    }

    public <T extends AnimalWithWings> T getLongestWingsSpan(Class<T> clazz) {

        return getAnimalsByClass(clazz).stream()
                .filter(Objects::nonNull)
                .map(clazz::cast)
                .max(Comparator.comparing(AnimalWithWings::getWingsSpan))
                .orElse(null);
    }
}