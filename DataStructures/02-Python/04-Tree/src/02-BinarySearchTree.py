class BSTNode:
    def __init__(root,data):
        root.left = None
        root.right = None
        root.data = data 

def insertNode(root,node):
    """
    Utility to insert a new node with a given key.
    """
    if root is None:
        root = node
    else:
        if root.data > node.data:
            if root.left == None:
                root.left = node 
            else:
                insertNode(root.left,node)
        else:
            if root.right == None:
                root.right = node 
            else:
                insertNode(root.right, node)

def deleteNode(root, data):
    """
    Delete the node with the given data and return the tree
    """
    if root.data == data:
        if root.right and root.left:
            [psuuc,succ] = findMin(root.right,root)
            if psuuc.left == succ:
                psuuc.left = succ.right
            else:
                psuuc.right = succ.right

            succ.left = root.left
            succ.right = root.right
            return succ
        else:
            if root.left:
                return root.left
            else:
                return root.right
    else:
        if root.data>data:
            if root.left:
                root.left = deleteNode(root.left,data)
        else:
            if root.right:
                root.right = deleteNode(root.right, data)
    return root


def inOrderTraversal(root):
    """
    Utility to do inorder tree traversal

    """
    if not  root:
        return
    inOrderTraversal(root.left)
    print(root.data)
    inOrderTraversal(root.right)

def preOrderTraversal(root):
    """
    Utility to do postordet tree traversal
    """
    if not root:
        return
    print(root.data)
    preOrderTraversal(root.left)
    preOrderTraversal(root.right)



def findMin(root,parent):
    """
    return the minimum node in the current tree and its parent
    we use an ugly trick: the parent node is passed in as an argument
    so that eventually when the leftmost child is reached, the 
    call can return both the parent to the successor and the successor
    """
    if root.left:
        return findMin(root.left, root)
    else:
        return [parent, root]





# Driver program to test the above functions 
# Let us create the following BST 
#      50 
#    /      \ 
#   30     70 
#   / \    / \ 
#  20 40  60 80 

r = BSTNode(50)
insertNode(r,BSTNode(30))
insertNode(r,BSTNode(20))
insertNode(r,BSTNode(40))
insertNode(r,BSTNode(70))
insertNode(r,BSTNode(60))
insertNode(r,BSTNode(80))



inOrderTraversal(r)
