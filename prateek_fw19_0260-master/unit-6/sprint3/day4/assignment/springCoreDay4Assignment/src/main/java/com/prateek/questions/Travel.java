package com.prateek.questions;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


@Service
@Scope("prototype")
public class Travel {

	
	
	//it is the dependency (object type)
	@Autowired
	Vehicle v;
	//simple type
	
	@Value("${NOF}")
	int numberOFPerson;
	//constructor injection point..
	
	@PostConstruct
	public void constructMethod () {
		
		System.out.println("Object has been created...");
	}
	
	
	@PreDestroy
	public void destryMethod() {
		
		System.out.println("Object has been destroyed...");
		
	}
	    
//	public Travel(Vehicle v, int numberOFPerson) {
//	
//	    	this.v = v;
//	
//	    	this.numberOFPerson = numberOFPerson;
//	
//    }
	
	
	public void journey() {
	     
		 v.go();
	
	     System.out.println("Jounrney started...");
	
	     System.out.println("number of person are :"+numberOFPerson);
	}
}
