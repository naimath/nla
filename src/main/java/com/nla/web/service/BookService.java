package com.nla.web.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.nla.web.repository.BookRepository;
import com.nla.web.repository.entity.Book;

@Service
public class BookService {
	@Resource
	private BookRepository bookRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(BookService.class);

	public List<Book> getBooks() {
		return bookRepository.findAll();
	}
}
