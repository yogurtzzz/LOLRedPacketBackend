package com.example.demo.data;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Player {

    private Long id;

    private String playerName;

    private Boolean enabled;

    public Player() {
    }

    public Player(Long id, String playerName) {
        this.id = id;
        this.playerName = playerName;
    }
}
