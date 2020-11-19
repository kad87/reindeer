package com.reindeer.reindeerolympics.models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ReindeerModel{

    private String name;
    private Integer speed;
    private Integer flightDuration;
    private Integer restDuration;

    public ReindeerModel(String name, Integer speed, Integer flightDuration, Integer restDuration) {
        this.name = name;
        this.speed = speed;
        this.flightDuration = flightDuration;
        this.restDuration = restDuration;
    }
}
