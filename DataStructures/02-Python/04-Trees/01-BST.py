class Node:
    def __init__(self, data, left=None, right=None):
        """
        Constructor for BST node. [left,data,right]
        """
        self.left = left
        self.data = data
        self.right = right

class BinarySearchTree:
    """
    BST Implementation in recursive manner.
    """

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

    def preorder(self, parent):
        if not parent:
            return
        print(parent.data)
        self.preorder(parent.left)
        self.preorder(parent.right)

    def postorder(self, parent):
        if not parent:
            return 
        self.postorder(parent.left)
        self.postorder(parent.right)
        print(parent.data)
    
    def iter_postorder(self, parent):
        """
        Iterative version of post order traversal.
        """
        
        if parent is None:
            return
        recursive_stack, final_stack = [], []
        recursive_stack.append(parent)

        while recursive_stack:
            current = recursive_stack.pop()
            final_stack.append(current)
            if current.left:
                recursive_stack.append(current.left)
            if current.right:
                recursive_stack.append(current.right)
                
        while final_stack:
            curr = final_stack.pop()
            print(curr.data)

    def search_bst(self, parent, target, mode='recursive'):
        """

        """
        if not parent or parent.data == target:
            return parent
        if mode == 'recursive':
            if target < parent.data:
                return self.search_bst(parent.left, target, mode)
            return self.search_bst(parent.right, target, mode)

    def search_min(self, root):
        """
        """
        if root.left is None:
            return root.data
        return self.search_min(root.left)

    def search_max(self, root):
        """
        """
        if root.right is None:
            return root.data
        return self.search_max(root.right)

    
    def deletion(self, parent, key):
        """
        Case 1: If Node is a leaf node.
        Case 2: If Node has one child.
        Case 2: If Node has two child.
        """
        # If tree is empty
        if parent is None:
            return
        
        if key < parent.data:
            parent.left = self.deletion(parent.left, key)
        elif key > parent.data:
            parent.right = self.deletion(parent.right, key)
        else:
            # If Node.data == key to delete
            if not (parent.left or parent.right):
                parent = None
            elif parent.right:
                parent.data = self.successor(parent)
                parent.right = self.deletion(parent.right, parent.data)
            else:
                parent.data = self.predecessor(parent)
                parent.left = self.deletion(parent.left, parent.data)
        return parent
    
    def successor(self, parent):
        parent = parent.right
        while parent.left:
            parent = parent.left
        return parent.data

    def predecessor(self, parent):
        parent = parent.left
        while parent.right:
            parent = parent.right
        return parent.data



if __name__ == '__main__':
    head = None
    bst_obj = BinarySearchTree()
    for item in [4,5,2,7,1,0,9]:
        head = bst_obj.construct_bst(head, item)

    #bst_obj.preorder(head)
    bst_obj.inorder(head)
    print('\n')
    bst_obj.deletion(head, 5)
    print('\n')
    bst_obj.inorder(head)
    #bst_obj.search_bst(head, 9)
    print('\n')
    # bst_obj.preorder(head)
    print('\n')
    # bst_obj.iter_postorder(head)
