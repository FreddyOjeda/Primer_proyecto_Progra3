package Controlador;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JLabel;

import Modelo.BinaryTree;
import Modelo.Word;

public class Management{

	private ArrayList<BinaryTree<Word>> dictionary; 


	public Management(){
		createTrees();
		preloaded();	
		
	}

	public void preloaded() {
		
		dictionary.get(0).addNode(new Word("arbol", "planta", "tree"));
		dictionary.get(1).addNode(new Word("bebe", "niño", "baby"));
		dictionary.get(2).addNode(new Word("carro", "automovil", "car"));
		
	}
	

	// CREACIÓN DE ARBOLES DENTRO DEL ARRAY
	
	private void createTrees(){
		dictionary = new ArrayList<BinaryTree<Word>>();
		for(int i=0; i< 27; i++) {
			dictionary.add(new BinaryTree<Word>(Word.compName));
		}
	}


	// OBTENER INDICE DEL ARRAY
	
	private int getIndex(String name){
		int index;
		String mayusWord = name.toUpperCase();
		if(mayusWord.charAt(0) == 'Ñ') {
			return 26;
		}else {
			index = mayusWord.charAt(0) - 65;
			return index;	
		}
	}


	// AGREGAR PALABRA
	public boolean addWord(String name, String meaning, String translation){

		name = name.toLowerCase();
		meaning = meaning.toLowerCase();
		translation = translation.toLowerCase();

		Word word = new Word(name, meaning, translation);

		if(dictionary.get(getIndex(name)).findNode(word) == null){
			dictionary.get(getIndex(name)).addNode(word);
			return true;
		}
		return false;	
	}


	// BUSCAR PALABRA
	public String[] searchWord(String name){

		name = name.toLowerCase();

		if(dictionary.get(getIndex(name)).findNode(new Word(name, null, null)) != null){

			String[] vectorWord = new String[3];

			vectorWord[0] = dictionary.get(getIndex(name)).findNode(new Word(name, null, null)).getInfo().getName();
			vectorWord[1] = dictionary.get(getIndex(name)).findNode(new Word(name, null, null)).getInfo().getMeaning(); 
			vectorWord[2] = dictionary.get(getIndex(name)).findNode(new Word(name, null, null)).getInfo().getTranslation();

			return vectorWord;
		}
		return null;
	}


	// ACTUALIZAR PALABRA
	public boolean updateWork(String name, String meaning, String translation) {

		Word word = new Word(name, meaning, translation);

		if(dictionary.get(getIndex(name)).findNode(new Word(name, null, null)) != null){

			dictionary.get(getIndex(name)).findNode(new Word(name, null, null)).setInfo(word);

			return true;
		}
		return false;
	}


	//ELIMINAR PALABRA
	public boolean deleteWord(String name){

		if(dictionary.get(getIndex(name)).findNode(new Word(name, null, null))!= null) {
			dictionary.get(getIndex(name)).deleteNode(dictionary.get(getIndex(name)).findNode(new Word(name, null, null)));
			return true;
		}
		return false;
	}


	// LISTAR PALABRAS POR CARACTER

	public String[][] listedByCharacter(char character){

		int index;
		String[][] outputListCharacter;

		if(character == 'Ñ') {
			index = 26;
		}else {
			index = character - 65;
		}

		outputListCharacter = new String[dictionary.get(index).listInorden().size()][3];
	
		for (int i = 0; i < dictionary.get(index).listInorden().size(); i++) {

			outputListCharacter[i][0] = dictionary.get(index).listInorden().get(i).getName();	
			outputListCharacter[i][1] = dictionary.get(index).listInorden().get(i).getMeaning();
			outputListCharacter[i][2] = dictionary.get(index).listInorden().get(i).getTranslation();
		}
		return outputListCharacter;
	}


	// LISTAR PALABRAS DEL ARRAY

	public String[][] listedWords(){

		ArrayList<Word> arrayWords = new ArrayList<Word>();
		
		for(int i = 0; i<27; i++){		
			for(int j=0; j < dictionary.get(i).weightTree(); j++) {
				arrayWords.add(dictionary.get(i).listInorden().get(j));
			}
		}
		
		String[][] outputList = new String[arrayWords.size()][3];
	
			for (int i = 0; i < arrayWords.size(); i++) {
				outputList[i][0] = arrayWords.get(i).getName();	
				outputList[i][1] = arrayWords.get(i).getMeaning();	
				outputList[i][2] = arrayWords.get(i).getTranslation();	
			}
			
		return outputList;
	}

	
	// USUARIOS Y CONTRASEÑAS
	
	public boolean singnUp(String user, String pass) {

		if ((user.equalsIgnoreCase("freddy.ojeda") && pass.equalsIgnoreCase("201911519")) || (user.equalsIgnoreCase("felipe.dueñas") && pass.equalsIgnoreCase("201910985"))) {
			return true;
		}

		return false;
	}

}
