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
		
		dictionary.get(0).addNode(new Word("arbol", "planta de gran tamaño", "tree"));
		dictionary.get(1).addNode(new Word("bebe", "niño de pocos años o incluso meses", "baby"));
		dictionary.get(2).addNode(new Word("carro", "medio de transporte de 4 ruedas.", "car"));
		
		dictionary.get(0).addNode(new Word("aro", "pieza u objeto, generalmente de material rígido, en forma de circunferencia.", "ring"));
		dictionary.get(0).addNode(new Word("amigo", "persona muy cercana en quien se puede confiar", "friend"));
		dictionary.get(0).addNode(new Word("ala", "extremidad de una ave", "wing"));
		
		dictionary.get(1).addNode(new Word("ballena", "mamifero acuatico de gran tamayo", "whale"));
		dictionary.get(1).addNode(new Word("baile", "actividad fisica realizada en base a un ritmo", "dance"));
		dictionary.get(1).addNode(new Word("barco", "embarcación con el fondo cóncavo y con cubierta, en especial la de gran o medio tonelaje", "boat"));
		
		dictionary.get(2).addNode(new Word("casa", "lugar donde habitan personas", "house"));
		dictionary.get(2).addNode(new Word("corazon", "organo vital de un ser vivo", "heart"));
		dictionary.get(2).addNode(new Word("casco", "objeto de material muy resistente y forma generalmente semiesférica que se ajusta a la cabeza para protegerla de posibles heridas o golpes.", "helmet"));
		
		
		dictionary.get(3).addNode(new Word("durazno", "fruto de un árbol, comestible, variedad de melocotón", "peach"));
		dictionary.get(3).addNode(new Word("dado", "objeto cubico enumarado cada lado del 1 al 6", "dice"));
		dictionary.get(3).addNode(new Word("dinosaurio", "animal prehistorico.", "dinosaur"));
		
		dictionary.get(4).addNode(new Word("escudo", "objeto de gran resistencia.", "shield"));
		dictionary.get(4).addNode(new Word("equipo", "grupo de personas con un mismo proposito.", "team"));
		dictionary.get(4).addNode(new Word("edificio", "construccion de varios niveles.", "edifice"));
		
		dictionary.get(5).addNode(new Word("foca", "animal semi acuatico", "seal"));
		dictionary.get(5).addNode(new Word("fantasma", "figura irreal, imaginaria o fantástica y normalmente incorpórea, que alguien cree ver.", "ghost"));
		dictionary.get(5).addNode(new Word("flor", "planta que puede ser de varios colores y formas", "flower"));
		
		dictionary.get(6).addNode(new Word("gato", "felino domestico de 4 patas", "cat"));
		dictionary.get(6).addNode(new Word("gorra", "prenda de vestir usada en la cabeza.", "cap"));
		dictionary.get(6).addNode(new Word("gasolina", "combustible para diferentes maquinas.", "gasoline"));
		
		dictionary.get(7).addNode(new Word("hoja", "extremidades de una flor, arbusto o arbol.", "shet"));
		
		dictionary.get(8).addNode(new Word("iglesia", "lugar espiritual.", "church"));
		
		dictionary.get(9).addNode(new Word("jarro", "recipiente.", "pitcher"));
		
		dictionary.get(10).addNode(new Word("karate", "estilo de lucha oriental.", "karate"));
		
		dictionary.get(11).addNode(new Word("lapiz", "sirve para escribir.", "pencil"));
		
		dictionary.get(12).addNode(new Word("moneda", "representacion circular del dinero.", "coin"));
		
		dictionary.get(13).addNode(new Word("nariz", "parte del cuerpo.", "nose"));
		
		dictionary.get(14).addNode(new Word("oso", "animal salvaje.", "bear"));
		
		dictionary.get(15).addNode(new Word("pastel", "alimento con un proceso de creacion", "cake"));
		
		dictionary.get(16).addNode(new Word("quiwi", "fruta agridulce.", "quiwi"));
		
		dictionary.get(17).addNode(new Word("ropa", "lo que las personas llevan puesto.", "clothing"));
		
		dictionary.get(18).addNode(new Word("software", "programa para dispositivos tecnologicos.", "software"));
		
		dictionary.get(19).addNode(new Word("tonelada", "medida de peso.", "ton"));
		
		dictionary.get(20).addNode(new Word("uva", "fruta esferica de tamaño pequeño.", "grape"));
		
		dictionary.get(21).addNode(new Word("vacio", "que no hay nada.", "empty"));
		
		dictionary.get(22).addNode(new Word("whisky", "bebida alcoholica.", "whisky"));
		
		dictionary.get(23).addNode(new Word("xilofono", "instrumento musical.", "xylophone"));
		
		dictionary.get(24).addNode(new Word("yuca", "tuberculo que sirve de alimento.", "yucca"));
		
		dictionary.get(25).addNode(new Word("zapato", "calzado que cubre total o parcialmente el pie sin sobrepasar el tobillo.", "shoe"));
		
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
