package org.training.example.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class SectionRow extends LibraryEntity {

    private static final long serialVersionUID = -2531819554656829256L;
    private int rowNumber;

    @OneToMany(mappedBy = "row")
    private List<Book> books;

    @OneToOne
    private Section section;

    public SectionRow() {
	super();
    }

    public int getRowNumber() {
	return this.rowNumber;
    }

    public void setRowNumber(int rowNumber) {
	this.rowNumber = rowNumber;
    }

}
