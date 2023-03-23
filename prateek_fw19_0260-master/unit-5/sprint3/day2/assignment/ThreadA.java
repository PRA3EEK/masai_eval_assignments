package day9Assignment;

class ThreadA extends Thread{
    Common c;
    
    public ThreadA (Common a) {
     this.c = a;    
    }
    
    public void run () {
       c.count();
    }
   
   }