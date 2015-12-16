package model;

import java.util.List;

public class User {
	String phoneNumber;
	String password;
	String firstName;
	String email;
	List<Feed> feeds;
	int maxNewsPerFeed = 2;
	
	public int getMaxNewsPerFeed() {
		return maxNewsPerFeed;
	}
	public void setMaxNewsPerFeed(int maxNewsPerFeed) {
		this.maxNewsPerFeed = maxNewsPerFeed;
	}
	public List<Feed> getFeeds() {
		return feeds;
	}
	public void setFeeds(List<Feed> feeds) {
		this.feeds = feeds;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
