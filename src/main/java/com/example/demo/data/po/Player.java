package com.example.demo.data.po;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class Player {

    private Long id;

    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean enabled;

    public Player() {
    }

    public Player(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
