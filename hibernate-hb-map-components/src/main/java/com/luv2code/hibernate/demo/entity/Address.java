package com.luv2code.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Address {
	
	@Column
    protected String street;

    @Column
    protected String zipcode;

    @Column
    protected String city;
    
    /**
     * Hibernate will call this no-argument constructor to create an instance, and then
     * populate the fields directly.
     */
    
    public Address() {
    }

    /**
     * You can have additional (public) constructors for convenience.
     */
    public Address(String street,  String city, String zipcode) {
    	super();
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
