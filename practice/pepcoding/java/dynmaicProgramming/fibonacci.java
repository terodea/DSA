import java.io.*;
import java.util.*;

public class fibonacci{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] dp = new int[n+1];
        System.out.println(fibonacciMemoization(n, dp));
        System.out.println(fibonacciTabulation(n, dp));
    }

    public static int fibonacciMemoization(int n, int[] dp){
        /*Top Down Approach Memoization */
        if(n == 0 || n==1) return n;
        if(dp[n] != 0) return dp[n];
        int fibSum = fibonacciMemoization(n-1, dp) + fibonacciMemoization(n-2, dp);
        dp[n] = fibSum;
        return fibSum;

    }

    public static int fibonacciTabulation(int n, int[] dp){
        /*Bottom Up Approach Tabulation*/
        for(int i=0; i<=n; i++){
            if(i == 0 || i == 1){
                dp[i] = i;
            }
            else{
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[n];
    }
}
