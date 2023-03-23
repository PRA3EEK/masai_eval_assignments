package day6Assignment;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class College {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int collegeId;
	private String collegeName;
	private String collegeAdrress;
	@OneToMany(mappedBy = "coll", cascade = CascadeType.ALL)
	private List<Student> studentList = new ArrayList<>();
	public int getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getCollegeAdrress() {
		return collegeAdrress;
	}
	public void setCollegeAdrress(String collegeAdrress) {
		this.collegeAdrress = collegeAdrress;
	}
	public List<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	@Override
	public String toString() {
		return "College [collegeId=" + collegeId + ", collegeName=" + collegeName + ", collegeAdrress=" + collegeAdrress
				+ ", studentList=" + studentList + "]";
	}
	
	
	
}
