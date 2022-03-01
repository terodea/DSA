class Solution:
    def segregate0and1(self, arr, n) : 
        # Counts the no of zeros in arr
        count = 0
    
        for i in range(0, n) :
            if (arr[i] == 0) :
                count = count + 1
    
        # Loop fills the arr with 0 until count
        for i in range(0, count) :
            arr[i] = 0
    
        # Loop fills remaining arr space with 1
        for i in range(count, n) :
            arr[i] = 1

class TwoPointer:
    """
    Maintain two indexes. Initialize the first index left as 0 and second index right as n-1.
        Do following while left < right 
        a) Keep incrementing index left while there are 0s at it 
        b) Keep decrementing index right while there are 1s at it 
        c) If left < right then exchange arr[left] and arr[right
    >>> obj = TwoPointer()
    >>> arr = [0, 1, 0, 1, 1, 1]
    >>> arr_size = len(arr)
    >>> print("Array after segregation")
    >>> print(obj.segregate0and1(arr, arr_size))
    Time Complexity: O(n)
    Space Complexity: O(1)
    """
    def segregate0and1(self, arr, size):
        # Initialize left and right indexes
        left, right = 0, size-1
        
        while left < right:
            # Increment left index while we see 0 at left
            while arr[left] == 0 and left < right:
                left += 1
    
            # Decrement right index while we see 1 at right
            while arr[right] == 1 and left < right:
                right -= 1
    
            # If left is smaller than right then there is a 1 at left
            # and a 0 at right. Exchange arr[left] and arr[right]
            if left < right:
                arr[left] = 0
                arr[right] = 1
                left += 1
                right -= 1
    
        return arr

class SortO1Optimized:
    """
    A dutch national flag based approach.
    TC: O(n)
    SC: O(1)
    """
    def segregate0and1(self, arr, size):
        one_index = 0
        for i in range(0, size):
            if(arr[i] == 0):
                self.swap(arr, i, one_index)
                one_index += 1

    def swap(self, arr, i, j):
        temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp