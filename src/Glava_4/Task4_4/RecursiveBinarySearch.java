package Glava_4.Task4_4;

import org.omg.CosNaming.NamingContextPackage.NotFound;

public class RecursiveBinarySearch {
    public static int step = 1;
    public static void main(String[] args) throws NotFound {
        int[] arr = new int[100];
        for (int i = 0; i <arr.length ; i++) {
            arr[i]=i;
        }
        int n=recursiveSearch(arr,8,0,arr.length);
        System.out.println(n);
        System.out.println(arr[n]);
        System.out.println(cycleBinarySearch(arr,11));
    }

    public static int recursiveSearch(int[] arr,int n, int min, int max) throws NotFound {
       if(min<=max) {
           int mid = (min+max)/2;
           if(arr[mid]>n)   {
               System.out.println("STEP NUMBER " + step++);
               return recursiveSearch(arr,n,min,mid-1);
           }
           else if (arr[mid]<n) {
               System.out.println("STEP NUMBER " + step++);
               return recursiveSearch(arr,n,mid+1,max);
           }
           else     {
               System.out.println("STEP NUMBER " + step++);
               return mid;
           }
       }
       throw new NotFound();
    }
    public static int cycleBinarySearch(int arr[], int n) throws NotFound {
        int min=0;
        int max = arr.length-1;
        while (min<=max)    {
            int mid = (min+max)/2;
            if(arr[mid]==n) {
                return mid;
            }
            else if (arr[mid]<n)    {
                min=mid+1;
            }
            else max = mid-1;
        }
        throw new NotFound();
    }
}
