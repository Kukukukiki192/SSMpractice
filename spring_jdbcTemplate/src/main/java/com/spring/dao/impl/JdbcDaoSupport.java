package com.spring.dao.impl;

/**
 * 抽取Dao中重复代码
 */
public class JdbcDaoSupport {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
