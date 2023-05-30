package com.example.demo.data.po;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Data;

import java.time.LocalDateTime;


// 一局对局中产生的一笔交易明细
@Data
@TableName(value = "transaction_record", autoResultMap = true)
public class LOLTransaction {

    private Long id;

    // 由于字段名是mysql的保留关键字, 需要用反引号括起来, 否则会报SQL语法错误
    @TableField(value = "`from`", typeHandler = JacksonTypeHandler.class)
    private Player from;

    // 由于字段名是mysql的保留关键字, 需要用反引号括起来, 否则会报SQL语法错误
    @TableField(value = "`to`", typeHandler = JacksonTypeHandler.class)
    private Player to;

    private Double scoreGap; // 评分差

    private Double bonusBase; // 奖励系数

    private Double amount; // 交易数额

    // 该笔交易所属的对局id
    private Long gameRecordId;

    private LocalDateTime time;
}
