//Selection sort algorithm implementation in java considering accending order
//created by sachin mukherjee
//sachinmukherjee29@gmail.com

import java.util.Scanner;
public class SelectionSort 
{
    void selectionSort(int arr[])
    {
        int len = arr.length;
        for(int i=0; i<len-1; i++)
        {
            int min = i;
            for(int j= i+1; j<len; j++)
            {
                if(arr[min]>arr[j])
                min = j;
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        
        
    }
    public static void main(String args[])
    {
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Length of array");
        int len = scan.nextInt();
        int arr[] = new int[len];
        System.out.println("Enter array elements");
        for(int i=0; i<len; i++)
        {
            arr[i] = scan.nextInt();
        }
        SelectionSort sort = new SelectionSort();
        sort.selectionSort(arr);
        System.out.println("Result of the sorted array");
        for(int a: arr)
            System.out.println(a);
        
        
    }
}

