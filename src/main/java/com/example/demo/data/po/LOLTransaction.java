package com.example.demo.data.po;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.example.demo.data.Player;
import lombok.Data;


// 一局对局中产生的一笔交易明细
@Data
public class LOLTransaction {

    @TableField(typeHandler = JacksonTypeHandler.class)
    private Player from;

    @TableField(typeHandler = JacksonTypeHandler.class)
    private Player to;

    private Double scoreGap; // 评分差

    private Double bonusBase; // 奖励系数

    private Double amount; // 交易数额
}
