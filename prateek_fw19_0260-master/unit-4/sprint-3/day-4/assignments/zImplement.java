package day12Assignmnet;

public class zImplement implements Z{

	@Override
	public void funcX1() {
		// TODO Auto-generated method stub
		System.out.println("inside the function of z of interface X");
	}

	@Override
	public void funcY1() {
		// TODO Auto-generated method stub
		System.out.println("inside the function of z of interface Y");
	}

	@Override
	public void func1Z() {
		// TODO Auto-generated method stub
		System.out.println("inside the function of z of interface Z");
	}
   @Override
   public void funcXD() {
	    System.out.println("overrided the default method from zImplement in X interface");
   }
}
