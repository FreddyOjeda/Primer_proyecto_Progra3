package Modelo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;

//import javax.swing.TreeNode;

/**
 * La clase BinaryTree consiste en la  creación y gestión del
 * arbol binario, mediante diversos metodos.
 * 
 * @author Freddy Ojeda - Felipe Dueñas

 * @param <T>
 */
public class BinaryTree<T> {

	private TreeNode<T> root;
	private Comparator<T> comparator;
	private ArrayList<T> arrayList;
	private int aux;
	int cont;

	
	/**
	 * El presente metodo consiste en el constructor de la clase
	 * BinaryTree, el cual resibe por parametro un comparador para 
	 * realizar diferentes funciones dentro del arbol binario, por 
	 * otro lado, el arbol binario se crea con una raiz igual a vacio. 
	 * 
	 * @param comparator
	 */
	public BinaryTree(Comparator<T> comparator) {
		this.comparator=comparator;
		root=null;
		aux=0;
	}

	//Saber si el arbol esta vacio
	/**
	 * La función del metodo isEmpty consiste en determinar si el arbol esta vacio
	 * 
	 * @return - retorna un valor booleano para determinar el estado del arbol binario.
	 */
	public boolean isEmpty(){
		return root==null;	
	}

	// Agregar Nodo
	/**
	 * El metodo addNode recibe como parameto una info de tipo T (parametrizado),
	 * el cual hace referencia al objeto de tipo palabra, para finalmente agregar
	 * al arbol binario.
	 * 
	 * @param info - Parametro de tipo T (parametrizado).
	 */
	public void addNode(T info){
		TreeNode<T>newNode=new TreeNode<T>(info);
		if(isEmpty()){
			root=newNode;
		}else{
			TreeNode<T> aux=root;
			TreeNode<T> ant= null;
			while(aux != null){
				ant=aux;
				aux=comparator.compare(aux.getInfo(), newNode.getInfo())>0 ? aux.getLeft():aux.getRight();

			}
			if(comparator.compare(ant.getInfo(), newNode.getInfo())>0){
				ant.setLetf(newNode);
			}else{
				ant.setRight(newNode);
			}

		}
	}

	// Buscar nodo
	/**
	 * El presente metodo se basa en buscar un nodo en el 
	 * arbol binario.
	 * 
	 * @param info - recibe como parametro un valor de tipo T
	 * @return - En caso de encontrar el nodo lo retornara, por el contrario,
	 * si no se encuentra el nodo retornara null.
	 */
	public TreeNode<T> findNode(T info){
		TreeNode<T> aux = root;
		while( aux != null){
			if(comparator.compare(aux.getInfo(), info)==0){
				return aux;
			}
			aux= comparator.compare(aux.getInfo(), info)<0? aux.getRight() : aux.getLeft();
		}	
		return null;
	}


	
	/**
	 * El metodo listInorden consiste en enlistar el arbol binario
	 * en orden, en este caso especifico retornara las palabra en
	 * orden alfabetico.
	 * 
	 * @return - Retorna un arraylist de tipo T, haciendo referencia a
	 * objetos de tipo Word.
	 */
	public ArrayList<T> listInorden(){
		arrayList= new ArrayList<>();
		inorden(root);
		return arrayList;
	}

	private void inorden(TreeNode<T> root) {
		if(root != null) {
			inorden(root.getLeft());
			arrayList.add(root.getInfo());
			inorden(root.getRight());
		}
	}



	// TAMAÑOD DEL ARBOL
	/**
	 * El metodo weightTree consiste en que retorna el tamaño del arbol
	 * binario, dicho de otra forma, retorna el numero de elementos que
	 * constituyen al arbol
	 * 
	 * @return - Retorna un valor de tipo entero, este haciendo referencia
	 * al tamaño del arbol.
	 */
	public int weightTree() {
		return weigth(root);
	}


	private int weigth(TreeNode<T> node) {
		if(node!=null) {
			return 1+(weigth(node.getLeft())+(weigth(node.getRight())));
		}
		return 0;
	}



	public byte	 gradeNode(TreeNode<T> node) {
		if (node.getRight() != null && node.getLeft() != null) {
			return 2;
		} else if (node.getRight() != null || node.getLeft() != null) {
			return 1;
		} else {
			return 0;
		}
	}


	public TreeNode<T> findFather(TreeNode<T> node){
		if ( node == root ){
			return null;
		}
		TreeNode< T > aux = root;
		while( aux.getLeft() != node && aux.getRight() != node ){
			aux =comparator.compare( aux.getInfo() ,node.getInfo() ) > 0 ? aux.getLeft() : aux.getRight();
		}

		return aux;
	}


	/**
	 * El metodo deleteNode consiste en eliminar un
	 * nodo del arbol binario.
	 * 
	 * @param node - Recibe por parametro el nodo a eliminar, tipo
	 * de valor TreeNode.
	 * @return Retorna la información del nodo eliminado, valor de 
	 * tipo T.
	 */
	public T deleteNode(TreeNode<T> node) {
		T out=node.getInfo();
		switch(gradeNode(node)) {
		case 0:
			deleteSheet(node);
			break;
		case 1:
			deleteNodeWhithSon(node);
			break;
		case 2:
			deleteNodeWhithSons(node);
			break;
		}
		return out;
	}
	public void deleteNodeWhithSons(TreeNode<T> node) {
		TreeNode<T>sustitutte= node.getRight();
		TreeNode<T>fatherSustitute=null;
		while(sustitutte.getLeft()!=null){
			fatherSustitute=sustitutte;
			sustitutte=sustitutte.getLeft();
		}
		if(fatherSustitute !=null){
			fatherSustitute.setLetf(sustitutte.getRight());
			sustitutte.setRight(node.getRight());

		}
		sustitutte.setLetf(node.getLeft());
		TreeNode<T>father=findFather(node);
		if(father ==null){
			root=sustitutte;
		}else if(father.getLeft()==node){
			father.setLetf(sustitutte);

		}else{
			father.setRight(sustitutte);
		}

	}


	public void deleteNodeWhithSon(TreeNode<T> node) {
		if(node==root) {
			root=node.getLeft() !=null ? node.getLeft():node.getRight();
		}else {
			TreeNode<T> father=findFather(node);
			if(father.getLeft()==node) {
				father.setLetf(node.getLeft()!=null?node.getLeft():node.getRight());
			}else {
				father.setRight(node.getLeft()!=null?node.getLeft():node.getRight());
			}
		}

	}

	private void deleteSheet(TreeNode<T> node) {
		if(node==root) {
			root=null;
		}else {
			TreeNode<T> father=findFather(node);
			if(father.getRight()==node) {
				father.setRight(null);
			}else {
				father.setLetf(null);
			}
		}		
	}
}
