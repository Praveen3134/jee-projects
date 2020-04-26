package org.training.example.models;

import java.util.List;

import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Book")
public class Book extends LibraryEntity {

    private static final long serialVersionUID = 3404440900499405821L;

    @ManyToMany(mappedBy = "books")
    private List<Author> authors;

    @JsonbProperty("language")
    private String language;

    @JsonbProperty("price")
    private float price;

    @JsonbProperty("description")
    private String description;

    @JsonbProperty("isbn")
    private long isbn;

    @JsonbProperty("noOfPages")
    private int noOfPages;

    @ManyToOne
    private SectionRow row;

    @OneToOne(mappedBy = "book", fetch = FetchType.LAZY)
    private LentRecord record;

    public SectionRow getRow() {
	return row;
    }

    public void setRow(SectionRow row) {
	this.row = row;
    }

    public LentRecord getRecord() {
	return record;
    }

    public void setRecord(LentRecord record) {
	this.record = record;
    }

    public int getNoOfPages() {
	return noOfPages;
    }

    public void setNoOfPages(int noOfPages) {
	this.noOfPages = noOfPages;
    }

    public long getIsbn() {
	return isbn;
    }

    public void setIsbn(long isbn) {
	this.isbn = isbn;
    }

    public List<Author> getAuthors() {
	return authors;
    }

    public void addAuthor(Author author) {
	this.authors.add(author);
    }

    public void removeAuthor(Author author) {
	this.authors.remove(author);
    }

    public String getLanguage() {
	return language;
    }

    public void setLanguage(String language) {
	this.language = language;
    }

    public float getPrice() {
	return price;
    }

    public void setPrice(float price) {
	this.price = price;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

}
