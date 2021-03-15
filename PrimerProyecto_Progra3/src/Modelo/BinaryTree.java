package Modelo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;

//import javax.swing.TreeNode;

public class BinaryTree<T> {

	private TreeNode<T> root;
	private Comparator<T> comparator;
	private ArrayList<T> arrayList;
	private int aux;
	int cont;
	
	public BinaryTree(Comparator<T> comparator) {
	 this.comparator=comparator;
	 root=null;
	 aux=0;
	}
  
	
	public boolean isEmpty(){
	return root==null;	
	}
	
	
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

	
	// ENLISTAR EN ORDEN 

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
	
	
	
	

	private void heigt(TreeNode<T> node,int level) {
		if(node != null) {
			heigt(node.getLeft(), level+1);
			aux=level>aux?level:aux;
			heigt(node.getRight(), level+1);
		}
	}


	public int heigtNode(TreeNode<T> node) {
		
		heigt(node,0);
		return aux;
	
	}


	public int weightTree() {
		return weigth(root);
	}


	private int weigth(TreeNode<T> node) {
		if(node!=null) {
			return 1+(weigth(node.getLeft())+(weigth(node.getRight())));
		}
		return 0;
	}


	public int levelNode(TreeNode<T>node){
		if(node == root){
			return 0;
		}else{
			int cont=1;
			TreeNode<T> aux=root;
			while(aux.getLeft() != node && aux.getRight() != node){
				cont++;
				aux= comparator.compare(aux.getInfo(), node.getInfo())<0 ? aux.getRight():aux.getLeft();
			}
			return cont;
		}
		
	}


	public boolean isSheet(TreeNode<T>info){
		if (info.getLeft()==null && info.getRight()==null) {
			return true;
		}else {
		return false;
		}
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


	public  ArrayList<T> listPreSort(){
		 arrayList = new ArrayList<>();
		 preSort(root);
		 return arrayList;
	 }
	
	
	private void preSort(TreeNode<T> node){
		if(node != null){
			arrayList.add(node.getInfo());
			preSort(node.getLeft());
			preSort(node.getRight());
		}
	}
	
	public ArrayList<T> listInSort() {
		arrayList = new ArrayList<>();
		inSort(root);
		return arrayList;
	}
	
	private void inSort(TreeNode<T> node) {
		if (node != null) {
			inSort(node.getLeft());
			arrayList.add(node.getInfo());
			inSort(node.getRight());
		}	
	}
	
	public ArrayList<T> listPosort(){
		arrayList = new ArrayList<>();
		posort(root);
		return arrayList;
	}
	
	public void posort (TreeNode<T> node)
	{
		if (node!=null)
		{
			posort(node.getLeft());
			posort(node.getRight());
			arrayList.add(node.getInfo());
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


	public ArrayList<T> listAmplitudeDow(){
		arrayList = new ArrayList<>();
		ArrayDeque<TreeNode<T>> tail = new ArrayDeque<>();
		tail.add(root);
		while(! tail.isEmpty()){
			TreeNode<T>aux= tail.poll();
			if(aux.getLeft() !=null){
				tail.add(aux.getLeft());
			}
			if( aux.getRight() != null){
				tail.add(aux.getRight());
			}
			arrayList.add(aux.getInfo());
		}
		 	
		return arrayList;
		
	}
	
	public ArrayList<T> listAmplitudeTop(){
		arrayList = new ArrayList<>();
		ArrayDeque<TreeNode<T>> tail = new ArrayDeque<>();
		tail.add(root);
		while(! tail.isEmpty()){
			TreeNode<T>aux= tail.poll();
			if(aux.getLeft() !=null){
				tail.addFirst(aux.getLeft());
			}
			if( aux.getRight() != null){
				tail.addFirst(aux.getRight());
			}
			arrayList.add(aux.getInfo());
		}
		 	
		return arrayList;
	}
	
	
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
	
	public boolean isBalanced() {
		int right = heigtNode(root.getRight());
		int left = heigtNode(root.getLeft());
		int rest=0;
		if (right>=left) {
			rest = right-left;
		}else {
			rest = left-right;
		}
		if (rest>=0 && rest<= 1) {
			return true;
		}
		return false;
	}
	
	public int countLeafsLevel(int level) {
		cont = 0;
		counter(level ,root);
		return cont;
	}
	private void counter(int level,TreeNode<T> node){
		if (node!=null) {
			if (levelNode(node)==level && isSheet(node)) {
				cont++;
			}
			if(node != null){
				counter(level, node.getLeft());
				counter(level, node.getRight());
			}
		}
	}
	
	public ArrayList<T> getPath(TreeNode<T> node1, TreeNode<T> node2){
		ArrayList<T> out = new ArrayList<>();
		int level1=levelNode(node1);
		int level2 = levelNode(node2);
		if (level1>level2 || level1==0) {
			if (isRoute(node2, node1)) {
				while(node2!=node1) {
					out.add(node2.getInfo());
					node2=findFather(node2);
				}
				out.add(node1.getInfo());
				return out;
			}
		}else if(level2>level1 || node2==root) {
			System.out.println(isRoute(node1, node2));
			if (isRoute(node1, node2)) {
				while(node1!=node2) {
					out.add(node1.getInfo());
					node1=findFather(node1);
				}
				out.add(node2.getInfo());
				return out;
			}
		}else if(node1==node2){
			out.add(node1.getInfo());
			return out;
		}
		return null;
	}
	
	private boolean isRoute(TreeNode<T> node1,TreeNode<T> node2) {
		boolean answer=false;
		while(node1!=null) {
			if (node1==node2) {
				answer=true;
			}
			node1=findFather(node1);
		}
		return answer;
	}
	
	public TreeNode<T> getGrandFather(TreeNode<T> node){
		if (node!=null && node!=root) {
			TreeNode<T> father =findFather(node);
			if (father!= null && father!= root) {
				if (findFather(father) != null) {
					return findFather(findFather(node));
				}
			}
		}
		return null;
	}
	
}
