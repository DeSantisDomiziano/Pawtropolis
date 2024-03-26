package org.pawtropolis.game.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@ToString
@Component
public class Item {

    @Getter
    @Setter
    private String name;
    private String description;
    @Setter
    @Getter
    private int slotsRequired;

}