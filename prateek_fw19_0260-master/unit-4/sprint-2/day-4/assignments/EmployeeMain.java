package Day9Assignment;

public class EmployeeMain {
   public static void main (String[] args) {
	   Employee E1 = new Employee();
	   E1.name = "prateek";
	   E1.age = 20;
	   E1.address = "Delhi";
	   E1.phoneNumber = "9315807215";
	   E1.salary = 20000;
	   Manager M = new Manager();
	   M.name = "pratham";
	   M.age = 21;
	   M.address = "Delhi";
	   M.phoneNumber = "9354041326";
	   M.salary = 25000;
	   System.out.println(E1.name);
	   System.out.println(E1.age);
	   System.out.println(E1.address);
	   System.out.println(E1.phoneNumber);
	   System.out.println(E1.salary);
	   System.out.println(E1.specialisation);
	   System.out.println(E1.Department);
	   System.out.println("================================");
	   System.out.println(M.name);
	   System.out.println(M.age);
	   System.out.println(M.address);
	   System.out.println(M.phoneNumber);
	   System.out.println(M.salary);
	   System.out.println(M.specialisation);
	   System.out.println(M.Department);
   }
}
