package day10Assignment;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPool {

	public static void main(String[] args) {
		
		OddOrEven[] arr = {
			new OddOrEven(3),	
			new OddOrEven(11),
			new OddOrEven(4),
			new OddOrEven(6),
			new OddOrEven(7),
			new OddOrEven(8)
		};
		
		ExecutorService e =  Executors.newFixedThreadPool(3);
		
		for(OddOrEven ooe : arr) {
			Future<String> f =  e.submit(ooe);
			try {
				System.out.println(f.get());
			} catch (InterruptedException | ExecutionException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		e.shutdown();
	}
	
}
