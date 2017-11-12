/* Implementation of Heap Max-Heap */
class Heap
{
  int position;           //count for current position
  int size;               // size of heap
  int[] array;            //array

  Heap(int size)
  {
    this.size = size;     //initializing the size of heap
    position = 0;         // initializing the postion count
    array = new int[size];  //initializing the array
  }

  void insert(int data)
  {
    if(position == size-1)        // if heap is full means no more insertion
      System.out.println("Heap is Full");
    else
    {
      array[position++] = data;     // insert data at current position and increase position counter
      percolateUp();                // heapify up
    }
  }
  void percolateUp()
  {
    int pos = position-1;         // index of last element
    while(pos>=0 && array[pos]>array[pos/2])      // pos >=0 && child is greater than parent
    {
      // pos is child and pos/2 is parent
      int temp = array[pos];
      array[pos] = array[pos/2];
      array[pos/2] = temp;
      pos = pos/2;    //move upwards
    }
  }

  int remove()
  {
    if(position<0)      // is heap is empty
    {
      return -1;
    }
    else
    {
      int rem = array[0];         // take first element
      array[0] = array[position-1];     // assing last element to first element
      position--;     // decrease the position counter
      percolateDown(0);     // heapify down
      return rem;
    }
  }

  void percolateDown(int index)
  {
    int smallest = index;     //assume index as smallest element
    if(2*index+1 < position && array[smallest] < array[2*index+1])      // count of leftchild is smaller than position counter and current parrent is smaller than lefchild
          smallest = 2*index+1;     // make smaller as leftchild
    if(2*index+2 < position && array[smallest] < array[2*index+2])      // count of rightchild is smaller than position counter and currnet parrent is smaller than rightchild
          smallest = 2*index+2;     // make smaller as rightchild

    if(smallest != index)     // if smallest is not index then swap and call heapify down
        {
          int temp = array[smallest];
          array[smallest] = array[index];
          array[index] = temp;
          percolateDown(smallest);
        }
  }

  public static void main(String args[])
  {
    int arr[] = {10,50,60, 70, 5, 15, 66, 101, 1, 3};
    Heap heap = new Heap(arr.length);
    for(int i=0; i<arr.length; i++)
        heap.insert(arr[i]);
    for(int j=0; j<arr.length-1; j++)
    {
      System.out.println(heap.remove());
    }
  }

}
