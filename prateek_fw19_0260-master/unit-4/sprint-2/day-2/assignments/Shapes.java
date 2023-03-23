package sprint2day2assignment;

public class Shapes {
  public void area(Circle circle) {
	  double area = (circle.radius*circle.radius)*(3.14159);
	  System.out.println(area);
  }
public void area(Rectangle rectangle) {
	  int area = rectangle.length*rectangle.breadth;
	  System.out.println(area);
  }
public void area(Square square) {
	  int area = square.side*square.side;
	  System.out.println(area);
}
}
