class BinaryTreeNode:
	'''
		Basic Terminologies-->
		Root       : A node with no parent
		Edge       : A link from parent to child.
		Leaf Node  : A node with no children.
		Siblings   : Children of same parents are called siblings.
		Ancestors  : A node p is an ancestor of node q if there exists a path from root to q and p appears on the path.
		Descendant : Node q is calles a descendant of p.
		Level      : Set of all nodes at a giv en depth are called as level.Ex: Root node is at level zero.
		Depth      : Length of the path from root to the node.
		Height     : Length of the path from that node to the deepest node.
		Height of a tree : Maximum height among all the nodes in the tree.
		Depth of a tree  : Maximum depth among all the nodes in the tree.
		Size             : No of descendants it has including itself.
		Skew tree        : Every node in a tree has only one child(except leaf nodes).
		Left Skew tree   : If every node has only one left child.
		Right skew tree  : If every node has only one right child.
		Binary Tree      : A tree is binary tree if each node has zero child,one child or two children.Empty tree is also a valid binary tree.
	'''
	def __init__(self,data):
		self.data=data
		self.left=None
		self.right=None
	
	def set_data(self,data):
		self.data=data
	
	def get_data(self,data):
		return self.data
	
	def get_left(self):
		return self.left
	
	def get_right(self):
		return self.right


	def preorder_recursive(root,result):
		'''
			1. Visit the root.
			2. Traverse the left subtree in Preorder.
			3. Traverse the right subtree in Preorder.
		'''
		if not root:
			return
		result.append(root.data)
		preorder_recursive(root.left,result)
		preorder_recursive(root.right,result)
	
	def preorder_iterative(root,result):
		if not root:
			return
		stack=[]
		stack.append(root)
		
		while stack:
			node = stack.pop()
			result.append(node.data)
			if node.right: stack.append(node.right)
			if node.left: stack.append(node.left)

	def inorder_recursive(root,result):
		if not root:
			return
		inorder_recursive(root.left,result)
		result.append(root.data)
		inorder_recursive(root.right,result)

	def inorder_iterative(root,result):
		pass

	def postorder_recursive(root,result):
		if not root:
			return
		postorder_recursive(root.left,result)
		postorder_recurisve(root.right,result)
		result.append(root.data)
