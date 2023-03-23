package sprint3evauation;

public class ThreadA extends Thread{
	private int num;
  @Override
	public void run() {
	  synchronized(this) {
		  int prod = 1;
			for(int i=1 ; i<=10 ; i++) {
				prod = prod *i;
			}
			this.num = prod;
			this.notify();
	  }
		
	}
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}
}
