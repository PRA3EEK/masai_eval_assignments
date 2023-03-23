package com.prateek;

public class primefactorsofanumber {
   public static void main (String[] args) {
	    findprimefactors(24);
   }
   public static void findprimefactors (int num) {
	   for(int i=1 ; i<=num ; i++) {
		   if(num%i==0) {
			   System.out.println(i);
		   }
	   }
   }
}
