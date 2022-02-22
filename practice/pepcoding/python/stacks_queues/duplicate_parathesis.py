from stacks import Stack

class duplicateParam:
    """
    (a + b) + ((c + d))
    """

    def evaluate(self, string):
        """
        """
        try:
            st = Stack()

            for i in range(0, len(string)):
                ch = string[i]

                if(ch == ')'):
                    if(st.peek() == '('):
                        print(True)
                        return
                    else:
                        while(st.peek() != '(' ):
                            st.pop()
                        st.pop()
                elif(ch == ']'):
                    if(st.peek() == '['):
                        print(True)
                        return
                    else:
                        while(st.peek() != '[' ):
                            st.pop()
                        st.pop()
                elif(ch == '}'):
                    if(st.peek() == '{'):
                        print(True)
                        return
                    else:
                        while(st.peek() != '{' ):
                            st.pop()
                        st.pop()
                else:
                    st.push(ch)
            print(False)
            return

        except Exception as e:
            raise e


if __name__ == "__main__":
    obj = duplicateParam()
    obj.evaluate(string= "(a + b) + ((c + d))") # True
    obj.evaluate(string= "{[[a + b]] + (c + d)}") # True