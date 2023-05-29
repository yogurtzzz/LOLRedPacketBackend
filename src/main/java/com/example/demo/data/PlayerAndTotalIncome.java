package com.example.demo.data;

import lombok.Data;

@Data
public class PlayerAndTotalIncome {

    private Long playerId;

    private String playerName;

    // 收入总和, 保留一位小数
    private Double income;
}
