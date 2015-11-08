package com.edu.itm.push.services;

import java.util.List;

import com.edu.itm.push.beans.Device;
import com.edu.itm.push.beans.RegisterBean;
import com.edu.itm.push.beans.User;
import com.edu.itm.push.beans.SenderAlertMessage;

public interface PushDaoAction {
	
	public User authWithOutPass(String nickname);
	public User authWithPass(String nickname, String password);
	public List<Device> getEmployesToPush(SenderAlertMessage senderAlertMessage);
	public boolean registerPush (RegisterBean registerBean);

}
