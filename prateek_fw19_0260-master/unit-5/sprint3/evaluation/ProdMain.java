package sprint3evauation;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ProdMain {
 
	
	public static void main(String[] args) {
		FindProd[] arr = {
				new FindProd(5),
				new FindProd(6),
				new FindProd(7),
				new FindProd(8),
				new FindProd(9),
				new FindProd(10),
		};
	  ExecutorService ser = Executors.newFixedThreadPool(3);
       for(FindProd fp:arr) {
    	   Future<Integer> f = ser.submit(fp);
    	   try {
			System.out.println(f.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       }
       ser.shutdown();
	}

}
