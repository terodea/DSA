import java.util.*;
import java.io.*;

public class firstTransitionPoint{
    public static int findTransition(int[] arr, int target){
        int low = 0;
        int high = arr.length-1;
        
        int idx = -1;

        while(low <= high){
            int mid = low+(high-low) / 2;
            if(arr[mid] == target){
                idx = mid;
                high = mid-1;
            }
            else low = mid + 1;
        }
        return idx;
    }
    public static void main(String[] args){
        int[] arr = {0, 0, 0, 0, 1, 1};
        System.out.println(findTransition(arr), 13);
    }
}