package day9Assignment;

class Common {
	   
    public synchronized void count() {
     for(int i=1 ; i<=10 ; i++) {
     System.out.println(i);
    }
   
  }
}
