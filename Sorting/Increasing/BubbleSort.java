/* Implementation of Bubble Sort considering increasing order */

class BubbleSort
{
  int[] array = {10, 30, 100, 1, 5, 300,70, 60, 90, 50};
  int maxSize;
  BubbleSort(int maxSize)
  {
    this.maxSize = maxSize;

  }

  void insert(int data)
  {
    int i = 0;
    array[i] = data;
    i++;
  }

  void bubbleSort()
  {
    for(int i=0; i<maxSize;i++)       // Loop untill number of elements in array
    {
      for(int j=0; j<maxSize-1; j++)    // Loop untill number of elements -1 in array
      {
        if(array[j]>array[j+1])
        {
          int temp = array[j+1];
          array[j+1] = array[j];
          array[j] = temp;
        }
      }
    }
  }

  public static void main(String args[])
  {
    BubbleSort sort = new BubbleSort(10);
    sort.bubbleSort();
    for(int i=0; i<sort.maxSize; i++)
    {
      System.out.println(sort.array[i]);
    }

  }
}
