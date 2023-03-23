package sprint3Evaluation;

public class MainEvaluation {
//	messageToStudents(Evaluation evaluation) : void
//	public static void main(String[] args);
	public void messageToStudents(Evaluation evaluation) {
	evaluation.printNoOfQuestions();
	evaluation.evaluationTiming();
	}
	public static void main(String[] args) {
		MainEvaluation ME = new MainEvaluation();
		ME.messageToStudents(new DsaEvaluation(5));
		ME.messageToStudents(new CodingEvaluation(4));

	}
}
