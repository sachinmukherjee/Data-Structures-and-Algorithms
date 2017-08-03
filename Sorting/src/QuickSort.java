//Quick sort algorithm implemetation in java considering ascceding order using recursive techique
// Taking pivot as last element
//created by sachin mukherjee
//sachinmukherjee29@gmail.com

import java.util.Scanner;
public class QuickSort 
{
    int partion(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = low-1;
        for(int j = low; j<high-1; j++)
        {
            if(arr[j]<=pivot)
            {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        
        return i+1;
    }
    void sort(int arr[], int low, int high)
    {
        if(low<high)
        {
            int mid = partion(arr, low, high);
            sort(arr,low, mid);
            sort(arr,mid+1,high);
        }
        
    }
    
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter length of array");
        int len = scan.nextInt();
        int arr[] = new int[len];
        System.out.println("Enter array elements");
        for(int i=0; i<len; i++)
        {
            arr[i] = scan.nextInt();
        }
        QuickSort sort = new QuickSort();
        sort.sort(arr, 0, len-1);
        System.out.println("Sorted array is");
        System.out.println("");
        for(int a:arr)
            System.out.println(a);
    }
    
}
