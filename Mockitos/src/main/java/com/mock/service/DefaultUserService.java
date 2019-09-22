package com.mock.service;

import com.mock.User;

public class DefaultUserService implements UserService {
	public User getUserById(Long userId) {
		return null;
	}

	public void updateUserDetails(User newUserDetails) {
	}

	public void createUser(User user) {
	}

	public Long getUserCount() {
		return Long.valueOf(10L);
	}
}
