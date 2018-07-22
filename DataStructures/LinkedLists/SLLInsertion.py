"""
Single Linked List Insertion Implementation.
InsertBegin: Functio to insert a new node at the beginning
  1. Allocate the Node & Put in the data
  2. Make next of new Node as head
  3. Move the head to point to new Node
InsertAfter: Inserts a new node after the given prev_node.
  1. Check if the given prev_node exists
  2. Create new node & Put in the data
  3. Make next of new Node as next of prev_node
  4. Make next of prev_node as new_node

InsertEnd : Appends a new node at the end.
  1. Create new node & Put in the data.
  2. If the Linked List is empty, then make the new node as head.
  3. Else traverse till the last node
  4. Change the next of last node
  
PrintList : Utility function to print the linked list
"""
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = None

    def InsertBegin(self, new_data):
        new_node = Node(new_data)
        new_node.next = self.head
        self.head = new_node

    def InsertAfter(self, new_data, prev_node):

        if prev_node is None:
            print "The given previous node must inLinkedList."
            return
        new_node = Node(new_data)
        new_node = prev_node.next
        prev_node.next = new_node

    def InsertEnd(self, new_data):
        new_node = Node(new_data)

        if self.head is None:
            self.head = new_node
            return

        last = self.head
        while (last.next):
            last = last.next
        last.next = new_node

    def PrintList(self):
        temp = self.head
        while(temp):
            print temp.data
            temp = temp.next


if __main__ == '__main__':
    llist = LinkedList()
    llist.InsertEnd(6)
    llist.InsertBegin(7)
    llist.InsertBegin(1)
    llist.InsertEnd(4)
    llist.InsertAfter(llist.head.next, 8)
    print(Created linked list is: ', llist.PrintList())
