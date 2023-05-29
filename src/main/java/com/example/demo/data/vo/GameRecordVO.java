package com.example.demo.data.vo;

import com.example.demo.data.po.LOLTransaction;
import com.example.demo.data.GameResultEnum;
import lombok.Data;
import java.util.List;

/**
 * 前端页面传来的本局的对局数据
 * */
@Data
public class GameRecordVO {

    // 玩家以及位置, 以及选用的英雄, 以及评分
    private List<PlayerAndResultVO> players;

    // 比赛结果, SUCCESS 或 FAIL
    private GameResultEnum result;

    // 本局产生的交易数据
    private List<LOLTransaction> transactionList;

}
