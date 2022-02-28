from typing import List
__doc__ = """ """

class RecursiveSolution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        def numReverse(start, end):
            while start < end:
                nums[start], nums[end] = nums[end], nums[start]
                start += 1
                end -= 1
        k, n = k % len(nums), len(nums)
        if k:
            numReverse(0, n - 1)
            numReverse(0, k - 1)
            numReverse(k, n - 1)

class PythonicSolution:
    def rotate(self, nums:List[int], k: int) -> None:
        """
        """
        n = len(nums)
        k = k % n
        nums[:] = nums[n-k:] + nums[:n-k]

class Solution1:
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        Time complexity : O( n∗k). All the numbers are shifted by one step(O (n)O(n)) k times(O (k)O ( k ) ).
        Space complexity : O(1). No extra space is used.
        """
        for _ in range(k):
            previous = nums[-1] #initiate a first previous 
            for i in range(len(nums)):
                temp = nums[i] #hodl nums[i]
                nums[i] = previous #overwrite the current index 
                previous = temp #swap the value 

class Solution2:
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        We use an extra array in which we place every element of the array at its correct position i.e. the number at index ii in the original array is placed at the index (i+k)%(length of array)(i+k). Then, we copy the new array to the original one.
        Time complexity : O(n). One pass is used to put the numbers in the new array. And another pass to copy the new array to the original one.
        Space complexity :O*(*n). Another array of the same size is used.
        """
        a = [0] * len(nums)
        for i in range(len(nums)):
            a[(i+k)%len(nums)] = nums[i] #recycle

        for i in range(len(nums)):
            nums[i] = a[i]

class Solution3:
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        Time complexity : O(n). Only one pass is used.
        Space complexity : O(1). Constant extra space is used.
        """
        k = k % len(nums)
        count = 0
        start = 0
        while count < len(nums):
            current = start 
            prev = nums[start] #store the value in the position
            
            while True:
                next = (current + k) % len(nums) #
                temp = nums[next] #store it temporaly 
                nums[next] = prev #overide the next 
                prev = temp #reset prev
                current = next #reset current
                count += 1

                if start == current:
                    break 
            
            start += 1

class Solution4:
    """
    This approach is based on the fact that when we rotate the array k times, k%nk elements from the back end of the array come to the front and the rest of the elements from the front shift backwards.
    In this approach, we firstly reverse all the elements of the array. Then, reversing the first k elements followed by reversing the rest n-kn−kelements gives us the required result.
    Let n=7n=7 and k=3k=3.
    Original List                   : 1 2 3 4 5 6 7
    After reversing all numbers     : 7 6 5 4 3 2 1
    After reversing first k numbers : 5 6 7 4 3 2 1
    After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result
    
    Time complexity : O(n) .nnelements are reversed a total of three times.
    Space complexity : O(1). No extra space is used.
    
    """
    def rotate(self, nums, k) -> None:
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        k %= len(nums)
        self.reverse(nums,0,len(nums)-1)
        self.reverse(nums,0, k-1)
        self.reverse(nums,k, len(nums)-1)

    def reverse(self, nums, start, end) -> None:
        """
        :type nums: List[int]
        :type start: int
        :type end: int
        :rtype: None
        """
        while start < end: #
            temp = nums[start]
            nums[start] = nums[end]
            nums[end] = temp 
            start += 1
            end -= 1
