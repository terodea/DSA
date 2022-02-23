from types import List

class Solution:
    """
    https://leetcode.com/problems/majority-element
    TC: O(n)
    SC: O(n)
    """
    def majorityElement(self, nums: List[int]) -> int:
        hashmap = {}
        n = len(nums)

        for i in nums:
            if i in hashmap:
                hashmap[i] += 1
            else:
                hashmap[i] = 1

        count = 0
        for key in hashmap.keys():
            _val = hashmap.get(key)

            if _val > n/2:
                count += 1
        
        return count

class Solution2:
    """
    Moore's Voting Algorithm
    TC: O(n)
    SC: O(1)
    """
    def majorityElement(self, nums: List[int]) -> int:
        count=0 
        candidate = 0
        for num in nums:
            if (count==0): candidate = num
            if (num!=candidate): count-= 1
            else: count+=1
        return candidate
