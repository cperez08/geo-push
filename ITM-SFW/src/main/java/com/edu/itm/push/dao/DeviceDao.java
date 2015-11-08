package com.edu.itm.push.dao;

import java.util.List;

import com.edu.itm.push.beans.Device;
import com.edu.itm.push.beans.RegisterBean;
import com.edu.itm.push.beans.SenderAlertMessage;

public interface DeviceDao {
	
	   public void create(String name, Integer age);

	   public Device getDevice(Integer id);
	   
	   public List<Device> listDevices(SenderAlertMessage senderAlertMessage);
	   
	   public Device getToPush (SenderAlertMessage senderAlertMessage);
	   
	   public boolean registerPushId(RegisterBean registerBean);

}
