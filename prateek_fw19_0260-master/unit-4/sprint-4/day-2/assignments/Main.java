package day14Assignment;
import java.util.Scanner;
import java.util.List;
public class Main {
    
	
	public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       
       Library L = new Library();
       while(true) {
    	   System.out.println("1. Add Book");
           System.out.println("2. Display all book details");
           System.out.println("3. Search Book by author");
           System.out.println("4. Count number of books - by book name");
           System.out.println("5. Exit");
           System.out.println("Enter your choice");
           int choice = sc.nextInt();
          
          
        	   if(choice == 1) {
        		   System.out.println("Enter ISBN number");
            	   int num = sc.nextInt();
            	   sc.nextLine();
            	   System.out.println("Enter book name");
            	   String name = sc.nextLine();
            	   
            	   System.out.println("Enter author name");
            	   String Aname = sc.nextLine();
            	   
            	   Book B = new Book(num, name.toLowerCase(), Aname.toLowerCase());
            	   
            	   L.addBook(B);
        	   }
        	   else if(choice == 2) {
        		   
            	   List<Book> l = L.viewAllBooks();
            	   for(Book b:l) {
            		   System.out.println("ISBN number : "+b.getIsbn());
            		   System.out.println("Book name : "+b.getBookName());
            		   System.out.println("Author name : "+b.getAuthor());
            		   System.out.println("======================");
            	   }
            	   
        	   }else if(choice == 3) {
        		   
        		   System.out.println("Enter name of Author");
            	   String name1 = sc.next();
            	  
            	   List<Book> l = L.viewBooksByAuthor(name1.toLowerCase());
            	   if(l!=null) {
            		   for(Book b:l) {
                		   System.out.println("ISBN number : "+ b.getIsbn());
                		   System.out.println("Book name : "+b.getBookName());
                		   System.out.println("Author name : "+b.getAuthor());
                		   System.out.println("======================");
                	   }
            	   }else {
            		   System.out.println("The list is empty!");
            	   }
            	   
        	   
        	   }else if(choice == 4) {
        	      
            	   System.out.println("Enter book name");
            	   sc.nextLine();
            	   String bname = sc.nextLine();
            	   System.out.println("There are "+L.countNoOfBook(bname.toLowerCase())+" book/books of name "+bname+" in the library");
        	      
        	   }else if(choice == 5) {
                   
        		   System.out.println("Thank you!");
                   break;
        	   
        	   }
                
        	     
           }	   
    }
}
