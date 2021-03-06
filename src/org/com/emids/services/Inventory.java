package org.com.emids.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.com.emids.domain.Book;


public class Inventory {
	static Scanner scanner = new Scanner(System.in);
	static List<Book> listForAllBook = new ArrayList<>();

	public List<Book> searchByBookName() {
		listForAllBook.addAll(Product.addNewProduct());
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter the book name ");
		String bookname = scanner.next();
		Iterator<Book> iterator = listForAllBook.iterator();
		bookName(scanner, bookname, iterator);
		return listForAllBook;
	}

	private void bookName(Scanner scanner, String bookname, Iterator<Book> iterator) {
		boolean flag = false;
		while (iterator.hasNext()) {
			flag = checkPresenceOfBook(iterator, bookname);
			if (flag) {
				System.out.println("press 1 to add cart\n" + "press 2 to buy book\n"+"press 3 to add to bookshelf");
				int key = scanner.nextInt();
				switch (key) {
				case 1:
					ShoppingCart.addToCart(iterator.next());
					break;
				case 2:
					ShoppingCart.buyBook(iterator.next());
					break;
				case 3:
					CustomerBookShelf.addTo();
					break;
				default:
					System.out.println("invalid entry");
					break;
				}
				System.out.println("book is available");
			} else {
				System.out.println("book is not available");
				
			}
				
		}
	}

	

	

	private boolean checkPresenceOfBook(Iterator<Book> iterator,  String bookName) {
		boolean flag = false;
		while (iterator.hasNext()) {
			Book book = iterator.next();
			
			 if (null != bookName && bookName.equalsIgnoreCase(book.getName())) {
				flag = true;
				System.out.println("Book details");
				System.out.println("Book name: " + book.getName() + " Book author: " + "" + book.getBookAuthor()
						+ "Book price: " + book.getPrice());
				break;
			}
		}
		return flag;
	}

}
