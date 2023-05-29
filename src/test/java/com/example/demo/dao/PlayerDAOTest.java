package com.example.demo.dao;

import com.example.demo.data.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PlayerDAOTest {

    @Autowired
    private PlayerDAO playerDAO;

    String nameBase = "测试玩家";

    @Test
    void testPlayerDao() {
        // 因为玩家名称有唯一性约束, 所以单元测试保证每次玩家名字不一样
        String name = nameBase + System.currentTimeMillis();

        // 测试添加玩家
        int row = playerDAO.addPlayer(name);
        Assertions.assertEquals(1, row);

        // 禁用玩家
        Player beforeDisable = playerDAO.getPlayerByName(name);
        playerDAO.disablePlayer(name);
        Player afterDisable = playerDAO.getPlayerByName(name);

        Assertions.assertEquals(true, beforeDisable.getEnabled());
        Assertions.assertEquals(false, afterDisable.getEnabled());

        // 重新启用
        playerDAO.enablePlayer(name);
        Player afterEnable = playerDAO.getPlayerByName(name);

        Assertions.assertEquals(true, afterEnable.getEnabled());
    }

}