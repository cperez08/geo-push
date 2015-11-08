package com.edu.itm.push.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.edu.itm.push.beans.User;

public class UserRowMapper implements RowMapper<User>{

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		User us = new User();
		try {
		
			
		us.setUserId(rs.getInt("UserId"));
		us.setUserNickname(rs.getString("UserNickname"));
		us.setUserPassword(rs.getString("UserPassword"));
		us.setUserProfile(rs.getInt("UserProfile"));
		
		return us;
		}catch (Exception ex){
			
			System.out.println("No se encontraron resultados para la busqueda");
			
			return us;
		}
		
		
	}

}
