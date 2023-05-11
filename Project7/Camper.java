import java.util.*;

class Camper implements Comparable
{
  // Data Members
  String name;
  int age;
  char diet='A';

  // Constructor
  public Camper(String n, int a, char d)
  {
	  name=n;
	  age=a;
	  diet=d;
  }
  
  // constructor for reading from a file
  public Camper(Scanner file)
  {
	  name=file.next();
	  age=file.nextInt();
	  diet=file.next().charAt(0);
  }
  
  public int compareTo(Object x)
  {
	  if(x instanceof Camper)
	  {
		  Camper c=(Camper)x;
		  // comparing fins
		  if (name.compareTo(c.name)<1)
			  return -1;
		  if(name.compareTo(c.name)>1)
			  return +1;
		  return 0;
		  
		  //comparting strings for names
		 // return name.compareTo(f.name);
	  }
	  else //print error message and quit
	  {
		  System.out.println("Error - cannot compare to Campers");
		  System.exit(1);
		  return 0;
	  }
  }
  
  // Observer
  public String toString()
  {
	  return name+" "+age+" "+diet;
  } 
  
  // more observers - getters
  public String getname() { return name; }
  public int getage() { return age; }
  public int getdiet() { return diet; }
}