package org.pawtropolis.game.entity;

public enum Direction {
    NORTH(-1, 0),
    SOUTH(1,0),
    WEST(0,-1),
    EAST(0,1),
    SOUTH_EAST(1,1),
    SOUTH_WEST(1,-1),
    NORTH_EAST(-1,1),
    NORTH_WEST(-1,-1);

    private final int x;
    private final int y;

    Direction(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
