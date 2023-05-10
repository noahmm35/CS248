// Noah Monroe
//CS248-01
// Jan. 21, 2022

import java.io.*;
import java.util.*;

class ESP
{
	static void maxMinAvg (int [] W)
	{
		int max=W[0], min=W[0];
		double avg=0;
		
		for (int i=0; i<W.length; i++)
		{
			if (W[i]>max)
			{
				max=W[i];
			}
			else if (W[i]<min)
			{
				min=W[i];
			}
			avg = avg+W[i];
		}
		avg=avg / (W.length);
		
		System.out.println("Maximum Score: "+max+"\n"+"Minimum score: "+min+"\n"+"Average Score: "+avg+"\n");
	}
	
	public static void main (String [] args)
		throws IOException
	{
		Scanner cin=new Scanner(System.in); //allows input from user
		
		System.out.println("**Welcome to the Exam Stats Program**");
		System.out.println("Please enter the name of your data file: ");
		
		String fileName;
		fileName=cin.next(); //reads in file name
		
		Scanner file=new Scanner(new FileReader(fileName)); //opens the user file
		int numscores=file.nextInt(); //reads in # of exams in file
		int [] examscores=new int[numscores]; // reads in actual scores
		
		for (int i=0; i<numscores; i++)
			examscores[i]=file.nextInt();
		
		System.out.println("\n");
		
		maxMinAvg(examscores); //Calling function for max,min,average
	
		//Sorting into grade 'buckets'
			int a=0, b=0, c=0, d=0, f=0, j=0;
			
			do
			{
				if (examscores[j]>=90)
				{
					a++;
				}
				else if (examscores[j]>=80 && examscores[j]<90)
				{
					b++;
				}
				else if (examscores[j]>=70 && examscores[j]<80)
				{
					c++; //haha get it??
				}
				else if (examscores[j]>=60 && examscores[j]<70)
				{
					d++;
				}
				else if (examscores[j]<60)
				{
					f++;
				}
				
				j++;
					
			} while (j<numscores);
			
			System.out.println("Number of scores by letter grade: ");
			System.out.println("A: "+a+"\n"+"B: "+b+"\n"+"C: "+c+"\n"+"D: "+d+"\n"+"F: "+f+"\n");
			System.out.println("There are "+numscores+" scores.");
	}
}