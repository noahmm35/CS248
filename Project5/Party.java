import java.util.*;

class Party
{
  // Data Members
  int guests;
  int time;
  String partyName;

  // Constructor
  public Party(int g, int t, String pn)
  {
	  guests=g;
	  time=t;
	  partyName=pn;
  }
  
  // constructor for reading from a file
  public Party(Scanner file)
  {
	  time=file.nextInt();
	  guests=file.nextInt();
	  partyName=file.next();
  }
  
  // Observer
  public String toString()
  {
	  return "party"+partyName+" of "+guests+" people.";
  } 
  
  // more observers - getters
  public String getpartyName() { return partyName; }
  public int gettime() { return time; }
  public int getguests() { return guests; }
}