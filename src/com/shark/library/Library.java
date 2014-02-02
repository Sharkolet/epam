package com.shark.library;
import java.util.*;

public class Library {  
	public ArrayList<Book> catalog = new ArrayList<Book>();
	public ArrayList<Client> clientList = new ArrayList<Client>();
	public ArrayList<Order> orderList = new ArrayList<Order>();
	
	
	public void createOrder(Request req) {
		long time = new Date().getTime();
		//for blacklist check
		//long time = (new Date().getTime() + 604800001);
		for (Order order : orderList) {
			if ((req.getClientId() == order.getClientId()) && (time - 604800000 > order.getDate().getTime())) {
				System.out.println("Can't make this order. You are in the blacklist!");
				return;
			}
		}
		for (Book temp : catalog) {
			if ((temp.getName().equals(req.getName()))
					&& (temp.getAuthor().equals(req.getAuthor()))
					&& (temp.getHolder() == 0) ) {
				temp.setHolder(req.getClientId());
				orderList.add(new Order(req.getClientId(), temp.getId(), req.getType()));
				System.out.println("You successfully gain book with id " + temp.getId());
				return;
			}
		}
		System.out.println("Sorry. There is no such a book in the catalog!");
	}
	
	public void returnBook(int clientId, int bookId) {
		for(Order order : orderList) {
			if ((clientId == order.getClientId()) && (bookId == order.getBookId())) {
				orderList.remove(order);
				for(Book book : catalog) {
					if (book.getId() == bookId) {
						book.setHolder(0);
					}
				}
				return;
			}
		}
		System.out.println("You got no such a book in orders!");
	}
	
	public void showOrders () {
		System.out.println("----- Orders: -----");
		for (Order order : orderList) {
			System.out.println(order);
		}
	}
	
	public void showClients () {
		System.out.println("----- Clients: -----");
		for (Client client : clientList) {
			System.out.println(client);
		}
	}
	
	public void showCatalog () {
		System.out.println("----- Catalog: -----");
		for (Book book : catalog) {
			System.out.println(book);
		}
	}
	
	public static void main(String[] args) {
		Library lib = new Library();
		lib.catalog.add(new Book("Hip-Hop", "Shark"));
		lib.catalog.add(new Book("Pop", "Vikky"));
		lib.catalog.add(new Book("Rock", "Marlyn"));
		lib.clientList.add(new Client("Nastya", 13));
		lib.clientList.add(new Client("Sergey", 45));
		lib.createOrder(lib.clientList.get(0).sendRequest("Hip-Hop", "Shark", "here"));
		lib.returnBook(lib.clientList.get(0).getId(), lib.clientList.get(0).returnBook(1));
		lib.createOrder(lib.clientList.get(0).sendRequest("Pop", "Vikky", "here"));
		lib.createOrder(lib.clientList.get(0).sendRequest("Hap", "Vikky", "here"));
		lib.returnBook(lib.clientList.get(0).getId(), lib.clientList.get(0).returnBook(1));
		lib.showClients();
		lib.showCatalog();
		lib.showOrders();
	}

}
