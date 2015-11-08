package com.edu.itm.push.dao;

import com.edu.itm.push.beans.User;

public interface LoginDao {
	
	public User loginWithoutPass (String user);
	
	public User loginWithPass (String user, String Pass);

}
