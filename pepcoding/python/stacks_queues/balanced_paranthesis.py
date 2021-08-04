from stacks import Stack

class balancedParam:

    def evaluate(self, string):
        """
        """
        try:
            st = Stack()
            for i in range(0, len(string)):
                ch = string[i]
                if(ch == '(' or ch == '[' or ch == '{'):
                    st.push(ch)
                elif(ch == ')' or ch == ']' or ch == '}'):
                    if(ch == ')'):
                        if(st.size() != 0 and st.peek() == '('):
                            st.pop()
                        else:
                            print(False)
                            return
                    elif(ch == ']'):
                        if(st.size() != 0 and st.peek() == '['):
                            st.pop()
                        else:
                            print(False)
                            return
                    elif(ch == '}'):
                        if(st.size() != 0 and st.peek() == '{'):
                            st.pop()
                        else:
                            print(False)
                            return
            
            if(st.size() != 0):
                print(False)
                return
            else:
                print(True)
                return

        except Exception as e:
            raise e


if __name__ == "__main__":
    balancedParam().evaluate(string="[(a + b) + {(c + d) * (e / f)}]") # True
    balancedParam().evaluate(string="[(a + b) + {(c + d) * (e / f)]}") # False