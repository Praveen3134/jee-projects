package org.training.example.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Author extends Person {

    private static final long serialVersionUID = -7504211983257834919L;
    private String description;

    @ManyToMany
    @JoinTable(name = "Author_Book", joinColumns = @JoinColumn(name = "Author"), inverseJoinColumns = @JoinColumn(name = "Book"))
    private List<Book> books;

    public Author() {
	super();
    }

    public String getDescription() {
	return this.description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public List<Book> getBooks() {
	return books;
    }

    public void addBook(Book book) {
	this.books.add(book);
    }

    public void removeBook(Book book) {
	this.books.remove(book);
    }
}
