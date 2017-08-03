//Binary search implementation in java using iterative techinque
//created by sachin mukherjee
//sachinmukherjee29@gmail.com

import java.util.Scanner;
public class BinarySearch
{
    static int binarySearch(int arr[] , int element)
    {
        int len = arr.length;
        int low = 0;
        int high = len-1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(arr[mid] == element)
                return mid;
            else if(arr[mid]> element)
                high = mid-1;
            else
                low = mid+1;
            
        }
        return -1;
    }
    
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter length of array elemen");
        int len = scan.nextInt();
        int arr[] = new int[len];
        System.out.println("Enter array elements");
        for(int i=0; i<len; i++)
        {
            arr[i] = scan.nextInt();
        }
        System.out.println("Enter element to be search");
        int element = scan.nextInt();
        int result = binarySearch(arr, element);
        if(result>0)
            System.out.println("Element found at location "+ result);
        else 
            System.out.println("Element not found");
    }
    
}
