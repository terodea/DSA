import sys

class mazeTravelMin:
    """
        1. You are given a number n, representing the number of rows.
        2. You are given a number m, representing the number of columns.
        3. You are given n*m numbers, representing elements of 2d array a, which represents a maze.
        4. You are standing in top-left cell and are required to move to bottom-right cell.
        5. You are allowed to move 1 cell right (h move) or 1 cell down (v move) in 1 motion.
        6. Each cell has a value that will have to be paid to enter that cell (even for the top-left and bottom- 
            right cell).
        7. You are required to traverse through the matrix and print the cost of path which is least costly.

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
        23
    """
    def recursion(self, arr, sr, sc):
        if(sr >= len(arr) or sc >= len(arr[0])):
            return sys.maxsize
        
        if(sr == len(arr) - 1 and sc == len(arr[0]) - 1):
            return arr[sr][sc]
        
        return min(self.recursion(arr, sr+1, sc), self.recursion(arr, sr, sc+1)) + arr[sr][sc]
    
    def memoization(self, arr, sr, sc, dp):
        if(sr >= len(arr) or sc >= len(arr[0])):
            return sys.maxsize
        
        if(sr == len(arr) - 1 and sc == len(arr[0]) - 1):
            return arr[sr][sc]

        if(dp[sr][sc] != 0):
            return dp[sr][sc]

        dp[sr][sc] = min(self.recursion(arr, sr+1, sc), self.recursion(arr, sr, sc+1)) + arr[sr][sc]
        return dp[sr][sc]
    
    def tabulation(self, arr):
        """
        Fills from last bottom right to top left.
        """
        dp = [[0] * m] * n

        for i in range(len(arr)-1, -1, -1):
            for j in range(len(arr[0]) - 1, -1, -1):
                if(i == arr.__len__() - 1 and j == arr[0].__len__()-1): # arr[n-1][m-1] as it is
                    dp[i][j] = arr[i][j]

                elif(i == arr.__len__() - 1):
                    dp[i][j] = dp[i][j+1] + arr[i][j] # last row

                elif(j == arr[0].__len__() - 1): #last column
                    dp[i][j] = dp[i+1][j] + arr[i][j]

                else:
                    dp[i][j] = min(dp[i+1][j], dp[i][j+1]) + arr[i][j]
        
        return dp[0][0]

if __name__ == '__main__':

    obj = mazeTravelMin()
    n,m = 6,6
    arr = [
        [0, 1, 4, 2, 8, 2], 
        [4, 3, 6, 5, 0, 4],
        [1, 2, 4, 1, 4, 6],
        [2, 0, 7, 3, 2, 2],
        [3, 1, 5, 9, 2, 4],
        [2, 7, 0, 8, 5, 1]
    ]
    dp = [[0] * m] * n
    print(obj.recursion(arr=arr, sr=0, sc=0))
    print(obj.memoization(arr, 0 , 0, dp))
    print(obj.tabulation(arr))