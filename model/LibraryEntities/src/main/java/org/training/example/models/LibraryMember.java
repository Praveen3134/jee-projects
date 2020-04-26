package org.training.example.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class LibraryMember extends Person {

    private static final long serialVersionUID = 5109748460169698515L;

    @OneToMany(mappedBy = "borrower")
    private List<LentRecord> borrowedBooks;

    public LibraryMember() {
	super();
    }

}
