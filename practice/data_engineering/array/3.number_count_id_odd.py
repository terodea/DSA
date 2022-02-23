from functools import reduce
from typing import List
__doc__ = """
    https://leetcode.com/problems/single-number/
    Approaches:

    Brute Force
    Intuition:
    Iterate through every element in the nums and check if any of the element does not appear twice, in that case return the element.
    Time: O(n^2)
    Space: O(1)

    Use Sorting
    Intuition:
    If the elements of the nums array are sorted/when we sort it, we can compare the neighbours to find the single element. It is already mentioned that all other elements appear twice except one.
    Time: O(nlogn) for sorting then O(n) to check neighbouring elements
    Space: O(1)

    Use Hashing/Set
    Intuition:
    i) As we iterate through the nums array we store the elements encountered and check if we find them again while iteration continues. While checking if we find them again, we maintain a single_element object/variable which stores that single element, eventually returning the single_element.
    ii) The other way is to maintain a num_frequency hashmap/dictionary and iterate over it to find which has exactly 1 frequency and return that key/num.
    Time: O(n) for iterating over the nums array
    Space: O(n) for hashing

    Use Xor/Bit Manipulation
    Intuition:
    Xor of any two num gives the difference of bit as 1 and same bit as 0.
    Thus, using this we get 1 ^ 1 == 0 because the same numbers have same bits.
    So, we will always get the single element because all the same ones will evaluate to 0 and 0^single_number = single_number.
    Time: O(n)
    Space: O(1)
"""

class BitwiseXOR:
    """
    TC: O(n)
    SCL O(1)
    """
    def singleNumber(self, nums: List[int]) -> int:
        x = 0
        for i in nums:
            x ^= i
        return x

class ReduceBitWiseXOR:
    def singleNumber(self, nums: List[int]) -> int:
        return reduce(lambda total, num: total ^ num, nums)

class HashMapApproach:
    """
    TC: O(n)
    SC: O(n)
    """
    def singleNumber(self, nums: List[int]) -> int:
        hashmap = dict()

        for i in nums:
            hashmap[i] = hashmap.get(i, 0) + 1
        
        for num in hashmap.keys():
            if (hashmap.get(num) % 2 != 0):
                return num
