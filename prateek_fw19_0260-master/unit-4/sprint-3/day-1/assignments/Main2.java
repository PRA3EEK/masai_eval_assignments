package day8Assignment;

public class Main2 {
	   public int[] findAndReturnPrimeNumbers(int[] inputArray){
		//write the logic to iterate through the supplied inputArray and return array of prime
//		numbers
		//if no prime number is found then return the empty array.
		   int[] primeArr = new int[inputArray.length];
		   int index = 0;
		   for(int i=0 ; i<inputArray.length ; i++) {
			   int count = 0;
			   for(int j=2 ; j<inputArray[i] ; j++) {
				  
				   if(inputArray[i]%j == 0) {
					   count++;
				   }
			   }
			   if(count == 0) {
				   
				   primeArr[index] = inputArray[i];
				   index++;
			   }
		   }
		 
			   return primeArr;
		   
		}
	public static void main(String[] args){
		//Create the object of Main class
		//on the object of Main class call the findAndReturnPrimeNumbers method
		//by supplying the following array as the parameter
		int[] arr = {4,6,9,8,10,12,16};
		Main2 objmain = new Main2();
		int[] primeArr = objmain.findAndReturnPrimeNumbers(arr);
		//print each element from the returned array of findAndReturnPrimeNumbers method
		//if findAndReturnPrimeNumbers method returns an empty array then print the following
//		message:
		// "Prime number not found in the supplied Array"
		if(primeArr[0]!=0) {
			for(int i=0 ; i<primeArr.length ; i++) {
				if(primeArr[i]!=0) {
					System.out.print(primeArr[i]+" ");
				}
			 }
		}else{
			System.out.println("No prime number is present in the given array");
		}
		 
		}
}
