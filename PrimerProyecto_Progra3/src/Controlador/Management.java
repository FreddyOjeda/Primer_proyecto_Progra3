package Controlador;

import java.util.ArrayList;

import Modelo.BinaryTree;
import Modelo.Word;

public class Management{

	private ArrayList<BinaryTree<Word>> dictionary; 


	public Management(){
		createTrees();
	}


	private void createTrees(){
		dictionary = new ArrayList<BinaryTree<Word>>();
		for(int i=0; i< 27; i++) {
			dictionary.add(new BinaryTree<Word>(Word.compName));
		}
	}


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

	
	
	public void addWord(String name, String meaning, String translation){

		// PONER EN MINUSCLAS ATRIBUTOS

		dictionary.get(getIndex(name)).addNode(new Word(name, meaning, translation));
	}





	// PROBAR CON INTERFAZ GRAFICA

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


	// PROBAR CON INTERFAZ GRAFICA

	public String[][] listedWords(){

		String[][] outputList = new String[27][3];

		for(int index = 0; index < 27; index++ ){

			for (int i = 0; i < dictionary.get(index).listInorden().size(); i++) {

				outputList[i][0] = dictionary.get(index).listInorden().get(i).getName();	
				outputList[i][1] = dictionary.get(index).listInorden().get(i).getMeaning();
				outputList[i][2] = dictionary.get(index).listInorden().get(i).getTranslation();
			}
		}

		return outputList;
	}

}
