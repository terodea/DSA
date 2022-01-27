public class wiggleSortII{
    public static void main(String[] args){
        int [] nums = [1,5,1,1,6,4]
        wiggleSort(nums)
    }

    public static void wiggleSort(int[] nums){
        int n = nums.length;
        int[] arr = new int[n];
        
        for(int i=0; i<n; i++){
            arr[i] = nums[i];
        }
        
        Arrays.sort(arr);
        
        int j = n-1;
        int i=1;
        
        while(i < n){
            nums[i] = arr[j];
            j--;
            i += 2;
        }
        
        i=0;
        
        while(i < n){
            nums[i] = arr[j];
            j--;
            i += 2;
        }
    }
}
