import java.io.*;
import java.util.*;

public class firstIndex{

    public static void main(String[] args){

        int[] arr = {15, 11, 40, 4, 4, 7};
        int x = 4;
        System.out.println(getFirstIndex(arr, 0, x));
    }

    public static int getFirstIndex(int[] arr, int idx, int target){
        if(idx == arr.length - 1){
            return -1;
        }

        return (arr[idx] == target) ? idx : getFirstIndex(arr, idx+1, target);
    }
}