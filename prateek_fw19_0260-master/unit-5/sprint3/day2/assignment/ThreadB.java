package day9Assignment;

class ThreadB extends Thread{
     Common c;
	
    
    public ThreadB (Common a) {
     this.c = a;  
    }
    
    public void run () {
       c.count();
    }
   
   }
