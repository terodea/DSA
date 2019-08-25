class Node:

    def __init__(self):
        """
        Constructor
        """
        self.data = None 
        self.next = None 

    def setData(self,data):
        """
        Method for setting the data field of the node.
        """
        self.data = data

    def getData(self,data):
        """
        Method for getting the data field of the node. 
        """
        return self.data 

    def setNext(self,next):
        """
        Method for setting the next field of the node.
        """
        self.next = next

    def getNext(self,next):
        """
        Method for getting the next field of the node.
        """
        return self.next

    def hasNext(self):
        """
        Returns true if the node points to another node.
        """
        return self.next != None 

class Stack(object):
    def __init__(self,data = None):
        self.head = None 
        if data:
            for data in data:
                self.push(data)
    def push(self,data):
        temp = Node()
        temp.setData(data)
        temp.setNext(self.head)
        self.head = temp

    def pop(self,data):
        if self.head is None:
            raise IndexError
        temp = self.head.getData()
        self.head = self.head.getNext()
        return temp

    def peek(self,data):
        if self.head is None:
            raise IndexError
        return self.head.getData()

if __name__ == '__main__':
    our_list = ["first","second","third","fourth"]
    our_stack = Stack(our_list)
    print(our_stack.pop())
    print(our_stack.peek())
    print(our_stack.pop())
    print(our_stack.peek())

