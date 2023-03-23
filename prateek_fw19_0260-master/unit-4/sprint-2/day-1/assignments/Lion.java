package sprint2day1assignment;

public class Lion {
//	 String name;
//	 ● boolean isHungry;
//	 ● int age;
//	 ● static int totalDeaths;
//	 ● static printKillings() : void
//	 ● thinking() : void
  String name;
  boolean isHungry;
  int age;
  static int totalDeaths;
  static void printKillings() {
	  System.out.println("Total killings by lions in jungle = "+totalDeaths);
  };
  void thinking () {
	
	  if(this.isHungry == false) {
		  System.out.println(this.name+" is sleeping");
	  }else if(this.isHungry == true && this.age>=12) {
		  totalDeaths = totalDeaths + 2;
		  System.out.println(this.name +" has eaten two animal");
	  }
	  else if(this.isHungry==true && this.age>2 && this.age<=12) {
		  totalDeaths = totalDeaths + 1;
		  System.out.println(this.name+" has eaten one animal");
	  }
	  else if(this.isHungry==true && this.age<2) {
		  System.out.println(this.name+" is calling Mom");
	  }
  };
  public static void main (String[] args) {
	  Lion lion1 = new Lion();
	  lion1.name = "lion1";
	  lion1.isHungry = true;
	  lion1.age = 20;
        lion1.thinking();
        Lion lion2 = new Lion();
  	  lion2.name = "lion2";
  	  lion2.isHungry = true;
  	  lion2.age =10;
          lion2.thinking();
          Lion lion3 = new Lion();
    	  lion3.name = "lion3";
    	  lion3.isHungry = true;
    	  lion3.age = 1;
            lion3.thinking();
        printKillings();
  }
  
}
