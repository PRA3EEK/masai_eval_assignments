package day9Assignment;

public class Main {

	public static void main(String[] args) {
		ThreadEven te = new ThreadEven();
		ThreadOdd to = new ThreadOdd();
	   
		Thread t1 = new Thread(te);
		Thread t2 = new Thread(to);
		
		
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
		
		
	}
	
}
