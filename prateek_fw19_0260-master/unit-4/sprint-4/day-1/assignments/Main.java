package day13Assignment;

public class Main {
   public static void main(String[] args) {
	 //Create a Loan object by name loan
	   Loan loan = Loan.getLoanObject();
	   double permanentEmployeeLoan = loan.calculateLoanAmount(new
	   PermenantEmployee(1,"Name1",1000));
	   double temporaryEmployeeLoan = loan.calculateLoanAmount(new
	   TemporaryEmployee(2,"Name2",20,100));
	   System.out.println("Loan Amount for Permanent Employee => "+permanentEmployeeLoan);
	   System.out.println("Loan Amount for Temporary Employee => "+temporaryEmployeeLoan);

}
} 
