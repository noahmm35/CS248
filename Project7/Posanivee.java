import java.io.*;
import java.util.*;

class Posanivee
{
	public static void main (String [] args)
	throws IOException
	{
		System.out.println("Welcome to Camp Posanivee!!");
		System.out.println();
		
		Scanner file =new Scanner(new FileReader("camp.txt"));
		char letter = file.next().charAt(0);
		
		BST B= new BST();
		
		while (letter != 'Q')
		{
			String name;
			int age;
			char diet='A';
			
			System.out.print("Command: ");
			
			if(letter == 'H' || letter == 'h')
			{
				System.out.println("Here is a list of commands: ");
				System.out.println();
				System.out.println("H: Prints list of commands");
				System.out.println("E <name> <age> <sex>: Enroll a new camper");
				System.out.println("W <name>: Withdraw a camper");
				System.out.println("D <>: Display age and diet of camper");
				System.out.println("A: Print the average age of campers");
				System.out.println("L: List all campers in alphabetical order");
				System.out.println("V: Print the number of vegan campers");
				System.out.println("P: List camper names in preorder");
				System.out.println("Q: Quit");
				System.out.println();
			}
			if(letter == 'E' || letter == 'e') // enroll
			{
				name=file.next();
				age=file.nextInt();
				diet = file.next().charAt(0);
				
				Camper c= new Camper(name, age, diet);
				B.insert(c);
				
				System.out.println("E "+c);
				System.out.println("New Camper added.");
				System.out.println();
			}
			if(letter == 'W' || letter == 'w') // withdraw
			{
				name=file.next();
				
				System.out.println("W "+name);
				Camper key= new Camper(name,0,'A'); //LOOOK 
				Camper answer=(Camper)B.lookup(key);
				
				if (answer!=null)
				{
					B.delete(answer);
					System.out.println("Camper withdrawn.");
				}
				else
					System.out.println("Camper not found.");
				System.out.println();			
			}
			if(letter == 'D' || letter == 'd') // display age + diet of camper
			{
				String n=file.next();
				
				System.out.println("D "+n);
				Camper key= new Camper(n,28,'A'); //LOOOOK
				Camper answer=(Camper)B.lookup((Comparable) key);
				
				if (answer!=null)
				{
					System.out.println("Name: "+answer.getname());
					System.out.println("Age: "+answer.getage());
					System.out.println("Diet: "+answer.getdiet());
				}
				else
					System.out.println("Camper not found.");
				System.out.println();
			}
			if(letter == 'A' || letter == 'a') // print average age of campers
			{
				int count=0, total=0;
				double average=0;
				
				System.out.println("A");
				if (B.size()!=0)
				{
					count=B.size();
					
					while(B.hasNext())
					{
						System.out.println("something is here");
					}
					
					average=total/count;
				
					System.out.println("Average age= "+average);
					System.out.println();
				}
				else
				{
					System.out.println("There are no campers.");
					System.out.println();
				}
			}
			if(letter == 'L' || letter == 'l') // list campers alphabetically
			{
				System.out.println("L");
				System.out.println("Alphabetical list of campers: ");
				B.reset(BST.IN);
				while(B.hasNext())
					System.out.println(B.getNext());
				System.out.println();
			}
			if(letter == 'V' || letter == 'v') // print vegan campers
			{
				System.out.print("V");
			}
			if(letter == 'P' || letter == 'p') // print campers in preorder
			{
				System.out.println("Preorder Traversal: ");
				B.reset(BST.PRE);
				while(B.hasNext())
					System.out.println(B.getNext());
				System.out.println();
			}
			
			letter = file.next().charAt(0);
		}
		
		System.out.println("End of Program.");
	}
}