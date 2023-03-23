package day12Assignmnet;

public class Test implements Intr{
	public int[] display(int p) {
		int[] arr = new int[p-2];
		int start = 2;
		int i = 0;
		while(start<=p) {
			int count = 0;
			for(int j=2 ; j<start ; j++) {
				if(start%j==0) {
					count++;
				}
			}
			if(count==0) {
				arr[i] = start;
				i++;
			}
			start++;
		}
		return arr;
	}
}
