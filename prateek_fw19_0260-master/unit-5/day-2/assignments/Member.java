package day2Assignment;

public class Member {
  private int memberId;
  private String memberName;
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
public Member(int memberId, String memberName) {
	super();
	this.memberId = memberId;
	this.memberName = memberName;
}
  
  public Member() {
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Member [memberId=" + memberId + ", memberName=" + memberName + "]";
}
}
