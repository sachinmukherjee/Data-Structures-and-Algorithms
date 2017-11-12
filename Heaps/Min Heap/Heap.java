/* Implementation of Heaps -- Min Heap*/
class Heap
{
  int size;       // Size of heap
  int[] array;    //heap array
  int position;   // current size

  Heap(int size)
  {
    this.size = size;   // size initialization
    position = 0;       //current position initialization
    array = new int[size];  // array initialization
  }

  void insert(int data)
  {
    if(position == size-1)    // if heap is full
    {
      System.out.println("Heap Full");
    }
    else
    {
      array[position++] = data;     // enter data at current position and move position one upwards
      percolateUP();                // heapify up
    }
  }

  void percolateUP()
  {
    int pos = position-1;         // last index of element
    while(pos>=0 && array[pos/2]>array[pos]) // parent is greater than children
    {
      // pos/2 parent and pos is children
      //SWAP
      int y = array[pos];
      array[pos] = array[pos/2];
      array[pos/2] = y;
      pos = pos/2;        // move upwards
    }
  }

  int remove()
  {
    if(position<0)      // if heap is empty
    {
      return -1;
    }
      int min = array[0];       //take out first element
      array[0] = array[position-1];   // make last element as first element
      position--;         // decrease the position counter
      percolateDown(0);   // heapify down
      return min;         // return min i.e first element


  }

  void percolateDown(int index)
  {
    int smallest = index;           // assume index as smallest
    int a = array[index];           // assing value of smallest element to a

    if(2*index+1<position && array[smallest]>array[2*index+1])      // leftchild is smaller than parent and leftchild index is less than position counter
          smallest = 2*index+1;       // make leftchild as smallest

    if(2*index+2<position && array[smallest] > array[2*index+2])    // rightchild is smaller than parent and rightchild index is less than position count
          smallest = 2*index+2;       // make smaller as rightchild

    if(smallest != index)       // if smaller is not index
      {
        //SWAP
        int temp = array[index];
        array[index] = array[smallest];
        array[smallest] = temp;
	percolateDown(smallest);         // heapify down
      }
  }

  public static void main(String args[])
  {
    int[] arr = {10,555,1,20,30,60,15,22};
    Heap heaps = new Heap(arr.length);
    for(int i=0;i<arr.length; i++)
	heaps.insert(arr[i]);

    for(int j=0; j<arr.length-1; j++)
    {
      System.out.println(heaps.remove());
    }
  }
}
