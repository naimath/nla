package com.nla.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nla.web.repository.entity.Book;

public interface  BookRepository extends JpaRepository<Book,Integer> {

}
