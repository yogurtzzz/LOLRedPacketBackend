package com.example.demo.controller;

import com.example.demo.dao.GameRecordDAO;
import com.example.demo.dao.LOLTransactionDAO;
import com.example.demo.dao.PlayerDAO;
import com.example.demo.data.po.GameRecord;
import com.example.demo.data.po.LOLTransaction;
import com.example.demo.data.po.Player;
import com.example.demo.data.vo.GameRecordVO;
import com.example.demo.service.GameRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FrontendController {

    @Autowired
    private PlayerDAO playerDAO;

    @Autowired
    private GameRecordDAO gameRecordDAO;

    @Autowired
    private LOLTransactionDAO transactionDAO;

    @Autowired
    private GameRecordService gameRecordService;

    @GetMapping("/test")
    public String test() {
        return "success";
    }

    @GetMapping("/getAllPlayers")
    public List<Player> getAllPlayers() {
        return playerDAO.getAllPlayers();
    }

    @GetMapping("/getEnabledPlayers")
    public List<Player> getEnabledPlayers() {
        return playerDAO.getAllEnabledPlayers();
    }

    @PostMapping("/addPlayer")
    public String addPlayer(String playerName) {
        try {
            playerDAO.addPlayer(playerName);
            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }

    @PostMapping("/disablePlayer")
    public String disablePlayer(String playerName) {
        try {
            playerDAO.disablePlayer(playerName);
            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }


    // 保存对局记录
    @PostMapping("/saveGameRecord")
    public String saveGameRecord(@RequestBody GameRecordVO gameRecord) {
        boolean success = gameRecordService.saveRecord(gameRecord);
        return success ? "success" : "fail";
    }

    @GetMapping("/getGameRecords")
    public List<GameRecord> getGameRecords() {
        return gameRecordDAO.getAllRecords();
    }

    @GetMapping("/getTransactions")
    public List<LOLTransaction> getAllTransactions() {
        return transactionDAO.getTransactions();
    }
}
