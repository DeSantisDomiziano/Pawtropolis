package org.pawtropoliscity.game.entity;

public enum Move {
    NORTH(-1, 0),
    SOUTH(1,0),
    WEST(0,-1),
    EAST(0,1);

    private int x;
    private int y;



    Move(int y, int x) {
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
