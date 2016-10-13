package com.nla.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nla.web.repository.entity.Person;
import com.nla.web.service.PersonService;

@Controller
public class HomeController {
	
	@Autowired
	PersonService personService;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(Model model) {
		List<Person> persons = personService.getPersons();
		logger.info(persons.toString());
		model.addAttribute("persons", persons);
		return "home";
	}

}
