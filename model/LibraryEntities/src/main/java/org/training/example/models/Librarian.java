package org.training.example.models;

import java.sql.Timestamp;

import javax.persistence.Entity;

@Entity

public class Librarian extends Person {

    private static final long serialVersionUID = 6930691096604603462L;
    private Timestamp shiftTime;

    public Librarian() {
	super();
    }

    public Timestamp getShiftTime() {
	return this.shiftTime;
    }

    public void setShiftTime(Timestamp shiftTime) {
	this.shiftTime = shiftTime;
    }

}
