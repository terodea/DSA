from types import List

class Solution:
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
    """
    def majorityElement(self, nums: List[int]) -> int:
        count=0 
        ret = 0
        for num in nums:
            if (count==0): ret = num
            if (num!=ret): count-= 1
            else: count+=1
        return ret

