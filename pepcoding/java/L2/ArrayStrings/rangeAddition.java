iimport java.util.*;

public class rangeAddition {

    public static int[] getModifiedArrayBruteForce(int length, int[][] queries) {
        
        int[] ans = new int[length];
        for(int i=0; i<queries.length; i++){
            int start = queries[i][0];
            int end = queries[i][1];
            int work = queries[i][2];
            
            for(int j=start; j<=end; j++){
                ans[j] += work;
            }
        }    
        return ans;
    }

    public static int[] getModifiedArray(int length, int[][] queries) {
        
        int[] ans = new int[length];
        for(int i=0; i<queries.length; i++){
            int start = queries[i][0];
            int end = queries[i][1];
            int work = queries[i][2];
            
            ans[start] += work;
            if(end+1 < length){
                ans[end+1] += -work;
            }
        }
        
        for(int i=1; i<ans.length; i++){
            ans[i] += ans[i-1];
        }
        
        return ans;
    }

    public static void main(String[] args) {
        int length = 5;
        
        int[][] queries = {
            {1,  3,  2},
            {2,  4,  3},
            {0,  2, -2}
        };


        int[] res = getModifiedArray(length, queries);

        for(int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
