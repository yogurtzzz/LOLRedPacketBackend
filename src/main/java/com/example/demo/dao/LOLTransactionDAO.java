package com.example.demo.dao;

import com.example.demo.data.po.LOLTransaction;
import com.example.demo.mapper.LOLTransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LOLTransactionDAO {

    @Autowired
    private LOLTransactionMapper mapper;

    public void saveTransactions(List<LOLTransaction> txList) {
        txList.forEach(tx -> mapper.insert(tx));
    }

    public List<LOLTransaction> getTransactions() {
        return mapper.selectList(null);
    }
}
