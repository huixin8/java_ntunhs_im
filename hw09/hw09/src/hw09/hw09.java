package hw09;
import java.util.Scanner;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class hw09 {

public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

// TODO Auto-generated method stub

// 創建一個HashMap來存儲學生名字和對應的成績

Map<String, Integer> grades = new HashMap<>();
int bool=1;
while(bool==1)
{
System.out.println("1 添加學生的成績 , 2 查找特定學生的成績 ,3 更新學生的成績 ,4 移除學生成績 ,5 打印所有學生的成績 ,6 離開 ");
int num =sc.nextInt();
switch (num) {

case 1:
	// 添加學生和他們的成績
	sc.nextLine();
	System.out.println("添加學生的成績 , 請輸入學生的姓名");	
	String Name =sc.nextLine();
	System.out.println("輸入學生的成績");
	int Grades =sc.nextInt();
	grades.put(Name,Grades);
	
	grades.put("Alice", 90);
	
	grades.put("Bob", 82);
	
	grades.put("Charlie", 88); 
	sc.nextLine();
	break;
case 2:	
	// 查找特定學生的成績
	sc.nextLine();
	System.out.println("查找特定學生的成績 , 請輸入學生的姓名");
	String studentName =sc.nextLine();
	if (grades.containsKey(studentName)) {
	
	System.out.println(studentName + "的成績是: " + grades.get(studentName));
	
	} else {
	
	System.out.println("沒有找到" + studentName + "的成績。");
	
	}	
	break;
case 3:	 	
	// 更新學生的成績
	sc.nextLine();
	System.out.println("更新學生的成績 , 請輸入學生的姓名");
	String name =sc.nextLine();
	System.out.println("更新學生的成績 , 請輸入學生的成績");
	int newgrade =sc.nextInt();
	
	grades.put(name, newgrade);
	
	System.out.println("更新後，"+name+"的成績是: " + grades.get(name)); 
	sc.nextLine();
	break;
case 4:	
	// 移除一位學生的記錄
	sc.nextLine();
	System.out.println("移除一位學生的記錄 , 請輸入學生的姓名");
	String removename =sc.nextLine();
	grades.remove(removename);
	
	System.out.println("Bob的成績被移除後，成績列表更新為:");
	
	grades.forEach((key, value) -> System.out.println(key + ": " + value));
	break;
case 5:	
	//打印所有學生的成績
	sc.nextLine();
	System.out.println("學生成績列表:");
	
	for (Map.Entry<String, Integer> entry : grades.entrySet()) {
	
	System.out.println(entry.getKey() + ": " + entry.getValue());	
	}
	break;
case 6:
	System.out.println("謝謝使用");	
	bool=0;
	break;
}	
}
}

}

 