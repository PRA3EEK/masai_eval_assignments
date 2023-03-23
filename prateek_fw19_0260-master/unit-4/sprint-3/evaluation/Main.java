package sprint3Evaluation;

public class Main {
public void changeArray (Object[] arr) {
	for(int i=0 ; i<arr.length ; i++) {
	    if(arr[i] instanceof new Student()) {
	    	System.out.println(arr[i].getMarks());
	    }else if(ar)
	}
}
public static void main(String[] args) {
	Object[] arr = {new Student(23, "rakesh", 450),new Employee(12, "Lokesh", 84000),"String",50};
	Main M = new Main();
	M.changeArray(arr);
}
}
