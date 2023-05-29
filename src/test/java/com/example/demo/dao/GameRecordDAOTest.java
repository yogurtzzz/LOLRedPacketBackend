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
        record.setPlayerNames(Arrays.asList("毛超", "孔哥", "尧哥"));
        List<PlayerDetail> playerAndPos = new ArrayList<>();
        playerAndPos.add(new PlayerDetail(new Player(1L, "毛超"), PositionEnum.TOP, "诺克萨斯之手", 10.7));
        playerAndPos.add(new PlayerDetail(new Player(2L, "孔哥"), PositionEnum.JUG, "盲僧", 11.8));
        playerAndPos.add(new PlayerDetail(new Player(3L, "尧哥"), PositionEnum.MID, "九尾妖狐", 13.2));
        record.setDetail(playerAndPos);
        record.setGameResult(GameResultEnum.SUCCESS);

        int rowAffected = gameRecordDAO.insert(record);
        Assertions.assertEquals(1, rowAffected);
    }

    @Test
    void testGet() {
        gameRecordDAO.getAllRecords();
    }
}