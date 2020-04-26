package org.training.example.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class LentRecord implements Serializable {

    private static final long serialVersionUID = -137976353713189679L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private Date returnDate;
    private Date issueDate;

    @OneToOne(fetch = FetchType.LAZY)
    private Book book;

    @OneToOne(fetch = FetchType.LAZY)
    private LibraryMember borrower;

    public LentRecord() {
	super();
    }

    public long getId() {
	return this.id;
    }

    public Book getBook() {
	return book;
    }

    public void setBook(Book book) {
	this.book = book;
    }

    public LibraryMember getBorrower() {
	return borrower;
    }

    public void setBorrower(LibraryMember borrower) {
	this.borrower = borrower;
    }

    public Date getReturnDate() {
	return this.returnDate;
    }

    public void setReturnDate(Date returnDate) {
	this.returnDate = returnDate;
    }

    public Date getIssueDate() {
	return this.issueDate;
    }

    public void setIssueDate(Date issueDate) {
	this.issueDate = issueDate;
    }

}
