package com.app.demo.service;

import com.app.demo.model.User;

public interface UserService {
	public void saveUser(User user);
	public boolean isUserAlreadyPresent(User user);
}
