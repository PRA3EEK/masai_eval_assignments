package day9Assignment;

public class Execution {
 
	public static void main(String[] args) {
		
		Common c = new Common();
		
		ThreadA ta = new ThreadA(c);
		ThreadB tb = new ThreadB(c);
		
		ta.start();
		tb.start();
	}
	
	
}
