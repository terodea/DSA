import copy
from typing import List
__doc__ = """
https://leetcode.com/problems/merge-sorted-array/
Approaches:

Brute Force:
Append nums2 list data to nums1 list and sort num1
TC: O(NlogN)
SC: O(1)

Merge of Merge Sort:
A modification of merging of two sorted array's utility in merge sort method.
TC: O(n)
SC: O(n)

Optimized Solution:
Iterate untill second array is merged into first one by and idx pointer.
If first array element pointed by the idx is greater than second index pointer:
    then copy firt array element pointed by the index in the idx and decrease first array idx.
else:
    copy second array element pointed by the index in the idx and decrease second array idx.
decrease global idx which points to index location for element insertion.
TC: O(N)
SC: O(1)
"""
class BruteForce:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        >>> obj = BruteForce()
        >>> obj.merge(nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3)
        >>> obj.nums1 == [1,2,2,3,5,6]
        TC: O(NlogN)
        SC: O(1)
        """
        idx = copy.deepcopy(m)
        n_idx = 0
        while( idx < m+n):
            nums1[idx] = nums2[n_idx]
            idx += 1
            n_idx += 1

        nums1.sort()

class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        >>> obj = Solution()
        >>> obj.merge(nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3)
        >>> obj.nums1 == [1,2,2,3,5,6]
        TC: O(N)
        SC: O(1)
        """
        a, b, write_index = m-1, n-1, m + n - 1
        
        while b >= 0:
            if a >= 0 and nums1[a] > nums2[b]:
                nums1[write_index] = nums1[a]
                a -= 1
            else:
                nums1[write_index] = nums2[b]
                b -= 1

            write_index -= 1

class MergeTwoSortedArraySolution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        ALGORITHM:
            Procedure used in merge_sort's merge step is written below. 
        >>> obj = MergeTwoSortedArraySolution()
        >>> obj.merge(nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3)
        >>> obj.nums1 == [1,2,2,3,5,6]
        TC: O(n)
        SC: O(n)
        """
        ans = [0] * (m+n)
        i,j, idx = 0, 0, 0

        while(i < m and j < n):
            if (nums1[i] < nums2[j]):
                ans[idx] = nums1[i]
                idx += 1
                i += 1
            
            else:
                ans[idx] = nums2[j]
                idx += 1
                j += 1
        
        while(i < m):
            ans[idx] = nums1[i]
            idx += 1
            i += 1
        
        while(j < n):
            ans[idx] = nums2[j]
            idx += 1
            j += 1
        
        nums1 = copy.deepcopy(ans)