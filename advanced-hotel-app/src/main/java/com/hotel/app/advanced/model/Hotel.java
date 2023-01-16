/**
 * 
 */
package com.hotel.app.advanced.model;

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

	private Amenities amenities;


	public Amenities getAmenities() {
		return amenities;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setAmenities(Amenities amenities) {
		this.amenities = amenities;
	}

	/**
	 * @param name
	 * @param price
	 * @param address
	 * @param review
	 *
	 */
	public Hotel(String name, int price, Address address, List<Review> review,Amenities amenities) {
		
		this.name = name;
		this.price = price;
		this.address = address;
		this.reviews = review;
		this.amenities = amenities;
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
