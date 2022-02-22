import java.io.*;
import java.util.*;

public class climbStairs{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] dp = new int[n+1];
        System.out.println(climbStairsMemoization(n, dp));
        System.out.println(climbStairsTabulation(n, dp));
    }

    public static int climbStairsMemoization(int n, int[] dp){
        if(n == 0) return 1;
        else if(n < 0 ) return 0;
        else{
            if(dp[n] > 0) return dp[n];
            int steps = climbStairsMemoization(n - 1, dp) + climbStairsMemoization(n - 2, dp) + climbStairsMemoization(n - 3, dp);
            dp[n] = steps;
            return steps;
        }
    }

    public static int climbStairsTabulation(int n, int[] dp){
        for(int i=0; i<n; i++){
            if(i == 0) dp[i] = 1;
            else if (i == 1) dp[i] = dp[i-1];
            else if(i == 2) dp[i] = dp[i - 1] + dp[i - 2];
            else{
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
        }
        return dp[n];
    }
}