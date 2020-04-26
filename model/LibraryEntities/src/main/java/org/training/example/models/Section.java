package org.training.example.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Section extends LibraryEntity {

    private static final long serialVersionUID = 745245735040014245L;
    private String description;

    @OneToMany(mappedBy = "section")
    private List<SectionRow> rows;

    public Section() {
	super();
    }

    public List<SectionRow> getRows() {
	return rows;
    }

    public void addRow(SectionRow row) {
	this.rows.add(row);
    }

    public void removeRow(SectionRow row) {
	this.rows.remove(row);
    }

    public String getDescription() {
	return this.description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

}
