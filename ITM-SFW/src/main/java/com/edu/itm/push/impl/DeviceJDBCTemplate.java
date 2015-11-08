package com.edu.itm.push.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;



import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.edu.itm.push.beans.Device;
import com.edu.itm.push.beans.RegisterBean;
import com.edu.itm.push.beans.SenderAlertMessage;
import com.edu.itm.push.dao.DeviceDao;
import com.edu.itm.push.mapper.DeviceRowMapper;

public class DeviceJDBCTemplate implements DeviceDao {
	
	public  static final double RADIUS = 6371.0;

	 private JdbcTemplate jdbcTemplate;
	 private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	 @Autowired
	public DeviceJDBCTemplate (@Qualifier("dataSource")DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
		namedParameterJdbcTemplate =  new NamedParameterJdbcTemplate(dataSource);
		}

	public void create(String name, Integer age) {
		// TODO Auto-generated method stub

	}

	public Device getDevice(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Device> listDevices(SenderAlertMessage senderAlertMessage) {
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		
		params.addValue("radius", RADIUS);
		params.addValue("lat", senderAlertMessage.getLatitude());
		params.addValue("lon", senderAlertMessage.getLongitude());
		params.addValue("pro",senderAlertMessage.getUserinfo().getUserProfile());
		params.addValue("entityid",senderAlertMessage.getAction());
		
		
		StringBuilder sql = new StringBuilder("select d.DeviceId,d.UserDevice,d.PushId,d.ActiveDevice  from device d inner join users u on u.UserId = d.UserDevice inner join profile p on p.ProfileId = u.UserProfile inner join points_entity en on en.UserId = u.UserId inner join entity et on en.entityId = en.entityId where en.pointId in ( select pointId from( select pointId, sum(:radius * acos(cos(radians(:lat)) * cos(radians(latitude)) * cos(radians(longitude) - radians(:lon)) + sin(radians(:lat)) * sin(radians(latitude)))) as distance from points_entity group by pointId having sum(:radius * acos(cos(radians(:lat)) * cos(radians(latitude)) * cos(radians(longitude) - radians(:lon)) + sin(radians(:lat)) * sin(radians(latitude))))  <= 5  order by distance )  points_distance ) and p.ProfileId = :pro and d.ActiveDevice = 'Y' and et.EntityId = :entityid LIMIT 5;");
		
		List<Device> dev = namedParameterJdbcTemplate.queryForObject(sql.toString(), params,
                new DeviceRowMapper());
		return dev;
	}

	public Device getToPush(SenderAlertMessage senderAlertMessage) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean registerPushId(RegisterBean registerBean){
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		
		params.addValue("pushid", registerBean.getPushId());
		params.addValue("userdevice", registerBean.getUserDevice());
		
		try {
			
			StringBuilder sql = new StringBuilder("update device set PushId = :pushid where UserDevice = :userdevice;");
			
			int result = namedParameterJdbcTemplate.update(sql.toString(), params);
			
			if (result > 0){
			
			return true;
			
			}else {
				
				return false;
			}
			
		}catch (Exception ex){
			
			return false;
		}

		
	}

}
