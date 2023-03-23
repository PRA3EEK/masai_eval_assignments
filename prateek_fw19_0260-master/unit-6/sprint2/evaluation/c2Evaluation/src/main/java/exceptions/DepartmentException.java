package exceptions;

public class DepartmentException extends Exception{
	
	private String message;
	
	public DepartmentException(String m) {
		
		this.message = m;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
