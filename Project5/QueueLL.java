public class QueueLL implements Queue
{
  private class node
  {
    public Object data;
    public node next;
  }
  node front, back;
  int count;

  public QueueLL()
  {
    front=back=null;
    count=0;
  }

  public void enqueue(Object x)
  {
    node newnode=new node();
    newnode.data=x;
    newnode.next=null;
    if(count==0)
      front=newnode;
    else
      back.next=newnode;
    back=newnode;
    count++;
  }

  public Object dequeue()
  {
    if(isEmpty()) return null;
    Object save=front.data;
    front=front.next;
    count--;
    if(count==0) back=null;
    return save;
  }

  public Object getFront()
  {
    if(isEmpty()) return null;
    return front.data;
  }

  public void makeEmpty() // empties all elements
  { front=back=null; count=0; }
  public int size() // returns the size of the container
  { return count; }
  public boolean isEmpty() // returns true of size is 0
  { return count<=0; }
  public boolean isFull() // returns true if there's no space available
  { return false; }

}