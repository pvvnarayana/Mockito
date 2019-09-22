package com.mock.controller;

import java.util.UUID;

import com.mock.User;
import com.mock.db.DBUtil;
import com.mock.service.UserService;

/**
 * Controller class handling the user operations
 *
 */
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	public UserController() {
		
	}
	
	public Long getUserCount() {
		return userService.getUserCount();
	}
	
	public String getGreetingText(User user) {
		return String.format(getGreetingFormat(), user.getFirstName(), user.getSurname());
	}
	
	private String getGreetingFormat() {
		return "Hello %s %s";
	}
	
	public String createUserId(User user) {
		return String.format("%s_%s", user.getSurname(), UUID.randomUUID().toString());
	}
	
	public static String callStatic() {
		System.out.println("static method");
		return "Hello1";
	}

	public String getStatic() {
		return callStatic();
	}
	
	
	public static String callStaticWithParams(int i, String s) {
		System.out.println("static method params");
		return i+s;
	}
	
	public DBUtil getDB() {
		return new DBUtil();
	}
	
	public DBUtil getConnection() {
		DBUtil db = new DBUtil();
		System.out.println("++ :" +db);
		conn(db);
		System.out.println("-- :"+db);
		return db;
	}

	public void conn(DBUtil db) {
		System.out.println("conn");
		//db = establish connection
	}
}
