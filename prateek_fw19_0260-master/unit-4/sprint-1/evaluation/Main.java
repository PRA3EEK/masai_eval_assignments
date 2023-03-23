package javafirstevaluation;

public class Main {
	public static void runScored(int one, int two, int three, int four ,int six) {
		// write your logic here
		  int totalScore = (1*one) + (2*two) + (3*three) + (4*four) + (6*six);
		  System.out.println(totalScore);
		}
		public static void main(String[] args){
		//call runScored with valid parameters
			runScored(20,10,3,7,6);
		}
}
