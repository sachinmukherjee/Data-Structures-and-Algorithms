/* Implementation of MergeSort considering increasing order */
class MergeSort
{
  void sort(int arr[], int left, int right)     // initial function
  {
    if(left<right)        // if left index is smaller than right index means we can seprerate array into two parts or not
    {
      int middle = (left+right)/2;        // find middle
      sort(arr, left, middle);            // call sort for first array
      sort(arr, middle+1, right);         // call sort for second array
      merge(arr, left, middle, right);    // call merge for merging two arrays
    }
  }

  void merge(int arr[], int left, int middle, int right)
  {
    int n1 = middle - left+1;     //  for creating a seprate array
    int n2 = right - middle;      //  --------------------------- //
    int L1[] = new int[n1];       // creating seprate array
    int L2[] =new int[n2];

    for(int i=0; i<n1; i++)     // copy both arrays
    {
      L1[i] = arr[i+left];
    }
    for(int j=0; j<n2; j++)     // copy both arrays
    {
      L2[j] = arr[middle+1+j];
    }
    int i = 0;      // initialise index
    int j=0;
    int k = left;   // initialising k = left
    while(i<n1 && j<n2)     // loop untill i and j are smaller than n1 and n2
    {
      if(L1[i]<= L2[j])
      {
        arr[k] = L1[i];
        i++;

      }
      else
      {
        arr[k] = L2[j];
        j++;

      }
      k++;
    }
    while(i<n1)         // copy the rest of elements
    {
      arr[k] = L1[i];
      i++;
      k++;
    }
    while(j<n2)       // copy the rest of elements
    {
      arr[k] = L2[j];
      k++;
      j++;
    }
  }
  public static void main(String args[])
  {
    MergeSort Sort = new MergeSort();
    int arr[]  = { 10, 1, 20, 2, 50, 15, 75, 91, 19,13};
    Sort.sort(arr, 0, arr.length-1);
    for(int i=0; i<arr.length; i++)
    {
      System.out.println(arr[i]);
    }
  }
}
