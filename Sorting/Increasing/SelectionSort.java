/* Implementation of Selection sort considering increasing order */
class SelectionSort
{
  int array[] = {10, 100, 5, 20, 30, 18, 70,90,2,108};
  int maxSize;

  SelectionSort(int maxSize)
  {
    this.maxSize = maxSize;
  }

  void selectionSort()
  {
    int min;
    //int temp;
    for(int i=0; i<maxSize-1; i++)          // loop untill one element less in array
    {
      min = i;                              // consider current value of i as minimum
      for(int j=i+1; j<maxSize; j++)        // loop all the elements in array starting from i
        {
          if(array[j] < array[min])
          {
            min = j;                      // make min as current value of j if condition passes
          }
        }
          int temp = array[min];        // swap
          array[min] = array[i];
          array[i] = temp;
    }
  }

  public static void main(String args[])
  {
    SelectionSort sort = new SelectionSort(10);
    sort.selectionSort();
    for(int i=0; i<sort.maxSize; i++)
    {
      System.out.println(sort.array[i]);
    }
  }
}
