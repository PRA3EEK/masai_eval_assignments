package sprint3Evaluation;

public class CommerceStudent implements Question6Student{
	private int accountMarks;
	private int economicsMarks;
	private int businessStudiesMarks;
	
	
	
	@Override
	public double findPercentage() {
		double sum = this.accountMarks + this.economicsMarks + this.businessStudiesMarks;
		return (sum/300)*100;
	}
	
	
	
	
	public int getAccountMarks() {
		return accountMarks;
	}
	public void setAccountMarks(int accountMarks) {
		this.accountMarks = accountMarks;
	}
	public int getEconomicsMarks() {
		return economicsMarks;
	}
	public void setEconomicsMarks(int economicsMarks) {
		this.economicsMarks = economicsMarks;
	}
	public int getBusinessStudiesMarks() {
		return businessStudiesMarks;
	}
	public void setBusinessStudiesMarks(int businessStudiesMarks) {
		this.businessStudiesMarks = businessStudiesMarks;
	}
	public CommerceStudent(int accountMarks, int economicsMarks, int businessStudiesMarks) {
		super();
		this.accountMarks = accountMarks;
		this.economicsMarks = economicsMarks;
		this.businessStudiesMarks = businessStudiesMarks;
	}
	public CommerceStudent() {
		
	}
}
