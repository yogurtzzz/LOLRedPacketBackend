package com.example.demo.data.vo;

import com.example.demo.data.PositionEnum;
import lombok.Data;

// 前端传来的
@Data
public class PlayerAndResultVO {

    private String playerName;

    // 位置
    private PositionEnum position;

    // 选用的英雄的名字
    private String legendName;

    // 本局的评分
    private Double score;

}
