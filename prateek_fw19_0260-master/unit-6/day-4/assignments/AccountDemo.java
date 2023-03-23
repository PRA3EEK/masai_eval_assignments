package day4Assignment;

public class AccountDemo {

	
	public static void main(String[] args) {
		Amount a = new Amount("2451368954785486", 500);
		a.deposite(500);
		try {
			System.out.println(a.withdraw(1200)+" has been debited from your account");
		}
		catch(InsuficientFundException e){
			System.out.println(e.message);
		}
		System.out.println("Your balanced amount is "+a.getBalance());
	}
}
