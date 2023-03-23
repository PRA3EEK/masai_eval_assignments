package day12Assignmnet;

public interface Y {
	 public void funcY1();
	  public default void funcYD () {
		  System.out.println("inside default function of interface Y");
	  }
	  public static void funcYS () {
		  System.out.println("inside static function of interface Y");
	  }
}
