from typing import List

class Solution:
    """
        https://leetcode.com/problems/two-sum/
    """
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashmap = {}

        for i in range(len(nums)):
            if nums[i] not in hashmap:
                hashmap[nums[i]] = [i]
            else:
                hashmap[nums[i]].append(i)

        
        for i in nums:
            to_find = target - i

            if to_find in hashmap:
                found_pair = hashmap.get(to_find)
                
                if to_find == i and len(found_pair) >= 2:
                    return [found_pair[0], found_pair[1]]
                elif to_find == i and len(found_pair) == 1:
                    continue
                else:
                    return [nums.index(i), nums.index(to_find)]

class Approach2:

    def twoSum(self, nums: List[int], target: int) -> List[int]:
        rev_table = {}
        for i in range(len(nums)):
            second_addend = target - nums[i]
            if second_addend in rev_table:
                return [rev_table[second_addend], i]
            else:
                rev_table[nums[i]] = i
                