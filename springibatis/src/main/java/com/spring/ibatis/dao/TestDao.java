package com.spring.ibatis.dao;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.spring.ibatis.domain.LoginForm;

public class TestDao extends SqlMapClientDaoSupport {
    public LoginForm getById() {  
        
        Long param = 1L;  
        LoginForm lForm = (LoginForm) getSqlMapClientTemplate().queryForObject("getUser", param);  
        return lForm;  
    }  
}
