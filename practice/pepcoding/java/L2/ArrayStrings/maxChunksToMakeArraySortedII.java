import java.util.*;
public class maxChunksToMakeArraySortedII {

    // ~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~
    public static int maxChunksToSorted2(int[] arr) {
        int count = 0;
        int[] rightMin = new int[arr.length+1];
        int n = arr.length;
        rightMin[n] = Integer.MAX_VALUE;
        
        for(int i= n-1; i>=0; i--){
            rightMin[i] = Math.min(rightMin[i+1], arr[i]);
        }
        
        int leftMax = Integer.MIN_VALUE;
        
        for(int i=0; i<n; i++){
            
            leftMax = Integer.max(arr[i], leftMax);
            
            if(leftMax <= rightMin[i+1]) {
                count++;
            }
        }
        return count;
    }

    // ~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        int[] arr = {4,3,6,5,7,12,11,10};
        int res = maxChunksToSorted2(arr);
        System.out.println(res);
    }
}