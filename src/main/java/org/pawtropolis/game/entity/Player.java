package org.pawtropolis.game.entity;

import java.util.Objects;

public class Player {

    private String name;
    private int lifePoints;

    private Room currentRoom;

    public Player(String name, int lifePoints, Room currentRoom) {
        setName(name);
        setLifePoints(lifePoints);
        setCurrentRoom(currentRoom);
    }

    public Player(){
        this("", 100,null  ); // Modifica
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

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void decrementLifePoints(Room room){
        if(room.getPoisonItem()!= null) {
            this.setLifePoints((this.getLifePoints() - Objects.requireNonNull(room.getPoisonItem()).getSlotsRequired()));
        }
    }
    public boolean isDead(){
        return this.getLifePoints() == 0;
    }
}
