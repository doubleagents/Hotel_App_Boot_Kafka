/**
 * 
 */
package com.ericsson.example.advanced.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author ezhsanc
 *
 */
@Document(collection = "Hotel")
public class Hotel {

	@Id
	private String hotelId;
	private String name;
	private int price;
	private Address address;
	private List<Review> reviews;
	
	
	
	/**
	 * @param hotelId
	 * @param name
	 * @param price
	 * @param address
	 * @param review
	 */
	public Hotel(String name, int price, Address address, List<Review> review) {
		
		this.name = name;
		this.price = price;
		this.address = address;
		this.reviews = review;
	}
	
	protected Hotel() {
        this.reviews = new ArrayList<>();
    }
	
	public String getHotelId() {
		return this.hotelId;
	}
	public String getName() {
		return this.name;
	}
	public int getPrice() {
		return this.price;
	}
	public Address getAddress() {
		return address;
	}
	public List<Review> getReview() {
		return this.reviews;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public void setReview(List<Review> review) {
		this.reviews = review;
	}
	
	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", name=" + name + ", price=" + price + ", address=" + address
				+ ", review=" + reviews + "]";
	}
	
	

}
