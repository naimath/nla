package com.nla.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;

import com.nla.web.service.BookService;
import com.nla.web.service.PersonService;
import com.nla.web.repository.entity.Person;
import com.nla.web.repository.entity.Book;
import java.util.List;

@Controller
public class HomeController {

	@Autowired
	PersonService personService;

	@Autowired
	BookService bookService;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(Model model) {
		model.addAttribute("persons", personService.getPersons());
		model.addAttribute("books",bookService.getBooks());
		return "home";
	}

	@RequestMapping(value = "/getbooks/{personId}", method = RequestMethod.GET)
	public @ResponseBody List<Book> welcome(@PathVariable Integer personId) {
		personService.getBooks(personId);
		logger.info(personService.getBooks(personId).toString());
		return personService.getBooks(personId);
	}

}
