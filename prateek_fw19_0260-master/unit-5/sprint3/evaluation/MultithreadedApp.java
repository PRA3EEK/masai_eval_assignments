package sprint3evauation;

public class MultithreadedApp {
  
	
	public static void main(String[] args) {
		ThreadKohli tk = new ThreadKohli();
		ThreadDhoni td = new ThreadDhoni();
		ThreadRohit tr = new ThreadRohit();
		tk.setName("Kohli");
		td.setName("Dhoni");
		tr.setName("Rohit");
		
		
		td.setPriority(10);
		tr.setPriority(9);
		tk.setPriority(1);
		
		
		
		td.start();
		try {
			td.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tr.start();
		try {
			tr.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tk.start();
	}
}
