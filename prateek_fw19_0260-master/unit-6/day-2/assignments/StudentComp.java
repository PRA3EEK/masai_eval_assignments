package day2Assignment;

import java.util.Comparator;

public class StudentComp implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		if(o1.getMarks()>o2.getMarks()) {
			return +1;
		}else if(o1.getMarks() < o2.getMarks()) {
			return -1;
		}else {
			return 0;
		}
	}

}