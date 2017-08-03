//Merge sort implementation in java considering ascceding order
//created by sachin mukherjee
//sachinmukherjee29@gmail.com

import java.util.Scanner;
public class MergeSort 
{
    void merge(int arr[], int left, int right, int mid)
    {
        int i = left;
        int j = mid+1;
        int k = 0;
        int n1 = right-left + 1;
        int n2 = right-mid;
        int L[] = new int[n1];
        int R[] = new int[n2];
        
        for(i=0; i<n1; i++)
        {
            L[i] = arr[i+left];
        }
        for(j = 0; j<n2; j++)
        {
            R[j] = arr[mid+1+j]; 
        }
        
        while(i<n1 && j<n2)
        {
            if(L[i]<R[j])
            {
                arr[k] = L[i];
                i++;
                k++;
            }
            else
            {
                arr[k] = R[j];
                k++;
                j++;
            }
        }
        while(i<n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
        while(j<n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    void sort(int arr[], int l, int r)
    {
        if(l<r)
        {
            int m = (l+r)/2;
            sort(arr, l, m);
            sort(arr, m+1, r);
            merge(arr,l,r,m);
        }
        
    }
    
    
    public static void main(String args[])
    {
        Scanner scan =  new Scanner(System.in);
        System.out.println("Enter length of array");
        int len = scan.nextInt();
        int arr[] = new int[len];
        System.out.println("Enter array elements");
        for(int i=0; i<len; i++)
        {
            arr[i] = scan.nextInt();
        }
        MergeSort sort = new MergeSort();
        sort.sort(arr, 0, len-1);
        for(int a: arr)
            System.out.println(a);
        
        
    }
    
}
