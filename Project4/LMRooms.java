// Noah Monroe
//CS248-01
// Feb. 25, 2022

import java.io.*;
import java.util.*;

class LMRooms
{
	//data members
	//a = adjacent, rd = room description
	int room, a1, a2, a3;
	String rd;
	
	public void set (int a, int b, int c, int d, String e) //Constructor
	{
		room=a;
		a1=b;
		a2=c;
		a3=d;
		rd=e;
	}
	
	public LMRooms (Scanner r) // Constructor to read in from file. 
	{
		room = r.nextInt();
		a1 = r.nextInt();
		a2 = r.nextInt();
		a3 = r.nextInt();
		rd = r.next() + r.nextLine();
	}
	
    public String toString()
    {
  	  return "Room #="+room+" Adjacent 1="+a1+" Adjacent 2="+a2+" Adjacent 3="+a3+" Description= "+rd;
    }
	
	public int getA1() {return a1;}
	public int getA2() {return a2;}
	public int getA3() {return a3;}
	public String getD () {return rd;}
	
	public int isAdjacent(int k)
	{
		if (k==a1 || k==a2 || k==a3)
			return k;
		else
			return 0;
	}
}