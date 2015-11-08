package com.edu.itm.push.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.edu.itm.push.beans.Device;

public class DeviceRowMapper implements RowMapper<List<Device>> {

	public List<Device> mapRow(ResultSet rs, int rowNum) throws SQLException {

		
		List<Device> device = new ArrayList<Device>();

		do {
			Device dev = new Device();
			dev.setActiveDevice(rs.getString("ActiveDevice"));
			dev.setDeviceId(rs.getInt("DeviceId"));
			dev.setUserDevice(rs.getInt("UserDevice"));
			dev.setPushId(rs.getString("PushId"));
			device.add(dev);
			dev =null;
		} while (rs.next());

		return device;

	}

}
