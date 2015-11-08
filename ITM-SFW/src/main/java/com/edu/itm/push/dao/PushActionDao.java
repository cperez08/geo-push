package com.edu.itm.push.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.edu.itm.push.beans.RegisterBean;
import com.edu.itm.push.beans.SenderAlertMessage;
import com.edu.itm.push.beans.User;
import com.edu.itm.push.beans.Device;
import com.edu.itm.push.services.PushDaoAction;
import com.edu.itm.push.dao.DeviceDao;

public class PushActionDao implements PushDaoAction {
	
	@Autowired
	public DeviceDao deviceDao;
	@Autowired
	public LoginDao logindao;

	public User authWithOutPass(String nickname) {

		return logindao.loginWithoutPass(nickname);
	}

	public User authWithPass(String nickname, String password) {
		
		return logindao.loginWithPass(nickname,password);
		
	}

	public List<Device> getEmployesToPush(SenderAlertMessage senderAlertMessage) {
		
		return 	deviceDao.listDevices(senderAlertMessage);

	}

	public boolean registerPush(RegisterBean registerBean) {

		return deviceDao.registerPushId(registerBean);
		
	}
	
}
