package com.example.demo.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.example.demo.data.Player;
import com.example.demo.mapper.PlayerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlayerDAO {

    @Autowired
    private PlayerMapper mapper;

    public long getIdByName(String name) {
        LambdaQueryWrapper<Player> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Player::getPlayerName, name);
        Player player = mapper.selectOne(wrapper);
        return player.getId();
    }

    public List<Player> getAllPlayers() {
        return mapper.selectList(null);
    }

    public List<Player> getAllEnabledPlayers() {
        LambdaQueryWrapper<Player> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Player::getEnabled, true);
        return mapper.selectList(wrapper);
    }

    public Player getPlayerByName(String name) {
        LambdaQueryWrapper<Player> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Player::getPlayerName, name);
        return mapper.selectOne(wrapper);
    }

    public Player getPlayerById(Long id) {
        LambdaQueryWrapper<Player> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Player::getId, id);
        return mapper.selectOne(wrapper);
    }

    public int addPlayer(String name) {

        // 是否已存在, 若是, 则重新启用即可
        Player existPlayer = getPlayerByName(name);
        if (existPlayer != null) {
            return enablePlayer(name);
        }

        // 否则, 插入
        Player player = new Player();
        player.setPlayerName(name);
        player.setEnabled(true);
        return mapper.insert(player);
    }

    public int disablePlayer(String name) {
        LambdaUpdateWrapper<Player> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(Player::getPlayerName, name);
        Player player = new Player();
        player.setEnabled(false);
        return mapper.update(player, wrapper);
    }

    public int enablePlayer(String name) {
        LambdaUpdateWrapper<Player> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(Player::getPlayerName, name);
        Player player = new Player();
        player.setEnabled(true);
        return mapper.update(player, wrapper);
    }
}
