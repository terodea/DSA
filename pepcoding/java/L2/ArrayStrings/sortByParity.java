import java.util.*;

public class sortByParity {

    // ~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~
    
    public static void sortArrayByParity(int[] nums) {
        // write your code here
        int i=0; // first unsolved
        int j=0; // first odd
        int n = nums.length;
        
        while(i < n){
            if(nums[i] % 2 == 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            }
            else{
                i++;
            }
        }
    }

    //// ~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        int[] arr = {3,1,2,4};
        sortArrayByParity(arr);
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
