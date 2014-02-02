package com.shark.library;

public class Client {
	private static int idCount = 0;
	private int id;
	private String name;
	private int age;
	
	
	Client(String name, int age) {
		idCount++;
		this.id = idCount;
		this.name = name;
		this.age = age;
	}
	
	public int getId() {
		return id;
	}
	
	public Request sendRequest(String name, String author, String type) {
		return (new Request(this.id, name, author, type));
	}
	
	public int returnBook(int bookId) {
		return bookId;
	}
	
	public boolean equals(Object obj) {
		Client temp = (Client) obj;
		if (this.id == temp.id) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

}
