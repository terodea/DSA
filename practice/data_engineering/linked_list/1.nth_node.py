from dataclasses import dataclass


class Node:
    def __init__(self, data) -> None:
        self.data = data
        self.node = None

class LinkedList:
    def __init__(self) -> None:
        self.head = None
    
    def push(self, data):
        new_node = Node(data)
        new_node.next = self.head
        self.head = new_node
    
    def getNth(self, index):
        current = self.head
        count = 0

        while current:
            if count == index:
                return current.data
            current = current.next
            count += 1
        
        return -1
