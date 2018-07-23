"""
Node : A class for Basic structure of Node
  __init__ = Constructor to initialize node object
LinkedList : A class for Linked List
  __init__ = Constructor to initialize head
  push = Function to insert data at initial position
  DeleteNode = Function to delete node at a given position
    If linked list is empty
    Store head node
    If head needs to be removed
    Find previous node of the node to be deleted
    If position is more than number of nodes
    Node temp.next is the node to be deleted store pointer to the next of node to be deleted
    Unlink the node from linked list
  PrintList = Utility function to print the linked LinkedList
Driver program to test above function
"""

class Node:

    def __init__(self, data):
        self.data = data
        self.next = None


class LinkedList:

    def __init__(self):
        self.head = None

    def push(self, new_data):
        new_node = Node(new_data)
        new_node.next = self.head
        self.head = new_node

    def deleteNode(self, position):
        if self.head = None:
            return
        temp = self.head
        if position == 0:
            self.head = temp.next
            temp = None
            return
        for i in range(position-1):
            temp = temp.next
            if temp is None:
                break
        if temp or temp.next is None:
            return
        next = temp.next.next
        temp.next = None
        temp.next = next

    def PrintList(self):
        temp = self.head
        while(temp):
            print "%d" % (temp.data),
            temp = temp.next

# Driver program to test above function
llist = LinkedList()
llist.push(7)
llist.push(1)
llist.push(3)
llist.push(2)
llist.push(8)

print "Created Linked List: "
llist.printList()
llist.deleteNode(4)
print "\nLinked List after Deletion at position 4: "
llist.printList()
