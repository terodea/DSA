class Node:
    """
    A base class for single linked list.
    """
    def __init__(self, info, link=None):
        self.info = info
        self.link = link


class SingleLinkedList:
    """
        An implementation of single linked list.
            1. Insert
            2. Delete
            3. Traverse
    """
    def __init__(self):
        self.head= None

    def insert_at_begin(self, info):
        """
            Method to insert Node into a linked list at first.
        """
        new_node = Node(info)
        if self.head != None:
            new_node.link =self.head
            self.head = new_node
        else:
            self.head = new_node

    def insert_at_end(self, info):
        """
            Method to inser Node into a linked list at end.
        """
        new_node = Node(info)
        if self.head != None:
            current = self.head
            while current.link != None:
                current = current.link
            current.link = new_node
        else:
            self.head = new_node

    def delete_node(self, ele):
        """
        ---------->
        2 -> 5 -> 10
        """
        # CASE 1: When List is empty
        if self.head == None:
            print("List is empty")
            return

        # CASE 2: When List is First Element
        if self.head.info == ele:
            temp = self.head
            self.head = temp.link
            temp = None
            return
        # CASE 3: When element is at last and in between
        current = self.head
        while current.link != None:
            if current.link.info == ele:
                temp = current.link
                current.link = temp.link
                temp = None
            current = current.link
        print("DELETION NOT POSSIBLE")

    def display(self):
        # CASE 1: List is empty
        if self.head == None:
            print("List is empty.")
            return
        current = self.head
        while current != None:
            print(current.info)
            current = current.link

    def search(self, ele):
        if self.head == None:
            print("List is empty.")
            return

        current = self.head
        while current != None:
            if current.info == ele:
                print("Eelement is found in list)
                return
            current = current.link
        print("LIST NOT FOUND")
    

if __name__ == "__main__":
    LL = LinkedList()
    LL.insert_at_begining(10)
    LL.insert_at_begining(5)
    LL.display()
    print("*******")
    LL.insert_at_end(20)
    LL.insert_at_end(30)
    LL.display()
    LL.delete_node(40)
    LL.delete_node(20)
    LL.display()
    LL.search(30)