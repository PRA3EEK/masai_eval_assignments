package classes;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="emp")
public class Costumer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cid;
	private String name;
	private String mobileNumber;
	private String email;
	
	@ElementCollection
	@Embedded
	@JoinTable(name="emp_adr", joinColumns=@JoinColumn(name = "emp_id"))
	private List<Address> addresses = new ArrayList<>(); // Has-A relationship
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
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
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	
	public Costumer() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Costumer [cid=" + cid + ", name=" + name + ", mobileNumber=" + mobileNumber + ", email=" + email + "]";
	}
	public Costumer( String name, String mobileNumber, String email) {
		super();
		
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.email = email;
	}
	
}
