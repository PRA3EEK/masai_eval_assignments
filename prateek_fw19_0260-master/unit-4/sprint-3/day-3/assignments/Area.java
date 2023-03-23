package day11Assignment;

public class Area extends Shape{
   @Override
   public int rectangleArea(int length, int breadth) {
	   int area = length*breadth;
	   return area;
   }
   @Override
   public double circleArea (int radius) {
	 double area = 3.141592653589793238*(radius*radius);
	 return area;
   }
   @Override
   public int squareArea (int side) {
	   int area = side*side;
	   return area;
   }
}
