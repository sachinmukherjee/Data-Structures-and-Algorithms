/* Implementation of Quick Sort considering incresing order */
class QuickSort
{
  void quickSort(int arr[], int start, int end)
  {
    if(start<end)       // if two arrays are divideable or not
    {
      int pIndex  = partition(arr, start, end);
      quickSort(arr, start, pIndex-1);
      quickSort(arr, pIndex+1, end);
    }
  }

  int partition(int arr[], int start, int end)
  {
    int pivot = arr[end];           // take last element as pivot
    int i = start-1;                // start for one less than start index usually -1
    for(int j=start; j<end; j++)    // start from start and loop till end  usually 0
    {
      if(arr[j] <= pivot)           // if current element is smallert than pivot
      {
        i++;            // increase the index, first make index 0
        int temp = arr[i];  // copy the current index value
        arr[i] = arr[j];    // swap with j
        arr[j] = temp;
      }
    }
      int temp = arr[i+1];    // swap the pivot with its necessary element
      arr[i+1] = arr[end];
      arr[end] = temp;
      return i+1;

  }

  public static void main(String args[])
  {
    QuickSort Sort = new QuickSort();
    int arr[] = {100,1,3, 52, 25, 33, 91, 17};
    Sort.quickSort(arr,0, arr.length-1);
    for(int i=0; i<arr.length; i++)
        System.out.println(arr[i]);
  }
}
