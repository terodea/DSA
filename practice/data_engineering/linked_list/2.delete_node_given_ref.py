from dataclasses import dataclass


class Node:
    def __init__(self, data) -> None:
        self.data = data 
        self.next = None

class LinkedList:
    def __init__(self) -> None:
        self.head = None 
    
    def delete(self, node):
        prev = Node()

        if node == None:
            return
        else:
            while(node.next != None):
                node.data = node.next.data
                prev = node
                node = node.next
            
            prev.next = None
