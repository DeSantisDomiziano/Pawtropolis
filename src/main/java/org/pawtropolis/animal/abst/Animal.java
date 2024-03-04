package org.pawtropolis.animal.abst;

import java.time.LocalDate;

public abstract class Animal {
    private String name;
    private String favouriteFood;
    private int age;
    private LocalDate dateAddedToTheZoo;
    private float weight;
    private float height;

    public Animal(String name, String favouriteFood, int age, LocalDate dateAddedToTheZoo, float weight, float height) {
        setName(name);
        setFavouriteFoodFood(favouriteFood);
        setAge(age);
        setDateAddedToTheZoo(dateAddedToTheZoo);
        setWeight(weight);
        setHeight(height);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavouriteFoodFood() {
        return favouriteFood;
    }

    public void setFavouriteFoodFood(String favouriteFood) {
        this.favouriteFood = favouriteFood;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDateAddedToTheZoo() {
        return dateAddedToTheZoo;
    }

    public void setDateAddedToTheZoo(LocalDate dateAddedToTheZoo) {
        this.dateAddedToTheZoo = dateAddedToTheZoo;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", getClass().getSimpleName(), getName());
        //return "name: " + getName() + " type: " + getClass().getSimpleName();
    }

}
