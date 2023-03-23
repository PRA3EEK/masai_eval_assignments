package day1Assignment;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Members implements Comparable<Members>{

	private int memberId;
	private String memberName;
	private int membershipNumber;
	private String membershipEnddate;
	public Members(int memberId, String memberName, int membershipNumber, String membershipEnddate) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.membershipNumber = membershipNumber;
		this.membershipEnddate = membershipEnddate;
	}
	
	public Members() {
		// TODO Auto-generated constructor stub
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getMembershipNumber() {
		return membershipNumber;
	}

	public void setMembershipNumber(int membershipNumber) {
		this.membershipNumber = membershipNumber;
	}

	public String getMembershipEnddate() {
		return membershipEnddate;
	}

	public void setMembershipEnddate(String membershipEnddate) {
		this.membershipEnddate = membershipEnddate;
	}
	@Override
	public boolean equals(Object o) {
		Members m = (Members)o;
		if( this.memberId==m.getMemberId() || this.membershipNumber == m.getMembershipNumber()) {
		return true;	
		}else {
			return false;
		}
	}
	@Override
	public int hashCode() {
		return 1;
	}
//	
//	public int compareTo(Members m) {
//		if(this.membershipEnddate)
//	}

	@Override
	public int compareTo(Members o) {
		// TODO Auto-generated method stub
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
	    LocalDate thisDate = LocalDate.parse(this.getMembershipEnddate(), df);
	    LocalDate passedDate = LocalDate.parse(o.getMembershipEnddate(), df);
	    LocalDate today = LocalDate.now();
	    
//	    Period p = Period.between(today, passedDate);
//	    Period p2 = Period.between(today, thisDate);
	    long daysBetween1;
	    long daysBetween2;
	    if(passedDate.isBefore(today)) {
	    	daysBetween1 = 0;
	    }else {
	    	 daysBetween1 = ChronoUnit.DAYS.between(today, passedDate);
	    }
	    
	    if(thisDate.isBefore(today)) {
	    	daysBetween2 = 0;
	    }else {
	    	 daysBetween2 = ChronoUnit.DAYS.between(today, thisDate);
	    }
	    
	    
	    if(daysBetween2 > daysBetween1) {
	    	return +1;
	    }else if(daysBetween2 < daysBetween1) {
	    	return -1;
	    }else {
	    	return 0;
	    }
	    
	}

	@Override
	public String toString() {
		return "Members [memberId=" + memberId + ", memberName=" + memberName + ", membershipNumber=" + membershipNumber
				+ ", membershipEnddate=" + membershipEnddate +"]";
	}
	
}
