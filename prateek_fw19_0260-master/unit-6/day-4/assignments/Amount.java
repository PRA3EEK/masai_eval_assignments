package day4Assignment;

public class Amount {
   
	private String accountNumber;
	private double balance;
	
	public Amount(String accountNumber, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void deposite(double amount) {
		this.balance = this.balance + amount;
	}
	public Amount() {
		// TODO Auto-generated constructor stub
	}
	public double withdraw (double amount) throws InsuficientFundException{
		if(amount>balance) {
			InsuficientFundException ife = new InsuficientFundException();
			throw ife;
		}else {
			this.balance = this.balance - amount;
			return amount;
		}
	}
}
