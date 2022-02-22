import java.util.*;
import java.io.*;

public class bubbleSort{

    public static void bubbleSort(int[] arr){
        for(int i=0; i<arr.length - 1; i++){
            for(int j=0; j < arr.length - 1 - i; j++){
                if(isSmaller(arr, j+1, j)){
                    swap(arr, j+1, j);
                }
            }
        }
    }

    public static void main(String[] args){

        int n = 5;
        int[] arr = { 7, -2, 4, 1, 3 };

        bubbleSort(arr);
        print(arr);
    }
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    // return true if ith element is smaller than jth element
    public static boolean isSmaller(int[] arr, int i, int j) {
        System.out.println("Comparing " + arr[i] + " and " + arr[j]);
        if (arr[i] < arr[j]) return true;
        else return false;
    }
    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) System.out.println(arr[i]);
    }
}