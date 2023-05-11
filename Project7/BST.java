public class BST //implements Container
{
  private class treenode
  {
    Comparable data;
    treenode left, right; // child node pointers
  }
  treenode root;
  int count;

  public BST()
    { root=null; count=0; QueueLL Q=new QueueLL(); }

  private treenode inserthelp(Comparable x, treenode r)
  // we must return the new or unchanged value of r as the function value
  {
    // base case - empty tree
    if(r==null)
    {
      treenode newnode=new treenode();
      newnode.data=x;
      newnode.left=newnode.right=null;
      count++;
      return newnode;
    }
    if(x.compareTo(r.data)<=0) // insert in left subtree
      r.left=inserthelp(x,r.left);
    else
      r.right=inserthelp(x,r.right);
    return r;
  }

  public void insert(Comparable x)
  { root=inserthelp(x,root); }

  private Comparable lookuphelp(Comparable x, treenode r)
  {
    if(r==null) return null; // not here
    if(r.data.compareTo(x)==0) // here it is!
      return r.data;
    // recursive case - go left or right
    if(x.compareTo(r.data)<0)
      return lookuphelp(x,r.left);
    else
      return lookuphelp(x,r.right);
  }

  public Comparable lookup(Comparable x)
  { return lookuphelp(x,root); }

//----- Delete code

  private Comparable itemremoved;

  private Comparable findmin(treenode r)
  {
    if(r==null) return null;
    if(r.left==null) return r.data;
    return findmin(r.left);
  }

  private treenode findisparent(treenode r)
  {
    if(r.left.left==null) return r;
    else return findisparent(r.left);
  }

  private treenode deletehelp(Comparable key, treenode r)
  {
    if(r==null) // no tree, deletion fails
    {
      itemremoved=null;
      return r;
    }
    if(key.compareTo(r.data)==0) // we found it!
    {
      // cases
      itemremoved=r.data;
      count--;
      // 0 children
      if(r.left==null && r.right==null)
      {
        return null;
      }
      // 1 child - left
      if(r.right==null) // must have a left child logically
      {
        return r.left; // promotes the left child
      }
      // 1 child - right
      if(r.left==null) // must have a right child logically
      {
        return r.right; // promotes the right child
      }
      // 2 children - yay!

      // find is and it's parent node
      treenode isparent;
      Comparable is;
      if(r.right.left==null)
      {
        is=r.right.data;
        r.right=r.right.right;
      }
      else // general case
      {
        isparent=r.right;
        while(isparent.left.left!=null)
          isparent=isparent.left;
        is=isparent.left.data;
        isparent.left=isparent.left.right;
      }
      itemremoved=r.data;
      r.data=is;
      return r;
    }
    else if(key.compareTo(r.data)<0) // search left
      r.left=deletehelp(key,r.left);
    else // search right
      r.right=deletehelp(key,r.right);
    return r;
  }

  public Comparable delete(Comparable key)
  {
    if(key==null) return null;
    root=deletehelp(key,root); // this will set itemremoved
    return itemremoved;
  }

//----- print code

  private void printhelp(treenode r)
  {
    if(r==null) return;
    printhelp(r.left);
    System.out.println(r.data);
    printhelp(r.right);
  }

  public void print()
  { printhelp(root); }

//------ Traversals code

  private QueueLL Q = new QueueLL();

  public static final int PRE=0;
  public static final int IN=1;
  public static final int POST=2;

  private void traverse(treenode r,int order)
  {
    if(r==null) return;
    
    if(order==PRE) Q.enqueue(r.data);
    traverse(r.left,order);
    if(order==IN) Q.enqueue(r.data);
    traverse(r.right,order);
    if(order==POST) Q.enqueue(r.data);
  }

  public void reset(int order)
  {
	  Q.makeEmpty();
	  traverse(root,order);
  }

  public void reset() { reset(IN); }

  public Comparable getNext() { return (Comparable)Q.dequeue(); }
  public boolean hasNext() { return !Q.isEmpty(); }

  public void makeEmpty() // empties all elements
    { root=null; count=0; Q.makeEmpty(); }
  public int size() // returns the size of the container
    { return count; }
  public boolean isEmpty() // returns true of size is 0
    { return count<=0; }
  public boolean isFull() // returns true if there's no space available
    { return false; }
}