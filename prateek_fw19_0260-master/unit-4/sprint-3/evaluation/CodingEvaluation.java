package sprint3Evaluation;

public class CodingEvaluation extends Evaluation{
	@Override
  public void evaluationTiming() {
		System.out.println("It is a Coding Evaluation");
	  System.out.println("Evaluation timing is 2:00 to 3:30");
  }
	 @Override
	 public void setNOfQ (int num) {
		Evaluation code = new CodingEvaluation(num);
		code.setNOfQ(num);
	 }
	 public CodingEvaluation(int num) {
		 super(num);
		 
	 }
}
