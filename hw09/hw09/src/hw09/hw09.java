package hw09;
import java.util.Scanner;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class hw09 {

public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

// TODO Auto-generated method stub

// �Ыؤ@��HashMap�Ӧs�x�ǥͦW�r�M���������Z

Map<String, Integer> grades = new HashMap<>();
int bool=1;
while(bool==1)
{
System.out.println("1 �K�[�ǥͪ����Z , 2 �d��S�w�ǥͪ����Z ,3 ��s�ǥͪ����Z ,4 �����ǥͦ��Z ,5 ���L�Ҧ��ǥͪ����Z ,6 ���} ");
int num =sc.nextInt();
switch (num) {

case 1:
	// �K�[�ǥͩM�L�̪����Z
	sc.nextLine();
	System.out.println("�K�[�ǥͪ����Z , �п�J�ǥͪ��m�W");	
	String Name =sc.nextLine();
	System.out.println("��J�ǥͪ����Z");
	int Grades =sc.nextInt();
	grades.put(Name,Grades);
	
	grades.put("Alice", 90);
	
	grades.put("Bob", 82);
	
	grades.put("Charlie", 88); 
	sc.nextLine();
	break;
case 2:	
	// �d��S�w�ǥͪ����Z
	sc.nextLine();
	System.out.println("�d��S�w�ǥͪ����Z , �п�J�ǥͪ��m�W");
	String studentName =sc.nextLine();
	if (grades.containsKey(studentName)) {
	
	System.out.println(studentName + "�����Z�O: " + grades.get(studentName));
	
	} else {
	
	System.out.println("�S�����" + studentName + "�����Z�C");
	
	}	
	break;
case 3:	 	
	// ��s�ǥͪ����Z
	sc.nextLine();
	System.out.println("��s�ǥͪ����Z , �п�J�ǥͪ��m�W");
	String name =sc.nextLine();
	System.out.println("��s�ǥͪ����Z , �п�J�ǥͪ����Z");
	int newgrade =sc.nextInt();
	
	grades.put(name, newgrade);
	
	System.out.println("��s��A"+name+"�����Z�O: " + grades.get(name)); 
	sc.nextLine();
	break;
case 4:	
	// �����@��ǥͪ��O��
	sc.nextLine();
	System.out.println("�����@��ǥͪ��O�� , �п�J�ǥͪ��m�W");
	String removename =sc.nextLine();
	grades.remove(removename);
	
	System.out.println("Bob�����Z�Q������A���Z�C���s��:");
	
	grades.forEach((key, value) -> System.out.println(key + ": " + value));
	break;
case 5:	
	//���L�Ҧ��ǥͪ����Z
	sc.nextLine();
	System.out.println("�ǥͦ��Z�C��:");
	
	for (Map.Entry<String, Integer> entry : grades.entrySet()) {
	
	System.out.println(entry.getKey() + ": " + entry.getValue());	
	}
	break;
case 6:
	System.out.println("���¨ϥ�");	
	bool=0;
	break;
}	
}
}

}

 