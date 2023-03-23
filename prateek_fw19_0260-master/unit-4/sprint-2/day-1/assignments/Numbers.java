package sprint2day1assignment;

public class Numbers {
	int Number;
     void Check () {
    	   
    	      if((this.Number)%1==0 && this.Number<0) {
    	    	  System.out.println("Error");
    	      }
    	      else if((this.Number)%1==0 && this.Number%2!=0) {
      	    	double res = (this.Number);  
      		   System.out.println(Math.ceil(res/10)*10);
      	      }else if((this.Number)%1==0 && this.Number%2==0) {
      	    	  System.out.println(this.Number);
      	      }
     }
	public static void main(String[] args) {
      Numbers N1 = new Numbers();
      N1.Number=15;
      N1.Check();
	}

}
