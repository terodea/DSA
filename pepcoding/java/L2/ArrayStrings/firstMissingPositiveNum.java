public class firstMissingPositive{

	public static void main(String[] args){
		int[] arr = {3,4,-1,1};
		firstMissingPositive(arr);
	}

	public static int firstMissingPositive(int[] arr) {
		boolean one = false;
        int n = nums.length;
        
        for(int i=0; i<n; i++){
            
            if(nums[i] == 1) one = true;
            
            if(nums[i] < 1 || n < nums[i]) nums[i] = 1;
        }
        
        if(one == false) return 1;
        
        for(int i=0; i<n; i++){
            
            int val = Math.abs(nums[i]);
            int idx = val-1;
            nums[idx] = -Math.abs(nums[idx]);
            
        }
        
        for(int i=0; i<n; i++){
            if(nums[i] > 0){
                return i+1;
            }
        }
        return n+1;
	}

	public static int firstMissingPositiveII(int[] arr) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		for(int i=0; i<arr.length; i++){
			hm.put(arr[i],1);
		}
		
		for(int i=1; i<arr.length; i++){
			
			if(!(hm.containsKey(i))){
				return i;
			}
		}
		return arr.length + 1;
	}

}
