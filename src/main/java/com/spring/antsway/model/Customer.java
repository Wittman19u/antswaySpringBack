package com.spring.antsway.model;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

	@Column(name = "firstname")
    private String firstname;

	@Column(name = "lastname")
    private String lastname;
    
	@Column(name = "address")
    private String address;
    
	@Column(name = "phoneNumber")
    private String phoneNumber;

    public Customer() {
        // Default values (need a default constructor)
        this.firstname = "John";
        this.lastname = "Doe";
        this.address = "USA";
        this.phoneNumber = "911";
    }

    public Customer(String firstname, String lastname, String address, String phoneNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
	public long getId() {
		return id;
	}

	public String getFirstname() {
		return firstname;
	}

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

	public String getLastname() {
		return lastname;
	}

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

	public String getAddress() {
		return address;
	}

    public void setAddress(String address) {
        this.address = address;
    }

	public String getPhoneNumber() {
		return phoneNumber;
	}

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
