package day8Assignment;

public class X extends Thread{
	@Override
public void run() {
	for(int i=0 ; i<20 ; i++) {
		int dig = i;
		System.out.println("inside run method "+(dig+1));
	}
}
	
public static void main(String[] args) {
	X x1 = new X();
//	System.out.println(x1);
	x1.start();
	for(int j=20 ; j<31 ; j++) {
		System.out.println("inside main method of X"+j);
	}
}
}
