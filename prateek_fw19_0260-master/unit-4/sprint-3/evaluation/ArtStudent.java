package sprint3Evaluation;

public class ArtStudent implements Question6Student{
	private int hindiMarks;
	private int englishMarks;
	private int historyMarks;
	
	
	@Override
	public double findPercentage() {
		double sum = this.hindiMarks + this.englishMarks + this.historyMarks;
		return (sum/300)*100;
	}
	
	
	
	
	public ArtStudent(int hindiMarks, int englishMarks, int historyMarks) {
		super();
		this.hindiMarks = hindiMarks;
		this.englishMarks = englishMarks;
		this.historyMarks = historyMarks;
	}
	public int getHindiMarks() {
		return hindiMarks;
	}
	public void setHindiMarks(int hindiMarks) {
		this.hindiMarks = hindiMarks;
	}
	public int getEnglishMarks() {
		return englishMarks;
	}
	public void setEnglishMarks(int englishMarks) {
		this.englishMarks = englishMarks;
	}
	public int getHistoryMarks() {
		return historyMarks;
	}
	public void setHistoryMarks(int historyMarks) {
		this.historyMarks = historyMarks;
	}
	public ArtStudent() {
		
	}
}
