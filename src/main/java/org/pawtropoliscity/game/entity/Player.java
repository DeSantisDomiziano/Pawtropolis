package org.pawtropoliscity.game.entity;

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
}
