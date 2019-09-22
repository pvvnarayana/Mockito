package com.mock.service;

import com.mock.User;

public interface UserService {
	User getUserById(Long paramLong);

	void updateUserDetails(User paramUser);

	void createUser(User paramUser);

	Long getUserCount();
}
