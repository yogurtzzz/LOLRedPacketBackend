package com.example.demo.dao;


import com.example.demo.data.*;
import com.example.demo.data.po.GameRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class GameRecordDAOTest {

    @Autowired
    private GameRecordDAO gameRecordDAO;


    @Test
    void testSave() {
        GameRecord record = new GameRecord();
        record.setTime(LocalDateTime.now());
        record.setPlayerIds(Arrays.asList(1,2,3));
        record.setPlayerNames(Arrays.asList("毛超", "孔哥", "尧哥"));
        List<PlayerDetail> playerAndPos = new ArrayList<>();
        playerAndPos.add(new PlayerDetail(1, "毛超", PositionEnum.TOP, "诺克萨斯之手"));
        playerAndPos.add(new PlayerDetail(2, "孔哥", PositionEnum.JUG, "盲僧"));
        playerAndPos.add(new PlayerDetail(3, "尧哥", PositionEnum.MID, "九尾妖狐"));
        record.setDetail(playerAndPos);

        GameResult gameResult = new GameResult();
        gameResult.setResult(GameResultEnum.SUCCESS);
        List<PlayerAndScore> playerAndScores = new ArrayList<>();

        playerAndScores.add(new PlayerAndScore(1, "毛超", null, 10.2, 2.0, null));
        playerAndScores.add(new PlayerAndScore(2, "孔哥", null, 11.0, 3.0, null));
        playerAndScores.add(new PlayerAndScore(3, "尧哥", null, 10.5, 4.0, null));
        gameResult.setPlayers(playerAndScores);

        record.setGameResult(gameResult);

        int rowAffected = gameRecordDAO.insert(record);
        Assertions.assertEquals(1, rowAffected);
    }

    @Test
    void testGet() {
        gameRecordDAO.getAllRecords();
    }
}