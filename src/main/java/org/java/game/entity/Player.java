package org.java.game.entity;

public class Player {

    private String name;
    private int lifePoints;

    public Player(String name, int lifePoints) {
        setName(name);
        setLifePoints(lifePoints);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }
}
