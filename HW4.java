package HW4;
import java.util.Scanner;
public class HW4{
	
	public static void main (String[]args) {
		String temp="";
		Scanner sc= new Scanner(System.in);
		System.out.println("�o�O�i�H���A��{��!�A�i�H�ݧڤ@�ǰ��D");
			while(true) {
			System.out.print("�A��:");
			temp=sc.nextLine();
			
			String resultString =temp.replace("��","")
									.replace("?","!")
									.replace("�|���|","�|")
									.replace("�ण��","��")
									.replace("�A��","�گ�")
									.replace("�A�|","�ڷ|");
			System.out.println("�ڻ�:"+resultString);
			if (temp.equals("0")) {
				System.out.println("���}��ѵ{��");
				break;
			}
		}
	}
}