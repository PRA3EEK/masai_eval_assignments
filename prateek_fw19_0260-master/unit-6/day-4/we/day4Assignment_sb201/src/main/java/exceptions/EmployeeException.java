package exceptions;

public class EmployeeException extends Exception{
	
	private String message;
	
	public EmployeeException(String msg) {
		this.message = msg;
	}
	public String getMessage () {
		return message;
	}

}
