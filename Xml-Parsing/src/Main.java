import java.io.File;
import java.util.Scanner;

public class Main {

	static Parse pr=new Parse();
	static Create cr=new Create();
	static File file=new File("C:\\Users\\myke\\eclipse-workspace\\Xml-Parsing\\file.xml");
	
	public static void main(String[] args) {
	
		pr.ParseMethod("C:\\Users\\myke\\eclipse-workspace\\Xml-Parsing\\file.xml");
		Menu();
		
	}

	
	
	public static void Menu()
	{
		System.out.println("---Welcome The Bank Menu---");
		System.out.println("1)Show All Members");
		System.out.println("2)Change Balance");
		System.out.println("3)Save and Quit");
		System.out.print("Choose Please:");
		Scanner sc=new Scanner(System.in);
		int number=sc.nextInt();
		Section(number);
	}
	
	
	public static void Section(int number)
	{
		
		
		if(number==1)
		{
			System.out.println("------List of Members-------");
			pr.ShowArray();
			System.out.println("----------------------------");
			Menu();
		}
		else if(number==2)
		{
			//Here update the user balance
			
			System.out.print("Please give a ID for update to user balance:");
			Scanner sc=new Scanner(System.in);
			String ID=sc.next();
			int position=pr.findUserByID(ID);
			System.out.println();
			System.out.print("Enter New Account:");
			Scanner scnew=new Scanner(System.in);
			String balance=scnew.next();
			pr.UpdateBalance(balance);
			pr.Update(position);
			
			System.out.println("Balance Updated....");
			
			pr.ShowArray();
			Menu();
			
		}
		else if(number==3)
		{
			file.delete();
			cr.CreateAndSave(pr.array);
			System.out.println("All things Saved");
		}
		else
		{
			System.out.println("----------------------------");
			System.out.println("Wrong Choice Please Choice Again");
			System.out.println("----------------------------");
			Menu();
		}
	}
}
