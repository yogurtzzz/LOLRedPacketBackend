package com.example.demo;

import com.example.demo.data.po.GameRecord;
import com.example.demo.mapper.GameRecordMapper;
import com.example.demo.mapper.PlayerMapper;
import com.example.demo.data.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private PlayerMapper mapper;

	@Autowired
	private GameRecordMapper gameRecordMapper;


	@Test
	void basicTest() {
		List<Player> players = mapper.selectList(null);
		players.forEach(System.out::println);
	}

	@Test
	void getGameRecordTest() {
		List<GameRecord> list = gameRecordMapper.selectList(null);
		list.forEach(System.out::println);
	}


}
