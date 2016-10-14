package com.nla.web.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.nla.web.repository.PersonRepository;
import com.nla.web.repository.entity.Person;
import com.nla.web.repository.entity.Book;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;


@Service
@Transactional
public class PersonService {
	@Resource
	private PersonRepository personRepository;

	private static final Logger logger = LoggerFactory.getLogger(PersonService.class);

	public List<Person> getPersons() {
		return personRepository.findAll();
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public List<Book> getBooks(Integer personId){
		return personRepository.findOne(personId).getBooks();
	}
}
