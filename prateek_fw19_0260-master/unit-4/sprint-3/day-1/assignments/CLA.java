package day8Assignment;

public class CLA {
   public static void main(String[] args) {
	// TODO Auto-generated method stub
	   int prod = 1;
    if(args.length==1) {
      int start = Integer.parseInt(args[0]);
      
    	for(int i=start ; i>=1 ; i--) {
    		prod = prod*i;
    		
    	}
    	System.out.println(prod);
    }else if(args.length==2) {
    	int io = Integer.parseInt(args[0]);
    	int it = Integer.parseInt(args[1]);
    	int diff = Math.abs(io - it);
    	for(int i=diff ; i>=1 ; i--) {
    		prod = prod*i;
    		
    	}
    	System.out.println(prod);
    }
    else {
    	System.out.println("Error!");
    }
   
   }
}
