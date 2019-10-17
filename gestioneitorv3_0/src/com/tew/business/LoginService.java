package com.tew.business;

import com.tew.model.User;

public interface LoginService {
	public User verify(String login, String password);
}
