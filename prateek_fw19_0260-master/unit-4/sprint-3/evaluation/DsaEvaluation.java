package sprint3Evaluation;

public class DsaEvaluation extends Evaluation{
	public DsaEvaluation(int num) {
		super(num);
		// TODO Auto-generated constructor stub
		
	}
	@Override
	public void evaluationTiming() {
		System.out.println("It is a DSA Evaluation");
		System.out.println("Evaluation timing is 9:30 to 11:00");
	}
 @Override
 public void setNOfQ (int num) {
	Evaluation dsa = new DsaEvaluation(num);
	dsa.setNOfQ(num);
 }
}

