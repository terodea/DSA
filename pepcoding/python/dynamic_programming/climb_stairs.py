class climbStairs:
    """
    1. You are given a number n, representing the number of stairs in a staircase.
    2. You are on the 0th step and are required to climb to the top.
    3. In one move, you are allowed to climb 1, 2 or 3 stairs.
    4. You are required to print the number of different paths via which you can climb to the top.
    """

    def recursion(self, n):
        if(n == 0): return 1
        elif(n <= 0): return 0

        return self.recursion(n-1) + self.recursion(n-2) + self.recursion(n-3)

    def memoization(self, n, dp):

        if(n == 0): return 1
        elif(n < 0 ): return 0

        if(dp[n] != 0): return dp[n]

        dp[n] = self.memoization(n-1, dp) + self.memoization(n-2, dp) + self.memoization(n-3, dp)
        return dp[n]

    def tabulation(self, n):

        dp = [0] * (n+1)

        for i in range(0, n+1):
            if(i == 0): dp[i] = 1
            elif(i == 1): 
                dp[i] = dp[i-1]
            elif(i == 2):
                dp[i] = dp[i-1] + dp[i-2]
            else:
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3]

        return dp[n]

if __name__ == "__main__":
    obj = climbStairs()
    n=int(input("Enter no of steps\t"))
    dp = [0] * (n+1)
    #print(obj.recursion(n))
    #print(obj.memoization(n, dp))
    print(obj.tabulation(n))
