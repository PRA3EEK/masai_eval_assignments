package exceptions;

public class EmployeeException extends Exception{
    
	private String message;
	
	public EmployeeException(String msg) {
		// TODO Auto-generated constructor stub
		this.message = msg;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
