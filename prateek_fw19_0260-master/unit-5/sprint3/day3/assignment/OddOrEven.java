package day10Assignment;

import java.util.concurrent.Callable;

public class OddOrEven implements Callable<String>{
     private int num;
     
	public OddOrEven(int num) {
		super();
		this.num = num;
	}

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		if(num % 2==0) {
			return "Even Number";
		}else {
			return "Odd Number";
		}
	}

}
