package sprint2day2assignment;

public class CheckWeather {
   boolean isSnowing;
   boolean isRaining;
   double temprature;
   void check () {
	   if(isRaining || isSnowing || temprature<50) {
		   System.out.println("Let's stay home!");
	   }else {
		   System.out.println("Let's go out!");
	   }
   }
   public static void main(String[] args) {
	   CheckWeather CW = new CheckWeather();
	   CW.isSnowing = false;
	   CW.isRaining = false;
	   CW.temprature = 65;
	   CW.check();
   }
}
