class Node:
    def __init__(self):
        self.data = None 
        self.next = None 

    def setData(self,data):
        self.data = data

    def getData(self,data):
        return self.data 

    def setNext(self,next):
        self.next = next

    def getNext(self,next):
        return self.next

    def hasNext(self):
        return self.next != None 

class Stack(object):
    def __init__(self,data = None):
        self.head = None 
        if data:
            for data in data:
                self.push(data)
    def push(self,data):
        pass 

    def pop(self,data):
        pass

    def peek(self,data):
        pass 

if __name__ == '__main__':
    our_list = ["first","second","third","fourth"]
    our_stack = Stack(our_list)
    print(our_stack.pop())
    print(our_stack.peek())
    print(our_stack.pop())
    print(our_stack.peek())

