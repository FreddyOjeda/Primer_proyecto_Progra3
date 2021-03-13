package Modelo;

public class TreeNode<T> {

	
	private TreeNode<T> letf;
	private TreeNode<T> right;
	private T info;
	
	
	public TreeNode( T info) {
		letf=null;
		right=null;
		this.info = info;
	}
	
	
	
	
	public TreeNode<T> getLetf() {
		return letf;
	}



	public void setLetf(TreeNode<T> letf) {
		this.letf = letf;
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
