package com.xywei.service.impl;

import com.xywei.domain.User;
import com.xywei.service.UserServiceAnnotation;

public class UserServiceImplAnnotation implements UserServiceAnnotation {

	@Override
	public void saveUser() {
		System.out.println("==保存用户==");
	}

	@Override
	public void saveUser2() {
		System.out.println("==保存用户2==");
	}

	@Override
	public User findUser() {
		System.out.println("==查找用户==");
		return new User("大佬", 50);
	}

	@Override
	public void updateUser() {
		System.out.println("==更新用户==");

	}

	@Override
	public void deleteUser() {
		System.out.println(1 / 0);
		System.out.println("==删除用户==");
	}

}
