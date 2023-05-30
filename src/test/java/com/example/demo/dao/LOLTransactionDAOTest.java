package com.example.demo.dao;

import com.example.demo.data.po.LOLTransaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class LOLTransactionDAOTest {

    @Autowired
    private LOLTransactionDAO dao;

    @Test
    void testGet() {
        List<LOLTransaction> transactions = dao.getTransactions();
        System.out.println(transactions);
    }

}