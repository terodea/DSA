import java.io.*;
import java.util.*;

public class sortZeroOneTwo{

    public static void main(String[] args){
        /*
        Swapping index 1 and index 0
        Swapping index 2 and index 9
        Swapping index 2 and index 8
        Swapping index 2 and index 1
        Swapping index 3 and index 7
        Swapping index 5 and index 2
        Swapping index 6 and index 6
        0
        0
        0
        1
        1
        1
        2
        2
        2
        2
        */
        int n = 10;
        int[] arr = { 1, 0, 2, 2, 1, 0, 2, 1, 0, 2};
        sortZeroOneTwo(arr);
        print(arr);

    }

    public static void sortZeroOneTwo(int[] arr){
        int i = 0, j = 0, k = arr.length - 1;

        while(i <= k){
            if(arr[i] == 0){
                swap(arr, i, j);
                i++;
                j++;
            }
            else if (arr[i] == 1){
                i++;
            }
            else{
                swap(arr, i, k);
                k--;
            }
        }
    }
    public static void swap(int[] arr, int i, int j) {
    System.out.println("Swapping index " + i + " and index " + j);
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void print(int[] arr){
    for(int i = 0 ; i < arr.length; i++){
      System.out.println(arr[i]);
    }
  }
}