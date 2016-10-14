package com.nla.web.repository.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import java.util.List;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "person")
public class Person {

	@Id
	private Integer id;
	private String name;
	private Integer phone;
	private String email;
	@OneToMany( fetch = FetchType.EAGER)
	@JoinColumn(name="PERSON_ID")
	private List<Book> books;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Book> getBooks(){
		return this.books;
	}
	public void setBooks(List<Book> books){
		this.books = books;
	}

}
