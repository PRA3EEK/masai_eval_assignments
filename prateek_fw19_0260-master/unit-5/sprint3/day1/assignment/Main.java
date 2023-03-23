package day8Assignment;

public class Main {
 
	
	public static void main(String[] args) {
	
	
	
	ThreadA ta = new ThreadA();
	Thread t1 = new Thread(ta);
	Thread t2 = new Thread(ta);
	
	t1.setName("Dhoni");
	t2.setName("kohli");
	t1.setPriority(8);
	t2.setPriority(10);
	
	
	t1.start();
	t2.start();
}

}
