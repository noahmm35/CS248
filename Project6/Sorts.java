class Sorts
{
  private static void swap(Comparable [] list, int x, int y)
  // swap list[x] with list[y]
  {
    Comparable temp=list[x];
    list[x]=list[y];
    list[y]=temp;
  }

  // no

  private static int findmax(Comparable [] list, int end)
  // returns the array position of the maximum from 0..end
  {
    int maxsofar=0;
    for(int i=1; i<=end; i++)
      if(list[i].compareTo(list[maxsofar])>0)
        maxsofar=i;
    return maxsofar;
  }

  public static void selection(Comparable [] list)
  {
    for(int end=list.length-1; end>0; end--)
    {
      // find the position of the max in 0..end
      int maxpos=findmax(list,end);
      // swap
      swap(list,maxpos,end);
    }
  }

  public static void bubble(Comparable [] list)
  {
    // loop over passes
    boolean sorted=false;
    while(!sorted)
    {
      // do a pass
      sorted=true;
      for(int i=0; i+1<list.length; i++)
        if(list[i].compareTo(list[i+1])>0) // out of order
          { swap(list,i,i+1); sorted=false; }
    }
  }

  public static void insertion(Comparable [] list)
  {
    for(int toinsert=1; toinsert<list.length; toinsert++)
    {
      // insert to the left
      Comparable save=list[toinsert];
      // loop to slide things to the right
      int i; // make sure this is available outside the loop
      for(i=toinsert-1; i>=0; i--)
      {
        if(list[i].compareTo(save)>0) // move to the right
          list[i+1]=list[i];
        else
        {
          list[i+1]=save;
          break; // stop the loop
        }
      }
      // check to see if i<0
      if(i<0) list[0]=save;
    }
  }

  public static void insertion(Comparable [] list, int offset, int gap)
  {
    for(int toinsert=offset+gap; toinsert<list.length; toinsert+=gap)
    {
      // insert to the left
      Comparable save=list[toinsert];
      // loop to slide things to the right
      int i; // make sure this is available outside the loop
      for(i=toinsert-gap; i>=0; i-=gap)
      {
        if(list[i].compareTo(save)>0) // move to the right
          list[i+gap]=list[i];
        else
        {
          list[i+gap]=save;
          break; // stop the loop
        }
      }
      // check to see if i<0
      if(i<0) list[offset]=save;
    }
  }

  public static void shell(Comparable [] list)
  {
    for(int gap=list.length/6; gap>1; gap=(int)(gap/2.2))
    {
      // sort each color
      for(int offset=0; offset<gap; offset++)
        insertion(list, offset, gap);
    }
    insertion(list);
  }

  private static int partition(Comparable [] list, int start, int stop)
  {
    int right=start;
    Comparable pivot=list[stop];
    for(int i=start; i<stop; i++)
    {
      if(list[i].compareTo(pivot)<0)
      {
        swap(list,i,right);
        right++;
      }
    }
    swap(list,right,stop); // put pivot where it belongs

    //System.out.println("Inside partition: start="+start+" stop="+stop+
     // " pivot pos="+right);

    return right;
  }

  private static void quickrec(Comparable [] list, int start, int stop)
  {
    // base cases
    if(start>=stop) // size 0 or 1
      return;  // nothing to do
    if(start+1==stop) // size 2
    {
      if(list[start].compareTo(list[stop])>0) // out of order
        swap(list,start,stop);
      return;
    }
    // recursive case
    int pivotpos=partition(list,start,stop); // real work happens here
    // sort each half
    quickrec(list,start,pivotpos-1); // left half
    quickrec(list,pivotpos+1,stop);  // right half
  }

  public static void quick(Comparable [] list)
  {
    quickrec(list,0,list.length-1); // recursive helper function
  }

  private static void domerge(Comparable [] list, int start, int stop)
  // two lists are start..mid and mid+1..stop
  {
    int mid=(start+stop)/2;
    Comparable [] A=new Comparable[stop-start+1]; // hold the merged list
    int left=start;
    int right=mid+1;
    for(int i=0; i<A.length; i++)
    {
      // figure out where to get the next item
      // pull from the left if: right is empty or list[left]<list[right]
      //   AND the left is not empty
      if(left<=mid && ( right>stop || list[left].compareTo(list[right])<0) )
        A[i]=list[left++];
      else // pull from the right
        A[i]=list[right++];
    }
    for(int i=0; i<A.length; i++)
      list[start+i]=A[i];
  }

  private static void mergerec(Comparable [] list, int start, int stop)
  {
    // base cases
    if(start>=stop) // size 0 or 1
      return;  // nothing to do
    if(start+1==stop) // size 2
    {
      if(list[start].compareTo(list[stop])>0) // out of order
        swap(list,start,stop);
      return;
    }
    // recursive case
    int mid=(start+stop)/2;
    mergerec(list,start,mid);
    mergerec(list,mid+1,stop);
    domerge(list,start,stop);
  }

  public static void merge(Comparable [] list)
  {
    mergerec(list,0,list.length-1);
  }



}