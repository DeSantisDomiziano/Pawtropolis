package org.pawtropolis.game.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@AllArgsConstructor
@ToString
public class Item {

    @Getter
    private String name;
    private String description;
    @Getter
    private int slotsRequired;


    @SuppressWarnings("unused")
    public String getDescription() {
        return description;
    }
}