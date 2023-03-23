package sprint4Evaluation;


import java.util.Objects;

public class Book {
//    bookId :int
//	bookName : String
//	author : String
	
	private int bookId;
	private String bookName;
	private String author;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Book(int bookId, String bookName, String author) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
	}
	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(bookId);
	}
	@Override
	public boolean equals(Object obj) {
		Book B = (Book)obj;
		if(this.bookId == B.bookId) {
			return true;
		}else {
			return false;
		}
	}

	@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "Book ID: "+this.bookId+", Book name: "+this.bookName+", Book Author: "+this.author;
		}
	
}
