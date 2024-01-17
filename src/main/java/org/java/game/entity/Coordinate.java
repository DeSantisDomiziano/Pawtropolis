package org.java.game.entity;

import java.util.Objects;

public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int y, int x) {
        setX(x);
        setY(y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void plusY(){
        this.y = getY() + 1;
    }

    public void plusX(){
        this.x = getX() + 1;
    }

    public void minusX(){
        this.x = getX() - 1;
    }

    public void minusY(){
        this.y = getY() - 1;
    }


    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
