/**
 * 
 */
package com.ericsson.example.advanced.model;

/**
 * @author ezhsanc
 *
 */
public class Review {
	private String username;
	private int rating;
	private boolean isApproved;
	
	/**
	 * @param username
	 * @param rating
	 * @param isApproved
	 */
	public Review(String username, int rating, boolean isApproved) {
		super();
		this.username = username;
		this.rating = rating;
		this.isApproved = isApproved;
	}
	public String getUsername() {
		return username;
	}
	public int getRating() {
		return rating;
	}
	public boolean isApproved() {
		return isApproved;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	
	@Override
	public String toString() {
		return "Review [username=" + username + ", rating=" + rating + "]";
	}
	
	
	
}
