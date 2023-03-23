package sprint2day2assignment;
  

public class CheckVowel {
	char alpha;
	
	void Check () {
	switch(this.alpha){
	case('a'):
	case('e'):
	case('i'):
	case('o'):
	case('u'):
	case('A'):
	case('E'):
	case('I'):
	case('O'):
	case('U'):
		System.out.println("Vowel");
	break;
	case('b'):
	case('c'):
	case('f'):
	case('g'):
	case('h'):
	case('j'):
	case('k'):
	case('l'):
	case('m'):
	case('n'):
	case('p'):
	case('q'):
	case('r'):
	case('s'):
	case('t'):
	case('v'):
	case('w'):
	case('x'):
	case('y'):
	case('z'):
	case('B'):
	case('C'):
	case('F'):
	case('G'):
	case('H'):
	case('J'):
	case('K'):
	case('L'):
	case('M'):
	case('N'):
	case('P'):
	case('Q'):
	case('R'):
	case('S'):
	case('T'):
	case('V'):
	case('W'):
	case('X'):
	case('Y'):
	case('Z'):
		System.out.println("Consonant");
	break;
	default:
		System.out.println("Error!");
	}
	}
	public static void main (String[] args) {
	 CheckVowel C = new CheckVowel();
	 C.alpha = 'z';
	 C.Check();
	 
	}
}
