package sprint2Evaluation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Library {
	
	List<Book> bookList = new ArrayList<>();
  public void addBook (Book b) throws BookException{
	  for(Book book:bookList) {
		  if(book.getIsbn() == b.getIsbn()) {
			  BookException be = new BookException("Book already exist");
			  throw be;
		  }
	  }
	  bookList.add(b);
	  System.out.println("Book added successfuly");
  }
  public List<Book> viewAllBooks() throws BookException{
	  if(bookList.size()==0) {
		  BookException be = new BookException("No Book present in the list");
		  throw be;
	  }
	  bookList.sort((o1,o2) -> o1.getBookName().compareTo(o2.getBookName()));
	  return bookList;
  }
  public List<Book> viewBooksByAuthor(String name) throws BookException{
	  List<Book> newList = new ArrayList<>();
	  for(Book b:bookList) {
		  if(b.getAuthor().equals(name)) {
			  newList.add(b);
		  }
	  }
	  if(newList.size() == 0) {
		  BookException be  = new BookException("None of the book published by the author "+name);
		  throw be;
	  }
	  return newList;
  }
  public Book getBookByIsbn(int isbn) throws BookException{
	 for(Book b:bookList) {
		 if(b.getIsbn() ==isbn) {
			 return b;
		 }
	 }
	 BookException be = new BookException("No book with this isbn is available");
	 throw be;
  }
  public static void main(String[] args) {
	  Library l = new Library();
	Scanner sc = new Scanner(System.in);
	boolean flag = true;
	
	while(flag) {
		System.out.println("1.Add Book");
		System.out.println("2.Display all book details");
		System.out.println("3.Search Book by author");
		System.out.println("4.Search book by ISBN");
		System.out.println("5.Exit");
		System.out.println("Enter your choice: ");
		int choice = sc.nextInt();
		if(choice == 1) {
			System.out.println("Enter the isbn no: ");
			int isbn = sc.nextInt();
			System.out.println("Enter the book name: ");
			String name = sc.next();
			sc.nextLine();
			System.out.println("Enter the author name: ");
			String author = sc.nextLine();
			Book book = new Book(isbn, name, author);
			try {
				
				l.addBook(book);
			}catch(BookException e) {
				System.out.println(e.message);
			}
		}else if(choice == 2) {
			try {
				System.out.println(l.viewAllBooks());
				
			}catch(BookException e) {
				System.out.println(e.message);
			}
		}else if(choice == 3) {
			System.out.println("Enter the author name");
			sc.nextLine();
			String aName = sc.nextLine();
			try {
				System.out.println(l.viewBooksByAuthor(aName));
				
			}catch(BookException e) {
				System.out.println(e.message);
			}
		}else if(choice == 4) {
			System.out.println("Enter isbn");
			int isbn = sc.nextInt();
			try {
				System.out.println(l.getBookByIsbn(isbn));
			}
			catch(BookException e) {
				System.out.println(e.message);
			}
		}else if(choice == 5) {
			System.out.println("Thank you!");
			flag = false;
		}
	}
	
}
}
