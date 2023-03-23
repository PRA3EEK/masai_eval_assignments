package sprint3evauation;

public class MainThread {
 
	public static void main(String[] args) throws InterruptedException {
		ThreadA ta = new ThreadA();
		ta.start();
	synchronized(ta) {
		ta.wait();
		System.out.println(ta.getNum());
	}
		
	}
	
	
}
