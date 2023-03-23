package sprint4Evaluation;

public class Student implements Comparable<Student>{
	private int rollNo;
	private String name;
	private double mathsMarks;
	private double scienceMarks;
	private double engMarks;
	public Student(int rollNo, String name, double mathsMarks, double scienceMarks, double engMarks) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.mathsMarks = mathsMarks;
		this.scienceMarks = scienceMarks;
		this.engMarks = engMarks;
	}
	
	public int getRollNo() {
		return rollNo;
	}
	
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getMathsMarks() {
		return mathsMarks;
	}
	
	public void setMathsMarks(double mathsMarks) {
		this.mathsMarks = mathsMarks;
	}
	
	public double getScienceMarks() {
		return scienceMarks;
	}
	
	public void setScienceMarks(double scienceMarks) {
		this.scienceMarks = scienceMarks;
	}
	
	public double getEngMarks() {
		return engMarks;
	}
	
	public void setEngMarks(double engMarks) {
		this.engMarks = engMarks;
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		if(this.engMarks+this.mathsMarks+this.scienceMarks > o.getEngMarks()+o.getMathsMarks()+o.getScienceMarks()) {
			return -1;
		}else if(this.engMarks+this.mathsMarks+this.scienceMarks <  o.getEngMarks()+o.getMathsMarks()+o.getScienceMarks()) {
			return +1;
		}else {
			if(this.name.compareTo(o.getName())>0) {
				return +1;
			}else if(this.name.compareTo(o.getName())<0) {
				return -1;
			}else {
				if(this.rollNo < o.getRollNo()) {
					return -1;
				}else if(this.rollNo > o.getRollNo()) {
					return +1;
				}else {
					return 0;
				}
			}
		}
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", mathsMarks=" + mathsMarks + ", scienceMarks="
				+ scienceMarks + ", engMarks=" + engMarks +"]";
	}

	
	
}
