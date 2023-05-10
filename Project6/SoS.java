import java.io.*;
import java.util.*;

class SoS
{
	public static void main (String [] args) throws IOException
	{
		int n, count=0;
		
		Scanner cin=new Scanner(System.in);
		System.out.print("Enter the size of the array to be sorted: ");
		
		n=cin.nextInt();
		
		Integer [] dc = new Integer [n];
		
		for(int i=0; i<dc.length; i++)
		{
			dc[i] = (int)(1+500*Math.random());
		}
		
		if (dc.length <= 100)
		{
			System.out.println("Unsorted list: ");
			for(int i=0; i<dc.length; i++)
			{
				System.out.print(dc[i]+" ");
			}
			System.out.println();
		}
		
		while (count != 5)
		{
			double time, time2, time3;
			time = System.currentTimeMillis();
			Integer [] a = new Integer [n];
			
			for (int i=0; i<a.length; i++)
			{
				a[i] = dc[i];
			}
			
			if(count==0)
			{
				Sorts.selection(a);
				
				if (a.length <= 100)
				{
					System.out.println("Selection sorted list: ");
					for(int i=0; i<a.length; i++)
					{
						System.out.print(a[i]+" ");
					}
					System.out.println();
				}
			}
			else if(count==1)
			{
				Sorts.bubble(a);
				
				if (a.length <= 100)
				{
					System.out.println("Bubble sorted list: ");
					for(int i=0; i<a.length; i++)
					{
						System.out.print(a[i]+" ");
					}
					System.out.println();
				}
			}
			else if(count==2)
			{
				Sorts.insertion(a);
				
				if (a.length <= 100)
				{
					System.out.println("Insertion sorted list: ");
					for(int i=0; i<a.length; i++)
					{
						System.out.print(a[i]+" ");
					}
					System.out.println();
				}
			}
			else if(count==3)
			{
				Sorts.quick(a);
				
				if (a.length <= 100)
				{
					System.out.println("Quick sorted list: ");
					for(int i=0; i<a.length; i++)
					{
						System.out.print(a[i]+" ");
					}
					System.out.println();
				}
			}
			else if(count==4)
			{
				Sorts.merge(a);
				
				if (a.length <= 100)
				{
					System.out.println("Merge sorted list: ");
					for(int i=0; i<a.length; i++)
					{
						System.out.print(a[i]+" ");
					}
					System.out.println();
				}
			}
			time2=System.currentTimeMillis();
			time3=time2-time;
			
			if (count == 0)
				System.out.println("Time for Selection Sort (ms): "+time3);
			else if (count == 1)
				System.out.println("Time for Bubble Sort (ms): "+time3);
			else if (count == 2)
				System.out.println("Time for Insertion Sort (ms): "+time3);
			else if (count == 3)
				System.out.println("Time for Quick Sort (ms): "+time3);
			else
				System.out.println("Time for Merge Sort (ms): "+time3);
			count++;	
		}
	}
}