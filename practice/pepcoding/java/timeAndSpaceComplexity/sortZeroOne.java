import java.io.*;
import java.util.*;

public class sortZeroOne{

    public static void main(String[] args){
        /*
        *Swapping index 0 and index 0
        *Swapping index 2 and index 1
        *Swapping index 4 and index 2
        *0
        *0
        *0
        *1
        *1 
        */
        int n = 5;
        int[] arr = { 0, 1, 0, 1, 0 };
        sort01(arr);
        print(arr);
    }

    public static void sort01(int[] arr){
        int i =0 , j = 0;

        while(i < arr.length){
            if(arr[i] == 0){
                swap(arr, i, j);
                i++;
                j++;
            }
            else{
                i++;
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