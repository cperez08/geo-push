package com.edu.itm.push.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.edu.itm.push.beans.User;
import com.edu.itm.push.dao.LoginDao;
import com.edu.itm.push.mapper.UserRowMapper;

public class LoginJDBCTemplate implements LoginDao {

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public LoginJDBCTemplate(@Qualifier("dataSource") DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public User loginWithoutPass(String user) {
		
		User us = new User();
		try {
       MapSqlParameterSource params = new MapSqlParameterSource();
		
		params.addValue("user",user);
		StringBuilder sql = new StringBuilder("select UserId,UserNickname,UserPassword,UserProfile from users where UserNickname =:user");
		
		us =  namedParameterJdbcTemplate.queryForObject(sql.toString(), params,new UserRowMapper ());
		
		return us;
		}catch (EmptyResultDataAccessException dex){
			
			return us;
		}
		
	}

	public User loginWithPass(String user, String Pass) {
		// TODO Auto-generated method stub
		return null;
	}

}
