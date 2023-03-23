package sprint3evauation;

import java.util.concurrent.Callable;

public class FindProd implements Callable<Integer>{
	private int num;
	
	public FindProd(int num) {
		this.num = num;
	}

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		int prod = 1;
		for(int i=1 ; i<=num ; i++) {
			prod = prod*i;
		}
	  return prod;
	}
  
}
