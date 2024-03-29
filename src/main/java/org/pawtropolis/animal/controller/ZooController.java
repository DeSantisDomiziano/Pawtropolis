package org.pawtropolis.animal.controller;

import org.pawtropolis.animal.abst.Animal;
import org.pawtropolis.animal.abst.AnimalWithTail;
import org.pawtropolis.animal.abst.AnimalWithWings;

import java.util.*;
import java.util.stream.Collectors;

public class ZooController {

    private ZooController() {
        animals = new ArrayList<>();
    }

    private static class SingletonHelper {
        private static final ZooController INSTANCE = new ZooController();
    }

    List<Animal> animals;

    public static ZooController getInstance() {
        return SingletonHelper.INSTANCE;
    }
    //End Bill Pugh Singleton

    private static Map<Class<? extends Animal>, ArrayList<Animal>> allAnimals = new HashMap<>();

    public void addAnimal(Animal animal) {
        allAnimals.computeIfAbsent(animal.getClass(), k -> new ArrayList<>()).add(animal);
        animals.add(animal);
    }

    @SuppressWarnings("unchecked")
    public static <T extends Animal> List<T> getAnimalsByClass(Class<T> clazz) {
        if (allAnimals.get(clazz) != null) {
            return (ArrayList<T>) allAnimals.get(clazz);
        }
        return allAnimals.values()
                .stream()
                .flatMap(Collection::stream)
                .filter(clazz::isInstance)
                .map(clazz::cast)
                .collect(Collectors.toList());
    }

    public List<Animal> getAllAnimal() {
        return animals;
    }

    public <T extends Animal> T getHeaviestByClass(Class<T> clazz) {

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

    public <T extends Animal> T getShortestByClass(Class<T> clazz) {

        return getAnimalsByClass(clazz).stream()
                .map(clazz::cast)
                .min(Comparator.comparing(Animal::getHeight))
                .orElse(null);
    }


    public <T extends AnimalWithTail> T getLongestTailByClass(Class<T> clazz) {

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