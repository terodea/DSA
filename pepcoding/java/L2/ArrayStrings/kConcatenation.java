import java.io.*;
import java.util.*;

public class kConcatenation {
    public static long kadanes(int[] nums) {
        long csum = 0;
        long osum = Integer.MIN_VALUE;
        
        for(int i=0; i<nums.length; i++){
            if(csum < 0){
                csum = nums[i];
            } else{
                csum += nums[i];
            }
            osum = Math.max(osum, csum);
            
        }
        return osum;
    }
    
    private static long kadanesOfTwo(int[] arr){
        int n = arr.length;
        
        int[] narr = new int[2*n];
        
        for(int i=0; i<n; i++){
            narr[i] = arr[i];
        }
        
        for(int i=0; i<n; i++){
            narr[i + n] = arr[i];
        }
        
        return kadanes(narr);
    }
    
    public static long solution(int[] arr, int k, long sum) {
        if(k == 1){
            return kadanes(arr);
        }
        else if(sum < 0){
            return kadanesOfTwo(arr);
        }
        else{
            return kadanesOfTwo(arr) + (k-2) * sum;
        }
    }

  public static void main(String[] args) {
    int n = 3;
    int[] arr = {1,2,3};
    long sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
    }
    int k = 3;
    System.out.println(solution(arr, k, sum));
  }

}