package com.shark.library;

public class Book {
	private static int idCount = 0;
	private int id;
	private String name;
	private String author;
	private int holder = 0;
	
	
	Book(String name, String author) {
		this.id = ++idCount;
		this.name = name;
		this.author = author;
	}

	public int getHolder() {
		return holder;
	}
	
	public void setHolder(int holder) {
		this.holder = holder;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author
				+ ", holder=" + holder + "]";
	}
	
}
