package com.nla.dao;

import java.util.List;

import com.nla.model.Person;

public interface UserDao {

	Person findByName(String name);

	List<Person> findAll();

}
