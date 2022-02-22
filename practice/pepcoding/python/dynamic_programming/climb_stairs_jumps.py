class climbStairsJumps:

    """
    1. You are given a number n, representing the number of stairs in a staircase.
    2. You are on the 0th step and are required to climb to the top.
    3. You are given n numbers, where ith element's value represents - till how far from the step you
    could jump to in a single move. You can of course jump fewer number of steps in the move.
    4. You are required to print the number of different paths via which you can climb to the top.

    """
    def recursion(self, arr, idx):
        """

        """
        if (idx == len(arr)):
            return 1

        if(idx > len(arr)):
            return 0

        ans = 0

        for i in range(1, (arr[idx]) + 1):
            ans += self.recursion(arr, idx+i)

        return ans
    
    def memoization(self, arr, idx, dp):

        if(idx == len(arr)):
            return 1
        
        if(idx > (len(arr))):
            return 0

        if(dp[idx] != 0):
            return dp[idx]
        
        ans = 0
        for i in range(1, arr[idx]+1):
            ans += self.memoization(arr, idx+i, dp)
        
        dp[idx] = ans
        return ans
    
    def tabulation(self, arr):
        dp = [0] * (len(arr) + 1)

        dp[-1] = 1

        for i in range(len(arr)-2, -1, -1):
            ans = 0
            for j in range(1, arr[i] + 1):
                ans += dp[i+j]

            dp[i] = ans
        return dp[0]

if __name__ == "__main__":
    # ans == 5
    
    n = 10
    arr = [3, 3, 0, 2, 1, 2 , 4, 2, 0, 0]
    obj = climbStairsJumps()
    dp = [0] * (n+1)
    print(obj.recursion(arr, 0))
    print(obj.memoization(arr, 0, dp))
    print(obj.tabulation(arr))
