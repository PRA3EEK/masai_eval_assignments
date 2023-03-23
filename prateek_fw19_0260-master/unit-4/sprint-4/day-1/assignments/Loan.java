package day13Assignment;

public class Loan {
	public double calculateLoanAmount(Employee employeeObj) {
		if(employeeObj instanceof PermenantEmployee) {
			PermenantEmployee PE = (PermenantEmployee)employeeObj;
			PE.calculateSalary();
			double loan = (15 * PE.salary)/100;
			return loan;
		}else if(employeeObj instanceof TemporaryEmployee) {
			TemporaryEmployee TE =  (TemporaryEmployee)employeeObj;
			TE.calculateSalary();
			double loan = (10 * TE.salary)/100;
			return loan;
		}
		return 0;
	}
   private Loan() {
	   
   }
   public static Loan getLoanObject () {
	   return new Loan();
   }
}
