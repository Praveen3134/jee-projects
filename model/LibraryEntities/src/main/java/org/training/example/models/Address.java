package org.training.example.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Address implements Serializable {

    private static final long serialVersionUID = 3118087940337552327L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @OneToOne
    private Person person;

    @NotNull
    private String doorNo;
    private String Street;
    private String landmark;
    @NotNull
    private String city;
    @NotNull
    private String state;
    @NotNull
    private String country;
    @NotNull
    private long pinCode;

    public String getCountry() {
	return country;
    }

    public void setCountry(String country) {
	this.country = country;
    }

    public long getPinCode() {
	return pinCode;
    }

    public void setPinCode(long pinCode) {
	this.pinCode = pinCode;
    }

    public Address() {
	super();
    }

    public long getId() {
	return this.id;
    }

    public String getDoorNo() {
	return this.doorNo;
    }

    public void setDoorNo(String doorNo) {
	this.doorNo = doorNo;
    }

    public String getStreet() {
	return this.Street;
    }

    public void setStreet(String Street) {
	this.Street = Street;
    }

    public String getLandmark() {
	return this.landmark;
    }

    public void setLandmark(String landmark) {
	this.landmark = landmark;
    }

    public String getCity() {
	return this.city;
    }

    public void setCity(String city) {
	this.city = city;
    }

    public String getState() {
	return this.state;
    }

    public void setState(String state) {
	this.state = state;
    }

}
