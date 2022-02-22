import sys
import copy

class goldMine:
    """
        OBJECTIVE:
            1. You are given a number n, representing the number of rows.
            2. You are given a number m, representing the number of columns.
            3. You are given n*m numbers, representing elements of 2d array a, which represents a gold mine.
            4. You are standing in front of left wall and are supposed to dig to the right wall. You can start from 
                any row in the left wall.
            5. You are allowed to move 1 cell right-up (d1), 1 cell right (d2) or 1 cell right-down(d3).
        INPUT:
            6
            6
            0 1 4 2 8 2
            4 3 6 5 0 4
            1 2 4 1 4 6
            2 0 7 3 2 2
            3 1 5 9 2 4
            2 7 0 8 5 1

        OUTPUT:
            33
    """

    def recursion(self, arr, sr, sc):

        if(sr < 0 or sr >= len(arr)):
            return -(10 ** 9)
        
        if(sc == len(arr[0]) - 1):
            return arr[sr][sc]
        
        return max(self.recursion(arr, sr-1, sc + 1), self.recursion(arr, sr, sc+1), self.recursion(arr, sr+1, sc+1)) + arr[sr][sc]
    
    def memoization(self, arr, sr, sc, dp):

        if(sr < 0 or sr >= len(arr)):
            return -(10 ** 9)
        
        if(sc == len(arr[0]) - 1):
            return arr[sr][sc]

        if(dp[sr][sc] != 0):
            return dp[sr][sc]
        
        dp[sr][sc] = max(self.memoization(arr, sr-1, sc + 1, dp), self.memoization(arr, sr, sc+1, dp), self.memoization(arr, sr+1, sc+1, dp)) + arr[sr][sc]

        return dp[sr][sc]

    def tabulation(self, arr):
        dp = [[0] * len(arr[0]) for _ in range(len(arr))]

        for col in range(len(arr[0])-1, -1, -1):
            for row in range(0, len(arr)):
                val = copy.deepcopy(arr[row][col])

                if (col == len(arr[0]) - 1):
                    dp[row][col] = val

                elif (row == 0):
                    dp[row][col] = val + max(dp[row][col+1], dp[row+1][col+1])
                
                elif (row == len(arr) - 1):
                    dp[row][col] = val + max(dp[row][col+1], dp[row-1][col+1])

                else:
                    dp[row][col] = val + max(dp[row+1][col+1], dp[row][col+1], dp[row-1][col+1])
        
        ans = 0
        for i in range(0, len(dp)):
            ans = max(ans, dp[i][0])

        return ans

if __name__ == "__main__":
    n,m = 6,6
    arr = [
        [0, 1, 4, 2, 8, 2], 
        [4, 3, 6, 5, 0, 4],
        [1, 2, 4, 1, 4, 6], 
        [2, 0, 7, 3, 2, 2], 
        [3, 1, 5, 9, 2, 4], 
        [2, 7, 0, 8, 5, 1]
    ]
    obj = goldMine()
    ans = -(10 ** 9)

    for i in range(0, len(arr)):
        ans = max(ans, obj.recursion(arr, sr=i, sc=0))
    print(ans)

    dp = [[0] * len(arr[0]) for _ in range(len(arr))]
    ans = -(10 ** 9)
    for i in range(0, len(arr)):
        ans = max(ans, obj.memoization(arr, sr=i, sc=0, dp=dp))
    print(ans)

    print(obj.tabulation(arr))

    