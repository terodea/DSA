class firstNegative{
    public static long[] printFirstKNegativeInteger(long[] A, int n, int k){
        int idx = n;
        long[] res = new long[n - (k-1)];

        for(int i = n-1; i >= n-k; i--){
            if(A[i] < 0) idx = i;
        }

        for(int i = n-k; i >= 0; i--){
            if(A[i] < 0) idx = i;
            
            if(idx < i+k) res[i] = A[idx];
            else res[i] = 0;
        }
        return res;
    }

    public static void main(String[] args){
        long arr[] = {-8,2,3,-6,10};
        int n = arr.length;
        int k = 2;
        long[] ans = printFirstKNegativeInteger(arr, n, k);

        for(long each: ans) System.out.print(each + " ");
        System.out.println();
    }
}