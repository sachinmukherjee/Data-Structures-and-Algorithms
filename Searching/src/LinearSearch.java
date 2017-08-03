//Linear search implementaion in java using iterative method
//created by sachin mukherjee
//sachinmukherjee29@gmail.com

import java.util.Scanner;

public class LinearSearch 
{
    static int binarySearch(int arr[], int element)
    {
        int result = 0;
        int len = arr.length;
        for(int i=0; i<len; i++)
        {
            if(arr[i] == element)
                return i;
        }
        return -1;
        
    }
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter size of array");
        int len = scan.nextInt();
        int arr[] = new int[len];
        System.out.println("Enter array elements");
        for(int i=0; i<len; i++)
        {
            arr[i] = scan.nextInt();
        }
        System.out.println("Enter element to be find");
        int element = scan.nextInt();
        int result = binarySearch(arr,element);
        
        if(result>0)
            System.out.println("Element found at location "+ result);
        else
            System.out.println("Element not found");
    }
    
}
