package com.example.demo.dao;

import com.example.demo.data.po.GameRecord;
import com.example.demo.mapper.GameRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GameRecordDAO {

    @Autowired
    private GameRecordMapper gameRecordMapper;

    public int insert(GameRecord record) {
        return gameRecordMapper.insert(record);
    }

    public List<GameRecord> getAllRecords() {
        return gameRecordMapper.selectList(null);
    }
}
