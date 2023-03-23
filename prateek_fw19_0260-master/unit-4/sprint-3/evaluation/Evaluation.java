package sprint3Evaluation;

public abstract class Evaluation {
	private final int numberOfQuestions;
	abstract void evaluationTiming();
	void printNoOfQuestions() {
	System.out.println("No. of Questions in Evaluation is :" +numberOfQuestions);
	}
	public Evaluation(int num) {
		this.numberOfQuestions = num;
	}
	abstract void setNOfQ (int num);
}
