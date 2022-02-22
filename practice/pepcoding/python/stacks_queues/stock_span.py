from stacks import Stack
class stockSpan:
    """
        1. You are given a number n, representing the size of array a.
        2. You are given n numbers, representing the prices of a share on n days.
        3. You are required to find the stock span for n days.
        4. Stock span is defined as the number of days passed between the current day and the first day before today when price was higher than today.

        e.g.
        for the array [2 5 9 3 1 12 6 8 7]
        span for 2 is 1
        span for 5 is 2
        span for 9 is 3
        span for 3 is 1
        span for 1 is 1
        span for 12 is 6
        span for 6 is 1
        span for 8 is 2
        span for 7 is 1
    """

    def evaluate(self, arr):
        """
        [2, 5, 9, 3, 1, 12, 6, 8, 7]
        [1, 2, 3, 1, 1, 6, 1, 2, 1]
        """
        try:
            ans = [0] * len(arr)
            st = Stack()
            ans[0] = 1
            st.push(0)
            for i in range(1, len(arr)):
                while(st.size() > 0 and arr[st.peek()] < arr[i]):
                    st.pop()
                
                if(st.size() == 0):
                    ans[i] = i + 1
                else:
                    ans[i] = i - st.peek()

                st.push(i)
            return ans
        except Exception as e:
            raise e

if __name__ == "__main__":
    print(stockSpan().evaluate(arr=[2, 5, 9, 3, 1, 12, 6, 8, 7]))