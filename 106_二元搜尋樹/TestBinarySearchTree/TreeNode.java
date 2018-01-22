
public class TreeNode
{
	private String name, phone;
	private TreeNode leftChild, rightChild;
	public TreeNode(String name, String phone)
	{
		this.name = name;
		this.phone = phone;
		leftChild = rightChild = null;
	}
	public String getName()
	{
		return this.name;
	}
	public TreeNode getLeftChild()
	{
		return this.leftChild;
	}
	public TreeNode getRightChild()
	{
		return this.rightChild;
	}
	public void setLeftChild(TreeNode left)
	{
		this.leftChild = left;
	}
	public void setRightChild(TreeNode right)
	{
		this.rightChild = right;
	}
	@Override public String toString()
	{
		return name + " \t" + phone;
	}
}
