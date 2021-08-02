package Glava_4.Task4_1;

public class RecursiveSum {

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i <arr.length ; i++) {
            arr[i] = i;
        }
        System.out.println(sumOfArray(arr));

    }
    public static int sumOfArray(int[] arr) {
        if(arr.length==0)   {
            return 0;
        }
        else    {
            int sum = arr[0];
            int [] newArr = new int[arr.length-1];
            for (int i = arr.length-1; i >=arr.length-newArr.length ; i--) {
                newArr[i-1]= arr[i];
            }
            return sum+sumOfArray(newArr);
        }
    }
}
