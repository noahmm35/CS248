//Noah Monroe
//March 18, 2022
//Sorenson 11AM

import java.io.*;
import java.util.*;

class LaFood
{
	private class party
	{
		public Object party;
	}
	
	public static void main(String [] args)
	throws IOException
	{
		System.out.println("** Welcome to the La Food Restaurant Simulator **");
		
		String DF;
		int total=0, count=0;
		double average=0;
		
		Scanner cin=new Scanner(System.in); //Scanner to read in from text file from user
		System.out.print("Please enter data file name: ");
		DF = cin.next();
		
		Scanner file=new Scanner(new FileReader(DF));
		char letter = file.next().charAt(0);
		System.out.println();
		
		QueueLL Q=new QueueLL(); //New Queue
		while (letter != 'Q') //Loops to read all of the file one at a time
		{
			int guestcount, time, time2, wait;
			String name;
			
			if (letter == 'A')
			{
				time = file.nextInt();
				guestcount = file.nextInt();
				name = file.nextLine();
				Party p=new Party(guestcount, time, name); //Party object, keeps the party info together
				
				System.out.println("Please wait at the bar,");
				System.out.println("   "+p+" (time = "+time+")");
				
				Q.enqueue(p); //Adds party to queue
				
			}
			else if (letter == 'T')
			{
				time2=file.nextInt();
				System.out.println("Table for "+Q.getFront()+" (time = "+time2+")");
				
				count++;
				wait = time2;
				total = total + wait;
				
				Q.dequeue(); //Removes from queue after they get their table
				
			}
			else
			{
				System.out.println("Well that isn't supposed to happen..."); //Contingency in case letter is not A or T
			}
			
			letter = file.next().charAt(0); //Reads in the next Character
		}
		
		average = total / count;
		
		System.out.println("** The simulation was terminated **");
		System.out.println();
		System.out.println("The average waiting time was: "+average);
		System.out.println("The following parties were never seated: ");
		
		while (Q.size()>0) //Shows parties that have not been sat
		{
			System.out.println("   "+Q.getFront());
			Q.dequeue(); //Remove from queue after party has been printed on screen
		}
		
		System.out.println();
		System.out.println("Have a nice meal!");
		System.out.println();
	}
}