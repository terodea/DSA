from stacks import Stack

class nextGreaterToRight:
    """
        1. You are given a number n, representing the size of array a.
        2. You are given n numbers, representing elements of array a.
        3. You are required to "next greater element on the right" for all elements of array
        4. Input and output is handled for you.

        "Next greater element on the right" of an element x is defined as the first element to right of x having value greater than x.
        Note -> If an element does not have any element on it's right side greater than it, consider -1 as it's "next greater element on right"
        e.g.
        for the array [2 5 9 3 1 12 6 8 7]
        Next greater for 2 is 5
        Next greater for 5 is 9
        Next greater for 9 is 12
        Next greater for 3 is 12
        Next greater for 1 is 12
        Next greater for 12 is -1
        Next greater for 6 is 8
        Next greater for 8 is -1
        Next greater for 7 is -1
    """

    def evaluate(self, arr=[]):
        """
        Evaluate from left to right.
        """
        try:
            st = Stack()
            ans = []
            st.push(0)

            for i in range(1, len(arr)):
                while(st.size() > 0 and arr[st.peek()] < arr[i]):
                    ans.insert(st.pop(), arr[i])
                
                st.push(i)

            while(st.size() > 0):
                ans.insert(st.pop(), -1)

            return ans
        except Exception as e:
            raise e 
    
    def right_to_left(self, arr=[]):
        try:
            st = Stack()
            ans = [0] * len(arr)

            for i in range(len(arr)-1, -1, -1):
                
                while(st.size() > 0 and arr[st.peek()] <= arr[i]):
                    st.pop()
                
                if(st.size() == 0):
                    ans[i] = -1
                else:
                    ans[i] = arr[st.peek()]
                    
                st.push(i)
            return ans

        except Exception as e:
            raise e 

if __name__ == "__main__":
    _arr = [2, 5, 9, 3, 1, 12, 6, 8, 7]
    print(nextGreaterToRight().evaluate(arr=_arr))
    print(nextGreaterToRight().right_to_left(arr=_arr))