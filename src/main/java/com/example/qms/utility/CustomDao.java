package com.example.qms.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class CustomDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public Integer getNextToken(){
        Integer tokenNo =null;
        Integer finalTokenNo = tokenNo;
        tokenNo = jdbcTemplate.query("SELECT NEXT VALUE FOR token_generator as nextval", resultSet -> finalTokenNo);
        return tokenNo;
    }
}
