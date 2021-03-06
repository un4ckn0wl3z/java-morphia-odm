package com.anuwat.mongocrud.beans;

import dev.morphia.annotations.Embedded;

@Embedded
public class Address {
 
    private String number;
    private String street;
    private String town;
    private String postcode;
 
    public String getNumber() {
        return number;
    }
 
    public void setNumber(String number) {
        this.number = number;
    }
 
    public String getStreet() {
        return street;
    }
 
    public void setStreet(String street) {
        this.street = street;
    }
 
    public String getTown() {
        return town;
    }
 
    public void setTown(String town) {
        this.town = town;
    }
 
    public String getPostcode() {
        return postcode;
    }
 
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

	@Override
	public String toString() {
		return "Address [number=" + number + ", street=" + street + ", town=" + town + ", postcode=" + postcode + "]";
	}
    
    
 
}