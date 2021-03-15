package Modelo;

public class TreeNode<T> {

	
	private TreeNode<T> left;
	private TreeNode<T> right;
	private T info;
	
	
	public TreeNode( T info) {
		left=null;
		right=null;
		this.info = info;
	}
	
	
	
	
	public TreeNode<T> getLeft() {
		return left;
	}



	public void setLetf(TreeNode<T> left) {
		this.left = left;
	}



	public TreeNode<T> getRight() {
		return right;
	}



	public void setRight(TreeNode<T> right) {
		this.right = right;
	}



	public T getInfo() {
		return info;
	}



	public void setInfo(T info) {
		this.info = info;
	}

}
