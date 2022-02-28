__doc__ = """
https://www.geeksforgeeks.org/leaders-in-an-array/
https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
1. Brute Force: Two Loop
Use two loops. The outer loop runs from 0 to size – 1 and one by one picks all elements from left to right. 
The inner loop compares the picked element to all the elements to its right side. 
If the picked element is greater than all the elements to its right side, then the picked element is the leader.
2. Optmized: Scan from Right
Scan all the elements from right to left in an array and keep track of maximum till now. When maximum changes its value, print it.
"""

class BruteForce:
    """
    Time Complexity: O(n*n)
    Space Complexity: O(1)
    """
    def printLeaders(self, arr,size):
        """
        >>> arr=[16, 17, 4, 3, 5, 2]
        >>> obj = BruteForce()
        >>> obj.printLeaders(arr, len(arr))
        """
        for i in range(0, size):
            for j in range(i+1, size):
                if arr[i]<=arr[j]:
                    break
            if j == size-1: # If loop didn't break
                print (arr[i],end=' ')

class Optimized1:
    """
    Time Complexity: O(n)
    Space Complexity: O(1)
    """
    def printLeaders(arr, size):
        """
        >>> arr = [16, 17, 4, 3, 5, 2]
        >>> obj = Optimized1()
        >>> printLeaders(arr, len(arr))
        """    
        max_from_right = arr[size-1]  
        print(max_from_right,end=' ')   
        for i in range( size-2, -1, -1):       
            if max_from_right < arr[i]:       
                print (arr[i],end=' ')
                max_from_right = arr[i]