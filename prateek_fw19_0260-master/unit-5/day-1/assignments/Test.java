package day1Assignment;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Test {
  public static void main(String[] args) {
	Queue<Integer> q = new PriorityQueue<>();
	q.offer(26);
	q.offer(29);
	q.offer(27);
	q.offer(28);
	q.offer(25);
	Iterator i = q.iterator();
	while(q.size()!=0) {
		System.out.println(q.poll());
	}
}
}
