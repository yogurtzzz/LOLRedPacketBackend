package com.example.demo.data;

import com.example.demo.data.po.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDetail {
    /*
     * 玩家在一局对局中的详情, 包含了
     * 玩家, 以及对应的位置, 英雄, 评分
     * **/
    private Player player;

    // 位置
    private PositionEnum position;

    // 选用的英雄的名字
    private String legendName;

    // 评分
    private Double score;
}
