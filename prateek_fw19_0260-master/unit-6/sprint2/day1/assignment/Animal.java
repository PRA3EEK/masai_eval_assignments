package day5Assignment;

public abstract class Animal {

	abstract void eat() throws AnimalException;
	
	public Animal() throws AnimalException{
		// TODO Auto-generated constructor stub
		AnimalException ae = new AnimalException();
		throw ae;
	}
}
