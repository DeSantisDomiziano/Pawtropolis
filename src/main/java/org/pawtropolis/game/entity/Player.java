package org.pawtropolis.game.entity;

public class Player {

    private String name;
    private int lifePoints;


    public Player(String name, int lifePoints) {
        setName(name);
        setLifePoints(lifePoints);
    }

    public Player(){
        this("", 100 );
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
