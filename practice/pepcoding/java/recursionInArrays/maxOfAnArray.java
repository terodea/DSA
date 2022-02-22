import java.io.*;
import java.util.*;

public class maxOfAnArray{
    
    public static void main(String[] args){
        int[] arr = {15, 30, 40, 4, 11, 9};
        int n = 6;
        System.out.println(getMaxFromArray(arr, 0));
    }

    public static int getMaxFromArray(int[] arr, int idx){
        if(idx == arr.length - 1){
            return arr[arr.length-1];
        }
        return Math.max(arr[idx], getMaxFromArray(arr, idx+1));
    }
}