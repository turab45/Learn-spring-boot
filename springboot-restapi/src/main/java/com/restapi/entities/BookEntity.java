package com.restapi.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class BookEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private Integer noOfCopies;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "author_id")
	private AuthorEntity author;

	
	


	@Override
	public String toString() {
		return "BookEntity [id=" + id + ", title=" + title + ", noOfCopies=" + noOfCopies + ", author=" + author + "]";
	}





	public Integer getId() {
		return id;
	}





	public void setId(Integer id) {
		this.id = id;
	}





	public String getTitle() {
		return title;
	}





	public void setTitle(String title) {
		this.title = title;
	}





	public Integer getNoOfCopies() {
		return noOfCopies;
	}





	public void setNoOfCopies(Integer noOfCopies) {
		this.noOfCopies = noOfCopies;
	}





	public AuthorEntity getAuthor() {
		return author;
	}





	public void setAuthor(AuthorEntity author) {
		this.author = author;
	}





	public BookEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
