public class noOfSubArraysWithBoundedMax{
    public static int numSubarrayBoundedMax(int[] arr, int left, int right) {  
      int prev_count = 0;
      int overall_count = 0;
      int i=0;
      int j=0;
      while(j < arr.length){
          
          if(left <= arr[j] && arr[j] <= right){
              
              prev_count = j - i + 1;
              overall_count += prev_count;
              
          }else if(arr[j] < left){
              
              overall_count += prev_count;
              
          }else{
              prev_count = 0;
              i = j + 1;
          }
          j++;
      }
      return overall_count;
  }

  public static void main(String[] args){
      int[] arr = {2,1,4,3};
      int left = 2;
      int right= 3;
      System.out.println(numSubarrayBoundedMax(arr, left, right));
  }
}