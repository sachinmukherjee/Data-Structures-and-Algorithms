//Insertion sort implementation in java considering accending order
//created by Sachin Mukherjee
//sachinmukherjee29@gmail.com

import java.util.Scanner;
public class InsertionSort 
{
    void insertionSort(int arr[])
    {
        int len = arr.length;
        for(int i = 1; i<len; i++)
        {
            for(int j = i; j>0; j--)
            {
                if(arr[j-1]>arr[j])
                {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }
    
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter array length");
        int len =  scan.nextInt();
        int arr[]  = new int[len];
        System.out.println("Enter array elements");
        for(int j = 0; j<len; j++)
        {
            arr[j] = scan.nextInt();
        }
        InsertionSort sort = new InsertionSort();
        sort.insertionSort(arr);
        for(int a: arr)
            System.out.println(a);
        
    }
    
}
