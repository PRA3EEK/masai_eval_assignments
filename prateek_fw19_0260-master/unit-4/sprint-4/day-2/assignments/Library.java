package day14Assignment;
import java.util.List;
import java.util.ArrayList;
public class Library {
 
	List<Book> bookList = new ArrayList<>();
	
	
	public void addBook(Book book) {
		bookList.add(book);
		System.out.println("Book added successfuly!");
	}
	
	
	public boolean isEmpty () {
		if(bookList.size() == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public List<Book> viewAllBooks () {
		 return bookList;
	}
	
	
	public List<Book> viewBooksByAuthor(String author) {
		List<Book> L = new ArrayList<>();
		for(Book b:bookList) {
			if(b.getAuthor().equals(author) ) {
				L.add(b);
			}
		}
		if(L.size() != 0) {
			return L;
		}else {
			return null;
		}
		
	}
	
	
	public int countNoOfBook(String bookName) {
		
		int count = 0;
		for(Book b:bookList) {
			if(b.getBookName().toLowerCase().equals(bookName)) {
				++count;
			}
		}
		return count;
		
	}
}
