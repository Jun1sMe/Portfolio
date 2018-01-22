
public class BinaryTree
{
	private TreeNode root;
	public BinaryTree()
	{
		root = null;
	}
	public BinaryTree(String name, String phone)
	{
		root = new TreeNode(name, phone);
	}
	public TreeNode getRoot()
	{
		return this.root;
	}
	// Inorder Traversal
	public void printInorder(TreeNode ptr)
	{
		if(ptr != null)
		{
			printInorder(ptr.getLeftChild());
			System.out.println(ptr);
			printInorder(ptr.getRightChild());
		}
	}
	public void insertNode(String name, String phone)
	{
		TreeNode newNode = new TreeNode(name, phone);
		// there's no data, new one will be root
		if(root == null)	
			root = newNode;
		else
		{
			TreeNode current = root;
			TreeNode parent = null;
			// find out the deeper node and set its child
			while(current != null)
			{
				parent = current;
				if(current.getName().compareToIgnoreCase(name) > 0)
					current = current.getLeftChild();
				else if(current.getName().compareToIgnoreCase(name) < 0)
					current = current.getRightChild();
				else		// value exists
					return;		
			}
			// target insert to left
			if(parent.getName().compareToIgnoreCase(name) > 0)
				parent.setLeftChild(newNode);
			else
				parent.setRightChild(newNode);
		}
	}
	public TreeNode SearchNode(TreeNode ptr, String key)
	{
		TreeNode temp;
		if(ptr != null)
		{
			if(ptr.getName().equals(key))
				return ptr;
			else
			{
				temp = SearchNode(ptr.getLeftChild(), key);
				if(temp != null)		// find out left sub-tree
					return temp;
				temp = SearchNode(ptr.getRightChild(), key);
				if(temp != null)		// find out right sub-tree
					return temp;
			}
		}
		return null;
	}
	public void deleteNode(String name)
	{
		TreeNode current = root,
				parent = null;
		// find the way out
		while(current != null && !current.getName().equalsIgnoreCase(name))
		{
			parent = current;
			// current is smaller -> go right side
			if(current.getName().compareToIgnoreCase(name) < 0)
				current = current.getRightChild();
			else		// bigger -> go left side
				current = current.getLeftChild();
		}
		// no left side
		if(current.getLeftChild() == null)
		{
			// delete root
			if(current == root)
				root = current.getRightChild();
			else		// non-root
			{
				// setting the right sub-tree
				if(parent.getName().compareToIgnoreCase(name) < 0)
					parent.setRightChild(current.getRightChild());
				else
					parent.setLeftChild(current.getRightChild());
			}
		}
		// no right side
		else if(current.getRightChild() == null)
		{
			// delete root
			if(current == root)
				root = current.getLeftChild();
			else		// non-root
			{
				// setting the left sub-tree
				if(parent.getName().compareToIgnoreCase(name) < 0)
					parent.setRightChild(current.getLeftChild());
				else
					parent.setLeftChild(current.getLeftChild());
			}
		}
		// both side
		else
		{
			// setting current position
			TreeNode deeper = current.getLeftChild(),
					deep = current;
			// still value
			// warning: too early assign deeper cause that we lose upper value
			while(deeper.getRightChild() != null)
			{
				deep = deeper;
				deeper = deeper.getRightChild();
			}
			// delete root
			if(current == root)
			{
				// the left sub=tree of the biggest
				if(deep == current)	// no right sub-tree
					deeper.setLeftChild(current.getLeftChild().getLeftChild());
				else
				{
					deep.setRightChild(deeper.getLeftChild());
					deeper.setLeftChild(current.getLeftChild());					
				}
				deeper.setRightChild(current.getRightChild());
				root = deeper;
			}
			else		// non-root
			{
				// the left sub=tree of the biggest
				if(deep == current)	// no right sub-tree
					deeper.setLeftChild(current.getLeftChild().getLeftChild());
				else
				{
					deep.setRightChild(deeper.getLeftChild());
					deeper.setLeftChild(current.getLeftChild());
				}
				deeper.setRightChild(current.getRightChild());
				// setting the new
				if(parent.getName().compareToIgnoreCase(name) < 0)
					parent.setRightChild(deeper);
				else
					parent.setLeftChild(deeper);					
			}
		}
	}
}
