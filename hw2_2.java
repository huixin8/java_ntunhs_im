package hw2_2;
import java.util.Scanner;
import java.util.Random;
public class hw2_2{
	public static void main (String[]args) {
		Random rand=new Random(10);
		int ans=rand.nextInt(100);
		int guess=0;
		int max=100;
		int min=1;
		Scanner sc= new Scanner(System.in);
		while(true) {
			System.out.print("Tell me a number:");
			guess=sc.nextInt();
			
			int validate_num=ans-guess;
			if(guess<min||guess>max) {
				System.out.println("Are you sure!");
			}
			else {if(validate_num>0) {
				System.out.println("Too small");
				min=guess;
			}else if(validate_num<0) {
				System.out.println("Too big");
				max=guess;
			}else {
				System.out.println("Bingo!");
				break;
			}
			}
		}
	}
}
