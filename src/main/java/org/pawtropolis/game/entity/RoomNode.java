package org.pawtropolis.game.entity;

import java.util.ArrayList;
import java.util.List;

public class RoomNode {
    private final String name;
    private final List<RoomNode> adjacentRooms;

    public RoomNode(String name) {
        this.name = name;
        this.adjacentRooms = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<RoomNode> getAdjacentRooms() {
        return adjacentRooms;
    }

    public void addAdjacentRoom(RoomNode roomNode) {
        adjacentRooms.add(roomNode);
    }
}


