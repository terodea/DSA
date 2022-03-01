from typing import List

class PrefixArray:
    """
    Prefix Sum Array Concept:
    TC: O(N)
    SC: O(N)
    """
    def productExceptSelf(self, arr: List[int]) -> List[int]:
        leftProduct = []
        rightProduct = []
        res = []
        n = len(arr)
        leftProduct[0] = arr[0]
        for i in range(0, n):
            leftProduct[i] = leftProduct[i-1] * arr[i]
        
        rightProduct[n - 1] = arr[n-1]
        for i in range(0, n-2, -1):
            rightProduct[i] = rightProduct[i+1] * arr[i]
        
        res[0] = rightProduct[1];
        res[n - 1] = leftProduct[n - 2]
        
        for i in range(1, n-1):
            res[i] = leftProduct[i-1] * rightProduct[i+1]
        return res
class PrefixArraySpaceOp:
    """
    TC: O(N)
    SC: O(1) (Ignore Output file as an extra space)
    We can calculate ans without maintaining two extra pre and suf arrays.

    We can initialize the result array ans of length equal to nums filled with 1.
    Then, for each i, we can calculate prefix product (without self), i.e, ans[i] = ans[i-1]*nums[i-1]. This is same as calculating pre in previous approach but this time we are storing it within our result array.
    Then we iterate from the last index with a variable suffixProd=1 denoting suffix product. For each i, we multiply ans[i] with suffixProd. Each time we will also update suffixProd = suffixProd * nums[i].
    The above again gives us product of array except self at each index. This is because, firstly we are storing prefix product (without self) in ans and then multiplying each ans[i] with suffix product which is the same that we did in the previous approach.
    """
    def productExceptSelf(self, nums):
        n, ans, suffix_prod = len(nums), [1]*len(nums), 1
        for i in range(1,n):
            ans[i] = ans[i-1] * nums[i-1]
        for i in range(n-1,-1,-1):
            ans[i] *= suffix_prod
            suffix_prod *= nums[i]
        return ans
class PrefixArraySpaceOnePass:
    """
    The above process can be done in single pass as well. We were first calculating prefix product in one loop and then multiplying it with suffix product in another loop. These two process are independent of each other and can be done in the same loop. We just need to keep another prefix product variable similar to suffix_prod in previous approach.
    We iterate from start and keep calculating prefix product & update corresponding ans[i] & at the same time we can calculate keep calculating suffix product from the end & update ans[n-1-i].
    TC: O(N)
    SC: O(1)

    """
    def productExceptSelf(self, nums):
        ans, suf, pre = [1]*len(nums), 1, 1
        for i in range(len(nums)):
            ans[i] *= pre               # prefix product from one end
            pre *= nums[i]
            ans[-1-i] *= suf            # suffix product from other end
            suf *= nums[-1-i]
        return ans

class Solution:
    """
    TC: O(N)
    SC: O(1)
    """
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        countZero = 0
        indexZero = 0
        product = 1
        for i in range(len(nums)):
            num = nums[i]
            if num == 0:
                countZero += 1
                indexZero = i
            else:
                product *= num
        if countZero >= 2:
            return [0] * len(nums)
        elif countZero == 1:
            res = [0] * len(nums)
            res[indexZero] = product
            return res
        else:
            for i in range(len(nums)):
                nums[i] = product // nums[i]
            return nums