package extraAssignment;

public class IPL {

	public static void homeTeamStadium(Stadium stadium) {
	
		if(stadium.equals(Stadium.EDEN_GARDENS_STADIUM)) {
			System.out.println("This is the home ground of KKR");
		}else if(stadium.equals(Stadium.WANKHEDE_STADIUM)) {
			System.out.println("This is the home ground of Mumbai Indians");
		}else if(stadium.equals(Stadium.CHIDAMBARAM_STADIUM)) {
			System.out.println("This is the home ground of CSK");
		}
		else if(stadium.equals(Stadium.M_CHINNASWAMY_STADIUM)) {
			System.out.println("This is the home ground of RCB");
		}
	}
	
	
	public static void main(String[] args) {
		
		Stadium[] s = Stadium.values();
		
		for(Stadium a:s) {
			homeTeamStadium(a);
		}
		
	}
	
}
