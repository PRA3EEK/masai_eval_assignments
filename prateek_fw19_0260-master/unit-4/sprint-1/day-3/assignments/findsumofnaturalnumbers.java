package com.prateek;

public class findsumofnaturalnumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        findsum(5);
	}
    public static void findsum (int num) {
    	int sum = (num*(num+1))/2;
    	System.out.println(sum);
    }
}
