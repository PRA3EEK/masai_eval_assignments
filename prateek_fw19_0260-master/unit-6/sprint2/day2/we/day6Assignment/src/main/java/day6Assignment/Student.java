package day6Assignment;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int roll;
	private String name;
	private String mobileNumber;
	private String email;
	@ManyToOne(cascade = CascadeType.ALL)
	private College coll;
	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", mobileNumber=" + mobileNumber + ", email=" + email
				+ ", coll=" + coll + "]";
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public College getColl() {
		return coll;
	}
	public void setColl(College coll) {
		this.coll = coll;
	}
	
}
