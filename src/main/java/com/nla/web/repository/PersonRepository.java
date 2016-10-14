package com.nla.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nla.web.repository.entity.Person;

public interface  PersonRepository extends JpaRepository<Person,Integer> {

}
