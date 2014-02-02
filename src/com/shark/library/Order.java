package com.shark.library;
import java.util.*;

public class Order {
	private int clientId;
	private int bookId;
	private Date date;
	private String requestType; // home or here
	
	
	Order(int id, int bookId, String type) {
		this.clientId = id;
		this.bookId = bookId;
		date  = new Date();
		requestType = new String(type);
	}


	public int getClientId() {
		return clientId;
	}

	public Date getDate() {
		return date;
	}


	@Override
	public String toString() {
		return "Order [clientId=" + clientId + ", bookId=" + bookId + ", date="
				+ date + ", requestType=" + requestType + "]";
	}


	public int getBookId() {
		return bookId;
	}
	
}
