package org.training.bookstore.ejb.impl;

import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.training.bookstore.ejb.BookStore;
import org.training.example.models.Book;

/**
 * Session Bean implementation class BookStore
 */
@Singleton
@Startup
public class BookStoreBean implements BookStore {

    @PersistenceContext
    private EntityManager em;

    public BookStoreBean() {
    }

    @Override
    public void addBook(Book book) {
	em.persist(book);
    }

    @Override
    public Book getBook(String isbn) {
	Query query = em.createNativeQuery("Select b from Book b where isbn=" + isbn, Book.class);
	query.executeUpdate();
	Book book = (Book) query.getSingleResult();
	return book;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Book> getItems() {
	TypedQuery<Book> query = em.createQuery("Select b from Book b", Book.class);
	List<Book> books = query.getResultList();
	return books;
    }

}
