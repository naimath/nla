package com.nla.dao;

import java.util.List;

import com.nla.model.User;

public interface UserDao {

	User findByName(String name);

	List<User> findAll();

}
