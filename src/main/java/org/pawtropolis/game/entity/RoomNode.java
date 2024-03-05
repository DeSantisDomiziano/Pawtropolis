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

    public RoomNode(){
        this("");
    }

    public String getName() {
        return name;
    }

    private List<RoomNode> getAdjacentRooms() {
        return adjacentRooms;
    }

    public void addAdjacentRoom(RoomNode roomNode) {
        adjacentRooms.add(roomNode);
    }

    public void printAdjacentRoom(Player player){
        RoomNode currentRoomNode = player.getCurrentRoom();
        List<RoomNode> adjacentRooms = currentRoomNode.getAdjacentRooms();
        System.out.println("Adjacent Rooms:");
        for (RoomNode adjacentRoomNode : adjacentRooms) {
            if (adjacentRoomNode != null) {
                System.out.println(adjacentRoomNode.getName());
            }
        }
    }
}


