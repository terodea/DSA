class Fibonacci:

    def recursion(self, n):
        if(n == 0 or n == 1):
            return n
        return self.recursion(n-1) + self.recursion(n-2)



    def memoization(self, n, dp):
        if(n == 0 or n == 1):
            return n

        if(dp[n] != 0):
            return dp[n]

        ans = self.memoization(n-1, dp) + self.memoization(n-2, dp)
        dp[n] = ans
        return ans

    def tabulation(self, n):
        dp = [0] * (n+1)

        for i in range(0, n+1):
            if(i == 0 or i == 1):
                dp[i] = i
            else:
                dp[i] = dp[i-1] + dp[i-2]

        return dp[n];

if __name__ == '__main__':
    obj = Fibonacci()
    n = int(input("Enter the number."))
    dp = [0] * (n+1)
    #print(obj.recursion(n))

    #print(obj.memoization(n, dp))

    print(obj.tabulation(n))
