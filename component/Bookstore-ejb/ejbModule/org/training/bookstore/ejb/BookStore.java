package org.training.bookstore.ejb;

import java.util.List;

import javax.ejb.Remote;

import org.training.example.models.Book;

@Remote
public interface BookStore {

    public void addBook(Book book);

    public Book getBook(String isbn);

    public List<Book> getItems();
}
