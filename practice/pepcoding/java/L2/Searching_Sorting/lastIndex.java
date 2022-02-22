import java.util.*;
import java.io.*;

public class lastIndex{
    public static int getLastIndex(int[] arr, int target){
        int low = 0;
        int high = arr.length-1;
        
        int idx = -1;

        while(low <= high){
            int mid = low+(high-low) / 2;
            if(arr[mid] == target){
                idx = mid;
                low = mid+1;
            }else if(arr[mid] > target) high = mid-1;
            else low = mid + 1;
        }
        return idx;
    }
    public static void main(String[] args){
        int[] arr = {10, 11, 13, 15, 15, 15, 16, 19, 20, 23, 23, 24, 29, 30};
        System.out.println(getLastIndex(arr), 15);
    }
}