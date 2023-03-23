package sprint3Evaluation;

public interface Vehicle {
 void run();
 public default void service () {
	 System.out.println("Car needs service");
 }
}
