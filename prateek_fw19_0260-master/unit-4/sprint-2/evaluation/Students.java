package sprint2evaluation;



public class Students {
    private int rollNumber;
    private String studentName;
    private int marks;
    
    
   public void setRollNumber(int rollNumber) {
	this.rollNumber = rollNumber;
   }
   
   public void setstudentName(String name) {
		this.studentName = name;
	   }
   
   public void setmarks(int marks) {
		this.marks = marks;
	   }
    
   public int getRollNumber() {
	return rollNumber;
    }
   
   public String getStudentName() {
	return studentName;
   }
   
   public int getMarks() {
	return marks;
   }
   
   public Students() {
	   
   }
   
   public Students (int rollNumber, String studentName, int marks) {
	   this.rollNumber = rollNumber;
	   this.studentName = studentName;
	   this.marks = marks;
   }
  
   
   
}
