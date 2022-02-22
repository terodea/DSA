class pairWithMaxSum{

    public static long pairWithMaxSum(long[] arr, long N){
        long max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length-1; i++){
            max = Math.max(max, arr[i] + arr[i+1]);
        }
        return max;
    }

    public static void main(String[] args){
        long[] arr = {4,3,1,5,6};
        System.out.println(pairWithMaxSum(arr, arr.length));
    }
}