package sprint3evauation;

public class ThreadRohit extends Thread{
  
	@Override
	public void run () {
	  int prod = 1;
	  for(int i=1 ; i<=10 ; i++) {
		  prod = prod*i;
	  }
	  System.out.println(prod);
  }
}
