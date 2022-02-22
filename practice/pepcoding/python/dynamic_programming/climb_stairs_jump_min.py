import sys

class climbStairsWithMinJumps:

    def recursion(self, arr, idx):
        if(idx >= len(arr)):
            return 0
        
        ans = sys.maxsize

        for i in range(1, arr[idx] + 1):
            ans = min(ans, self.recursion(arr, idx+i))

        return 1 + ans

    def memoization(self, arr, idx, dp):
        
        if(idx >= len(arr)):
            return 0

        if(dp[idx] != 0):
            return dp[idx]

        ans = sys.maxsize

        for i in range(1, arr[idx] + 1):
            ans = min(ans, self.memoization(arr, idx+i, dp))
        
        dp[idx] = 1 + ans
        
        return 1 + ans

    def tabulation(self, arr):
        dp = [0] * (len(arr) + 1)

        for i in range(len(arr)-2, -1, -1):

            ans = sys.maxsize

            for j in range(1, arr[i] + 1):
                if(i + j < len(arr)):
                    ans = min(ans, dp[i+j])
            
            dp[i] = 1 + ans
        
        return dp[0]

if __name__ == "__main__":
    
    n = 10
    arr = [3, 3, 0, 2, 1, 2 , 4, 2, 0, 0]
    obj = climbStairsWithMinJumps()
    dp = [0] * (n+1)
    print(obj.recursion(arr, 0))
    print(obj.memoization(arr, 0, dp))
    print(obj.tabulation(arr))