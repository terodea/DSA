import sys

class targetSumSubSets:
    """
        OBJECTIVE:
            1. You are given a number n, representing the count of elements.
            2. You are given n numbers.
            3. You are given a number "tar".
            4. You are required to calculate and print true or false, if there is a subset the elements of which add  up to "tar" or not.

        INPUT:
            5
            4
            2
            7
            1
            3
            10
        
        OUTPUT:
            true

    """
    def recursion(self, arr, idx, target):
        """
        FAITH: Either the element will come in target or not.
        """
        if(target == 0):
            return True
        
        if(idx == len(arr)):
            return False

        return self.recursion(arr, idx+1, target=target) or self.recursion(arr, idx+1, target-arr[idx])
    
    def memoization(self, arr, idx, target, dp):
        """
        """
        if(target == 0):
            return True
        
        if(idx == len(arr) or target < 0):
            return False

        if(dp[idx] != 0):
            return dp[idx]
        dp[idx] = self.memoization(arr, idx+1, target, dp) or self.memoization(arr, idx+1, target -arr[idx], dp)
        return dp[idx]
    
    def tabulation(self, arr, target):
        dp = [[False] * (target + 1) for _ in range(len(arr))]

        for i in range(0, len(arr)):
            dp[i][0] = True
        
        for i in range(1, len(arr)):
            for j in  range(1, len(dp[0])):
                dp[i][j] = dp[i-1][j]

                if(dp[i][j] == False and (j - arr[i-1]) >= 0):
                    dp[i][j] = dp[i-1][j - arr[i]]
        
        return dp[len(dp)-1][len(dp[0])-1]
if __name__ == "__main__":
    arr = [4, 2, 7, 1, 3]
    target = 10
    obj = targetSumSubSets()
    dp = [0 for i in range(len(arr))] 
    print(obj.recursion(arr, idx=0, target=target))
    print(obj.memoization(arr, idx=0, target=target, dp=dp))
    print(obj.tabulation(arr, target))