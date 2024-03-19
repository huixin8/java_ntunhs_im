package HW4;
import java.util.Scanner;
public class HW4{
	
	public static void main (String[]args) {
		String temp="";
		Scanner sc= new Scanner(System.in);
		System.out.println("這是可以陪你聊程式!你可以問我一些問題");
			while(true) {
			System.out.print("你說:");
			temp=sc.nextLine();
			
			String resultString =temp.replace("嗎","")
									.replace("?","!")
									.replace("會不會","會")
									.replace("能不能","能")
									.replace("你能","我能")
									.replace("你會","我會");
			System.out.println("我說:"+resultString);
			if (temp.equals("0")) {
				System.out.println("離開聊天程序");
				break;
			}
		}
	}
}