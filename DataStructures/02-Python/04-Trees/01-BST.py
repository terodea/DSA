class Node:
    def __init__(self, data, left=None, right=None):
        """
        Constructor for BST node. [left,data,right]
        """
        self.left = left
        self.data = data
        self.right = right

class BinarySearchTree:

    def construct_bst(self, parent, data):
        if not parent:
            parent = Node(data)
            return parent

        if data < parent.data:
            parent.left = self.construct_bst(parent.left, data)
        else:
            parent.right = self.construct_bst(parent.right, data)

        return parent

    def inorder(self, parent):
        if not parent:
            return
        self.inorder(parent.left)
        print(parent.data)
        self.inorder(parent.right)

if __name__ == '__main__':
    head = None
    bst_obj = BinarySearchTree()
    for item in [4,5,2,7,1,0,9]:
        head = bst_obj.construct_bst(head, item)

    bst_obj.inorder(head)
