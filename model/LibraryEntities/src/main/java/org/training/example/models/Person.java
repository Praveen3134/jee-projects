package org.training.example.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Person extends LibraryEntity {

    private static final long serialVersionUID = -1945056959857738930L;
    private String userName;
    private String password;
    private String phoneNo;

    @Lob
    @Column(name = "UserPic")
    private byte[] imageData;

    @OneToMany(mappedBy = "person")
    private List<Address> addresses;

    public Person() {
	super();
    }

    public String getUserName() {
	return this.userName;
    }

    public void setUserName(String userName) {
	this.userName = userName;
    }

    public String getPassword() {
	return this.password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getPhoneNo() {
	return this.phoneNo;
    }

    public byte[] getImageData() {
	return imageData;
    }

    public void setImageData(byte[] imageData) {
	this.imageData = imageData;
    }

    public List<Address> getAddresses() {
	return addresses;
    }

    public void addAddresses(Address address) {
	this.addresses.add(address);
    }

    public void removeAddresses(Address address) {
	this.addresses.remove(address);
    }

    public void setPhoneNo(String phoneNo) {
	this.phoneNo = phoneNo;
    }

}
