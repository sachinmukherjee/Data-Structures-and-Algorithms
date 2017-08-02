//Bubble sort implementation in java considering accending order
//created by sachin mukherjee
//sachinmukherjee29@gmail.com
import java.util.Scanner;
public class BubbleSort 
{
    void bubbleSort(int arr[])
    {
        int len = arr.length;
        for(int i=0; i<len; i++)
        {
            for(int j=0; j<len-1; j++)
            {
                if(arr[j]<arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
                    
            }
        }
    }
    
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter length of array");
        int len = scan.nextInt();
        System.out.println("Enter array elements");
        int[] arr = new int[len];
        for(int i= 0; i<len; i++)
        {
            arr[i] = scan.nextInt();
        }
        BubbleSort sort = new BubbleSort();
        sort.bubbleSort(arr);
        System.out.println("Displaying sorted array");
        for(int a:arr)
            System.out.println(a);
        
    }
    
}
