package sprint3evauation;

public class ThreadDhoni extends Thread{
 @Override
	public void run () {
	  int sum = 0;
	  for(int i=1 ; i<=20 ; i++) {
		  sum+=i;
	  }
	  System.out.println(sum);
  }
}
