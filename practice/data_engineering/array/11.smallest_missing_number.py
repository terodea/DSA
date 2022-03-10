__doc__ = """
http://www.geeksforgeeks.org/find-the-first-missing-number/
"""
class BruteForce:
    """
    For i = 0 to m-1, do binary search for i in the array. If i is not present in the array then return i.
    Time Complexity: O(m log n) 
    """
    def findSmallestMissinginSortedArray(self, arr):
        n = max(arr)

        for i in range(0, n+1):
            if i not in arr:
                return i

        return max(arr)+1

class HashMap:
    """
    Store all array elements in a hash map and find missing element starting from 0 till max element in array.
    """
    def findSmallestMissing(self, arr):
        hash_map = {}
        for i in arr:
            hash_map[i] = 1
        
        for i in range(0, max(arr)):
            if i not in hash_map:
                return i
        
        return max(arr)+1

class LinearSearch:
    """
    If arr[0] is not 0, return 0. Otherwise traverse the input array starting from index 0, 
    and for each pair of elements a[i] and a[i+1], find the difference between them. 
    If the difference is greater than 1 then a[i]+1 is the missing number. 
    Time Complexity: O(n)
    """
    def findSmallestMissing(self, arr):
        if arr[0] != 0:
            return 0

        for i in range(0, len(arr)):
            if abs(arr[i] - arr[i+1]) > 1:
                return arr[i]+1
        return max(arr)+1
class ModifiedBinarySearch:
    """
    In the standard Binary Search process, the element to be searched is compared with the middle element and on the basis of comparison result, we decide whether to search is over or to go to left half or right half. 
    In this method, we modify the standard Binary Search algorithm to compare the middle element with its index and make decision on the basis of this comparison.

        If the first element is not same as its index then return first index
        Else get the middle index say mid
        If arr[mid] greater than mid then the required element lies in left half.
        Else the required element lies in right half.
    """
    def findFirstMissing(self, array, start, end):
 
        if (start > end):
            return end + 1
    
        if (start != array[start]):
            return start;
    
        mid = int((start + end) / 2)
    
        # Left half has all elements
        # from 0 to mid
        if (array[mid] == mid):
            return self.findFirstMissing(array, mid+1, end)
    
        return self.findFirstMissing(array, start, mid)

class RecursiceBinarySearch:
    """
    The idea is to use Recursive Binary Search to find the smallest missing number. Below is the illustration with the help of steps:
        If the first element of the array is not 0, then the smallest missing number is 0.
        If the last elements of the array is N-1, then the smallest missing number is N.
        Otherwise, find the middle element from the first and last index and check if the middle element is equal to the desired element. i.e. first + middle_index.
        If the middle element is the desired element, then the smallest missing element is in the right search space of the middle.
        Otherwise, the smallest missing number is in the left search space of the middle.
    >>> obj = RecursiceBinarySearch()
    >>> arr = [ 0, 1, 2, 3, 4, 5, 7 ]
    >>> n = len(arr)
    >>> obj.findSmallestMissinginSortedArray(arr)
    TC: O(Log N)
    SC: O(Log N)
    """
    def findSmallestMissinginSortedArray(self, arr): 
        # Check if 0 is missing 
        # in the array
        if (arr[0] != 0):
            return 0
        
        # Check is all numbers 0 to n - 1 
        # are present in array
        if (arr[-1] == len(arr) - 1):
            return len(arr)
        
        first = arr[0]
        
        return self.findFirstMissing(arr, 0, len(arr) - 1, first)
 
    # Function to find missing element 
    def findFirstMissing(self, arr, start, end, first):
        
        if (start < end):
            mid = int((start + end) / 2)
            
            # Index matches with value 
            # at that index, means missing
            # element cannot be upto that point
            if (arr[mid] != mid + first):
                return self.findFirstMissing(arr, start, mid, first)
            else:
                return self.findFirstMissing(arr, mid + 1, end, first)
        
        return start + first