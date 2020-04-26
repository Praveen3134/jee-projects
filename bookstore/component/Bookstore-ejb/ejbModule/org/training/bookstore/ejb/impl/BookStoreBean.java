package org.training.bookstore.ejb.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.training.bookstore.ejb.BookStore;
import org.training.example.models.Book;

/**
 * Session Bean implementation class BookStore
 */
@Singleton
@Startup
public class BookStoreBean implements BookStore {

    @Resource(lookup = "java:jboss/datasource/MySqlDS")
    public DataSource datasource;

    @PersistenceContext
    private EntityManager manager;

    private Connection connection;

    public BookStoreBean() {
    }

    @PostConstruct
    private void init() {
	try {
	    connection = datasource.getConnection();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public boolean addBook(Book book) {
	boolean execute = false;
	StringBuilder builder = new StringBuilder();
	builder.append("insert into BOOKS(title,price,author,language,description) values(\"");
	builder.append(book.getName());
	builder.append("\",");
	builder.append(book.getPrice());
	builder.append(",\"");
	builder.append(book.getAuthors());
	builder.append("\",\"");
	builder.append(book.getLanguage());
	builder.append("\",\"");
	builder.append(book.getDescription());
	builder.append("\")");
	System.out.println(builder.toString());
	try {
	    execute = connection.prepareStatement(builder.toString()).execute();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return execute;
    }

    @Override
    public Book getBook(String isbn) {
	PreparedStatement prepareStatement;
	Book book = new Book();
	try {
	    prepareStatement = connection.prepareStatement("SELECT * FROM BOOKS WHERE ISBN=\"" + isbn + "\"");
	    prepareStatement.execute();
	    ResultSet resultSet = prepareStatement.getResultSet();
	    book.setIsbn(resultSet.getInt(0));
	    book.setName(resultSet.getString(1));
//	    book.addAuthor(resultSet.getString(3));
	    book.setDescription(resultSet.getString(05));
	    book.setPrice(resultSet.getInt(2));
	    book.setLanguage(resultSet.getString(3));
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return book;
    }

    @Override
    public List<Book> getItems() {
	PreparedStatement prepareStatement;
	List<Book> books = new ArrayList<Book>();
	try {
	    prepareStatement = connection.prepareStatement("SELECT * FROM BOOKS");
	    prepareStatement.execute();
	    ResultSet resultSet = prepareStatement.getResultSet();
	    while (resultSet.next()) {
		Book book = new Book();
		book.setIsbn(resultSet.getInt(1));
		book.setName(resultSet.getString(2));
		book.setPrice(resultSet.getInt(3));
//		book.addAuthor(resultSet.getString(4));
		book.setLanguage(resultSet.getString(5));
		book.setDescription(resultSet.getString(6));
		books.add(book);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return books;
    }

    @PreDestroy
    private void destroy() {
	try {
	    connection.close();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
}
