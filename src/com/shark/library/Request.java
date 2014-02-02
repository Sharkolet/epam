package com.shark.library;

public class Request {
	private int clientId;
	private String name;
	private String author;
	private String type;
	
	Request(int clientId, String name, String author, String type) {
		this.clientId = clientId;
		this.name = name;
		this.author = author;
		this.type = type;
	}

	public int getClientId() {
		return clientId;
	}
	
	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	public String getType() {
		return type;
	}
	
}
