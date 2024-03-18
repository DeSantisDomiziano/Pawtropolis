package org.pawtropolis.game.entity;

public class Player {

    private String name;
    private int lifePoints;

    private final Bag bag;


    public Player(String name, int lifePoints, Bag bag) {
        setName(name);
        setLifePoints(lifePoints);
        this.bag = bag;
    }

    public Bag getBag() {
        return bag;
    }

    public Player(){
        this("", 100, new Bag());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public boolean isDead(){
        return getLifePoints() == 0;
    }

    public void printCurrentLifePoints(){
        System.out.printf("Life Points: %s%n%n", getLifePoints());
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }
}
