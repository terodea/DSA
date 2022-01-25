public class productExceptSelf{
    public int[] productExceptSelf(int[] nums) {
        int left = 1, right = 1, n=nums.length;
        int[] res = new int[n];
        
        for(int i=0; i<n; i++){
            if(i > 0) left = left * nums[i-1];
            res[i] = left;
        }
        
        for(int i=n-1; i>=0; i--){
            if(i < (n-1)) right = right * nums[i+1];
            res[i] *= right;
        }
        return res;
    }

    public int[] productExceptSelf2(int[] arr){
        int[] leftProduct = new int[arr.length];
        int[] rightProduct = new int[arr.length];
        int[] res = new int[arr.length];
        
        leftProduct[0] = arr[0];
        for(int i=1; i<arr.length; i++){
            leftProduct[i] = leftProduct[i-1] * arr[i];  
        }
        
        rightProduct[arr.length - 1] = arr[arr.length-1];
        for(int i=arr.length - 2; i>=0; i--){
            rightProduct[i] = rightProduct[i+1] * arr[i];
        }
        
        res[0] = rightProduct[1];
        res[arr.length - 1] = leftProduct[arr.length - 2];
        
        for(int i=1; i<arr.length - 1; i++){
            res[i] = leftProduct[i-1] * rightProduct[i+1];
        }
        
        return res;
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,4};
        System.out.println(productExceptSelf(nums));
    }
}
