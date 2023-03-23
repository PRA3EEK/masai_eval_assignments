package com.prateek;

public class Demo {
    public static void main(String[] args) {
    	String city = "Delhi";
    	switch(city) {
    	case  "Mumbai" :
    	    System.out.println("Financial City");
    	    break;
    	case "Kolkata":
            System.out.println("City of joy");
            break;
    	case "Delhi":
    	    System.out.println("Capital of the country");
    	    break;
    	case "Bangalore":
    	    System.out.println("Cyber city");
    	    break;
    	default:
    		System.out.println("Some other Indian city");
    		break;
    	}
    }
}
