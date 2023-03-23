package day11Assignment;

public class Ola {
	public Car bookCar(int numberOfPassenger, int numberOfKMs) {
		if(numberOfPassenger<=3) {
			Car C = new HatchBack();
			C.setNumberOfPassenger(numberOfPassenger);
			C.setNumberOfKms(numberOfKMs);
			return C;
		}else {
			Car C = new Sedan();
			C.setNumberOfPassenger(numberOfPassenger);
			C.setNumberOfKms(numberOfKMs);
			
			return C;
		}
	}
	public int calculateBill(Car car) {
		if(car.getNumberOfPassenger()<=3) {
			HatchBack Hc = (HatchBack)car;
			int total = Hc.getNumberOfKms() * Hc.farePerKm;
			return total;
		}else {
			Sedan Sc = (Sedan)car;
			int total = Sc.getNumberOfKms() * Sc.farePerKm;
			return total;
		}
      
	}

}
