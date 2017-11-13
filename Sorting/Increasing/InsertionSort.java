/* Implementation of Insertion sort considering increasing order */
class InsertionSort
{

  int maxSize;              //maximum size of array

  InsertionSort(int maxSize)
  {
    this.maxSize = maxSize;   //initializing maximum size
  }

  void insertionSort(int array[])
  {
    for(int i=1; i<maxSize; i++)        //loop unitll last element
    {
      int value = array[i];           //assing current value of array as value
      int hole = i;                   // hole as current index
      while(hole>0 && array[hole-1]>value)    // hole must be greater than 0 and left side of currnet index's value must be greater than value
      {
        array[hole] = array[hole-1];        // move current hole to move index up
        hole--;
      }
      array[hole] = value;        // place the value to hole
    }
  }

  public static void main(String args[])
  {
    int array[] = {100, 1,3, 20, 5, 60, 12, 50, 45, 30};
    InsertionSort sort = new InsertionSort(array.length);
    sort.insertionSort(array);
    for(int i=0; i<sort.maxSize; i++)
    {
      System.out.println(array[i]);
    }
  }
}
