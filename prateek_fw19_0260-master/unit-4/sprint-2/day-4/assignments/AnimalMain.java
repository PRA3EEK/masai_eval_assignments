package Day9Assignment;

public class AnimalMain {
  public static void main (String[] args) {
	  Animal[] A = new Animal[3];
	  Animal A1 = new Dog();
	  Animal A2 = new Cat();
	  Animal A3 = new Tiger();
	  A[0] = A1;
	  A[1] = A2;
	  A[2] = A3;
	  for(int i=0 ; i<A.length ; i++) {
		  A[i].makeNoise();
		  A[i].eat();
		  A[i].walk();
	  }
  }
}
