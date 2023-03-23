package day10Assignment;

public class MainThread {
  
	public static void main(String[] args) throws InterruptedException {
		ThreadA ta = new ThreadA();
		

		ta.start();
	
//		ta.join();
		synchronized(ta) {
			ta.wait();
			System.out.println(ta.prod);
		}
	
	}
	
}
