package Modelo;

/**
 * La clase TreeNode es una clase parametrizada en la
 * cual definimos un nodo, el cual posee determinados
 * atributos como left, right e info.
 * 
 * Siendo left y right de tipo TreeNode 
 * 
 * por otro lado info sera de tipo T (x parametro)
 * 
 * @author Freddy Ojeda - Felipe Dueñas
 *
 * @param <T>
 */
public class TreeNode<T> {

	private TreeNode<T> left;
	private TreeNode<T> right;
	private T info;
		
	/**
	 * Este metodo hace referencia al contructor
	 * de un nodo, el cual recibe por parametro
	 * una info de tipo T, para asignarla al nodo.
	 * @param info
	 */
	public TreeNode( T info) {
		left=null;
		right=null;
		this.info = info;
	}
	
	
	/**
	 * @return - Retorna el nodo que se encuntra en la posición izquierda,
	 * valor de tipo TreeNode.
	 */
	public TreeNode<T> getLeft() {
		return left;
	}

	/**
	 * @param left - Recibe por parametro un valor de tipo TreeNode, para asignarlo
	 * al atributo left.
	 */
	public void setLetf(TreeNode<T> left) {
		this.left = left;
	}

	/**
	 * @return - Retorna el nodo que se encuntra en la posición derecha,
	 * valor de tipo TreeNode.
	 */
	public TreeNode<T> getRight() {
		return right;
	}

	/**
	 * @param right - Recibe por parametro un valor de tipo TreeNode, para asignarlo
	 * al atributo right.
	 */
	public void setRight(TreeNode<T> right) {
		this.right = right;
	}

	/**
	 * @return  Retorna la info del Nodo, valor de tipo T (parametrizado)
	 */
	public T getInfo() {
		return info;
	}

	/**
	 * @param info - Recibe un parametro de tipo T el cual sera asignado a la info
	 */
	public void setInfo(T info) {
		this.info = info;
	}
}
