package day12Assignmnet;

public interface X {
  public void funcX1();
  public default void funcXD () {
	  System.out.println("inside default function of interface X");
  }
  public static void funcXS () {
	  System.out.println("inside static function of interface X");
  }
}
