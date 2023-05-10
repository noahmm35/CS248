// Noah Monroe
//CS248-01
// Feb. 25, 2022

import java.io.*;
import java.util.*;

class LM_Main 
{
		
	public static void main (String [] args) throws IOException
	{
		int KB=0, PA1=0, PA2=0, B1=0, B2=0;
		
		Scanner file = new Scanner(new FileReader("rooms.txt")); 
		
		int numRooms=file.nextInt();
		LMRooms[] Mansion= new LMRooms[numRooms];
		
		for (int i=0; i<numRooms; i++) //reads in data file
		{
			Mansion[i] = new LMRooms(file);
		}
		
		KB = (int)(1+9*Math.random()); //25-48 places hazards without repeating rooms or being in room 1
		do
		{
			PA1 = (int)(1+9*Math.random());
				
		} while (PA1==KB);
		
		do
		{
			PA2 = (int)(1+9*Math.random());
			
		} while (PA2==KB || PA2==PA1);
		
		do
		{
			B1 = (int)(1+9*Math.random());
			
		} while (B1==KB || B1==PA1 || B1==PA2);
		
		do
		{
			B2 = (int)(1+9*Math.random());
			
		} while(B2==KB || B2==PA1 || B2==PA2 || B2==B1);
		
		//Intro paragraph thingy
		System.out.println(" ");
		System.out.println("Welcome to the Haunted Mansion!");
		System.out.println("Thank you for agreeing to help stop the tyrannical King Boo.");
		System.out.println("I'm sure E. Gadd already got you up to speed and equipped you with the Poltergust 3000,");
		System.out.println("The Poltergust 3000 only has 3 charges before the battery is depleted so use them wisely.");
		System.out.println("The Poltergust 3000 is the only thing that can irradicate King Boo, Good Luck!");
		
		int pos=0, charges=3, room=1, attempt;
		String choice;
		
		while (charges != 0)
		{
			Scanner cin=new Scanner(System.in);
			
			System.out.println("You are in room "+room+".");
			System.out.println("You have "+charges+" charges left.");
			System.out.println(Mansion[pos].getD());
			System.out.println("There are doors that lead to rooms "+Mansion[pos].getA1()+", "+Mansion[pos].getA2()+", and "+Mansion[pos].getA3()+".");
			
			if (Mansion[pos].isAdjacent(KB)==KB)
			{
				System.out.println("You hear the cackle of King Boo nearby...");
			}
			if (Mansion[pos].isAdjacent(PA1)==PA1)
			{
				System.out.println("You hear the clashing of armor closeby...");
			}
			if (Mansion[pos].isAdjacent(PA2)==PA2)
			{
				System.out.println("You hear the clashing of armor closeby...");
			}
			if (Mansion[pos].isAdjacent(B1)==B1)
			{
				System.out.println("A faint squeak can be heard in the distance...");
			}
			if (Mansion[pos].isAdjacent(B2)==B2)
			{
				System.out.println("A faint squeak can be heard in the distance...");
			}
			
			System.out.println("(M)ove or (S)hoot");
			choice=cin.next();
			
			if (choice.equals("M") || choice.equals("m"))
			{
				System.out.println("To which room?");
				room=cin.nextInt();
				
				while (room!=Mansion[pos].getA1() && room!=Mansion[pos].getA2() && room!=Mansion[pos].getA3())
				{
					System.out.println("Silly Goose! You cannot get there from here!");
					System.out.println("There are doors that lead to rooms "+Mansion[pos].getA1()+", "+Mansion[pos].getA2()+", and "+Mansion[pos].getA3()+".");
			
					System.out.println("(M)ove or (S)hoot");
					choice=cin.next();
					
					System.out.println("To which room?");
					room=cin.nextInt();
				}
				
				if (room == KB)
				{
					System.out.println("You trip and fall right in front of King Boo... there ain't no coming back from that. GAME OVER!");
					System.exit(0);
				}
				else if (room == PA1 || room == PA2)
				{
					System.out.println("A suit of possessed armor was waiting for you at the door... you have been impaled. GAME OVER!");
					System.exit(0);
				}
				else if (room == B1 || room == B2)
				{
					System.out.println("You are attacked by an angry swarm of bats, they drain the blood from your body... GAME OVER!");
					System.exit(0);
				}
				else 
				{
					//empty
				}
				
				pos=room-1;
				System.out.println(" ");
			}
			else if (choice.equals("S") || choice.equals("s"))
			{
				System.out.println("To which room?");
				attempt=cin.nextInt();
				
				if (attempt!=Mansion[pos].getA1() && attempt!=Mansion[pos].getA2() && attempt!=Mansion[pos].getA3())
				{
					System.out.println("You wasted a charge trying to vacuum the wall...");
					System.out.println(" ");
				}
				
				if (attempt == KB)
				{
					System.out.println("You successfully captured King Boo, YOU WIN!");
					System.exit(0);
				}
				
				charges=charges-1;
			}
			else
			{
				System.out.println("Invalid Option! Try Again!");
				System.out.println(" ");
			}
	
		} 
		
		System.out.println("Game over! You ran out of poltergust charges and are not able to complete your quest!");
		
	} 
}