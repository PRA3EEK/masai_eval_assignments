package day1Assignment;

public class Library {

	@Override
	public String toString() {
		return "Library [bookId=" + bookId + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + "]";
	}

	private int bookId;
	private String bookName;
	private String bookAuthor;
	
	public Library(int bookId, String bookName, String bookAuthor) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
	}
     
    public Library() {
	// TODO Auto-generated constructor stub
    }

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

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	
//	@Override
//	public int compareTo (Library o) {
//	    if(this.bookId > o.bookId) {
//	    	return +1;
//	    	
//	    }else if(this.bookId < o.bookId) {
//	    	return -1;
//	    }else {
//	    	return 0;
//	    }
//	}

   @Override
   public boolean equals(Object o) {
	   Library l = (Library)o;
	   return this.bookId == l.getBookId();
   }
   @Override
   public int hashCode() {
	   return this.bookId;
   }
	
}
