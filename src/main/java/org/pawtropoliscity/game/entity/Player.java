package org.pawtropoliscity.game.entity;

import java.util.Objects;

public class Player {

    private String name;
    private int lifePoints;

    private Coordinate coordinate;

    public Player(String name, int lifePoints, Coordinate coordinate) {
        setName(name);
        setLifePoints(lifePoints);
        setCoordinate(coordinate);
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
    public Coordinate getCoordinate() {
        return coordinate;
    }
    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
    public static Player player = new Player("", 100, new Coordinate(0,0));

    public void decrementLifePoints(Room room){
        if(room.getPoisonItem()!= null) {
            player.setLifePoints((player.getLifePoints() - Objects.requireNonNull(room.getPoisonItem()).getSlotsRequired()));
        }
    }

    public boolean isDead(){
        return player.getLifePoints() == 0;
    }
}
