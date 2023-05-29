package com.example.demo.service;

import com.example.demo.dao.GameRecordDAO;
import com.example.demo.dao.PlayerDAO;
import com.example.demo.data.*;
import com.example.demo.data.po.GameRecord;
import com.example.demo.data.vo.GameRecordVO;
import com.example.demo.data.vo.PlayerAndResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameRecordService {

    @Autowired
    private GameRecordDAO gameRecordDAO;

    @Autowired
    private PlayerDAO playerDAO;

    // 保存一局对局的记录到数据库
    public boolean saveRecord(GameRecordVO gameRecordVO) {
        GameRecord gameRecord = transform(gameRecordVO);
        int i = gameRecordDAO.insert(gameRecord);

        //TODO 保存本局产生的交易记录

        // 保存成功与否
        return i > 0;
    }

    // 将从前端传入的数据进行转化, 转成存储到后端的数据
    public GameRecord transform(GameRecordVO gameRecordVO) {
        GameRecord gameRecord = new GameRecord();

        List<String> playerNames = new ArrayList<>();
        List<PlayerDetail> playerDetailList = new ArrayList<>();

        List<PlayerAndResultVO> playerVOList = gameRecordVO.getPlayers();

        for (PlayerAndResultVO e : playerVOList) {
            String playerName = e.getPlayerName();
            Double score = e.getScore();
            PositionEnum position = e.getPosition();
            String legendName = e.getLegendName();
            long playerId = playerDAO.getIdByName(playerName);
            playerNames.add(playerName);

            PlayerDetail detail = new PlayerDetail();
            detail.setPlayer(new Player(playerId, playerName));
            detail.setPosition(position);
            detail.setLegendName(legendName);
            detail.setScore(score);
            playerDetailList.add(detail);
        }

        gameRecord.setPlayerNames(playerNames);
        gameRecord.setDetail(playerDetailList);
        gameRecord.setGameResult(gameRecordVO.getResult());
        return gameRecord;
    }
}
