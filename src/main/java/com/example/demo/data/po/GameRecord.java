package com.example.demo.data.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.example.demo.data.GameResultEnum;
import com.example.demo.data.PlayerDetail;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@TableName(value = "game_record", autoResultMap = true)
public class GameRecord {

    // 对局的唯一id
    private Long id;

    // 冗余存储玩家名字
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<String> playerNames;

    // 对局详情, 包括了每个玩家, 对应的位置和选用的英雄, 以及评分
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<PlayerDetail> detail;

    private GameResultEnum gameResult;

    // 返回给前端的数据, 设置一下日期的格式
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime time;
}

