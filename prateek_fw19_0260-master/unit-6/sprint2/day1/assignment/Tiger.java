package day5Assignment;

public class Tiger extends Animal{

	

	public Tiger() throws AnimalException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	void eat() throws AnimalException{
		// TODO Auto-generated method stub
		System.out.println("Tiger is eating!");
	}
   
	public static void main(String[] args) {
		try {
			Animal a = new Tiger();
			a.eat();
		}
		catch(AnimalException ae) {
			System.out.println(ae.message);
		}
		
		
	}
}
