// Noah Monroe
//CS248
//Friday, Feburary 4

import java.io.*;
import java.util.*;

class MyDate implements DateInterface
{
	//data members
	int Day;
	int Month;
	int Year;
	int Dow;
	String Weekday;
	String MthName;
	
	// constructors - getters
	 public int getDay() { return Day; }
     public int getDow() { return Dow; }
     public int getMonth() { return Month; }
     public int getYear() { return Year; }
	 
	 public void set(int m, int d, int y, int dow)
	 {
		 Month=m;
		 Day=d;
		 Year=y;
		 Dow=dow;
	 }
	 
	 public void tomorrow()
	 {
		 if (Year%100==0 && Month==2)
		 {
			 if (Year%400==0)
			 {
				 if(Day==29)
				 {
					 Month++;
					 Day=0;
				 }
			 }
			 else
			 {
				 if(Day==28)
				 {
					 Month++;
					 Day=0;
				 }
			 }
		 }
		 else if (Year%4==0)
		 {
			 if (Day==29)
			 {
				 Month++;
				 Day=0;
			 }
		 }
		 
		 if (Year%4!=0 && Month==2 && Day==28)
		 {
			 Month++;
			 Day=0;
		 }
		 
		 if ((Month==1 || Month==3 || Month==5 || Month==7 || Month==8 || Month==10 || Month==12) && Day==31)
		 {
			 Month++;
			 Day=0;
		 }
		 if ((Month==4 || Month==6 || Month==9 || Month==11) && Day==30)
		 {
			 Month++;
			 Day=0;
		 }
		 	 
		 if(Month>12)
		 {
			 Year++;
			 Month=1;
			 Day=0;
		 }
		 
		 if(Dow>=6)
		 {
			 Dow=(-1);
		 }
		 
		 Day++;
		 Dow++;
	 }
	 
	 public String toString()
	 {
		 if (Month == 1)
			 MthName = "Janurary";
		 else if (Month == 2)
			 MthName = "Feburary";
		 else if (Month == 3)
			 MthName = "March";
		 else if (Month == 4)
			 MthName = "April";
		 else if (Month == 5)
			 MthName = "May";
		 else if (Month == 6)
			 MthName = "June";
		 else if (Month == 7)
			 MthName = "July";
		 else if (Month == 8)
			 MthName = "August";
		 else if (Month == 9)
			 MthName = "September";
		 else if (Month == 10)
			 MthName = "October";
		 else if (Month == 11)
			 MthName = "November";
		 else if (Month == 12)
			 MthName = "December";
		 
		 if (Dow==0)
			 Weekday="Sunday";
		 else if (Dow==1)
			 Weekday="Monday";
		 else if (Dow==2)
			 Weekday="Tuesday";
		 else if (Dow==3)
			 Weekday="Wednesday";
		 else if (Dow==4)
			 Weekday="Thursday";
		 else if (Dow==5)
			 Weekday="Friday";
		 else if (Dow==6)
			 Weekday="Saturday";
		 
				  
		 return Weekday+" "+MthName+" "+Day+", "+Year;
	 }
	 
	 public void today()
	 {
		 //leaving empty
	 }
	 
	 public void yesterday()
	 {
		 //leaving empty
	 }
}