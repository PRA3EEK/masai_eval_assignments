package day8Assignment;
import java.util.Scanner;
public class EvenSumsINColumn {
   
   public static void Arr (int row, int col, int[][] A) {
	 
	   
	   for(int i=0 ; i<col ; i++) {
		   int sum = 0;
		   for(int j=0 ; j<row ; j++) {
			  if(A[j][i] % 2 == 0) {
				  sum = sum + A[j][i];
			  }
		   }
		   System.out.println(sum);
	   }
   }
   
   public static void main (String[] args) {
	   Scanner sc = new Scanner (System.in);
	   System.out.println("Enter the number of rows");
	   int rows = sc.nextInt();
	   System.out.println("Enter number of columns");
	   int col = sc.nextInt();
	   int[][] A = new int[rows][col];
	   for(int i=0 ; i<rows ; i++) {
		   for(int j=0 ; j<col ; j++) {
			   System.out.println("Enter "+(j+1)+"th element of row "+(i+1));
			   int a = sc.nextInt();
			   A[i][j] = a;
		   }
	   }
	   Arr(rows, col, A);
   }
}
