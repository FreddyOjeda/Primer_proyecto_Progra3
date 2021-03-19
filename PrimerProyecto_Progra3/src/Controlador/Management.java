package Controlador;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JLabel;

import Modelo.BinaryTree;
import Modelo.Word;

/**
 * La clase "Management" mediante la implementación
 * de sus diversos metodos permite realizar una gestión
 * adecuada, en la cual existe la posibilidad de agregar,
 * buscar, actualizar o eliminar palabras del diccionario.   
 * 
 * @author Freddy Ojeda -Felipe Dueñas*
 */
public class Management{

	private ArrayList<BinaryTree<Word>> dictionary; 

	/**
	 * El constructor de la clase Management se caracteriza 
	 * por invocar dos metodos, los cuales son createTrees y
	 * preloaded, con los cuales se construye al iniciar la
	 * ejecución del programa.
	 */
	public Management(){
		createTrees();
		preloaded();	

	}

	// CREACIÓN DE ARBOLES DENTRO DEL ARRAY
	/**
	 * El metodo createTrees es el encargado de crear un
	 * arraylist denominado "dictionary", dicho arraylist
	 * se caracteriza por ser un areglo dinamico de arboles
	 * binarios.
	 * 
	 * Por otro lado, la función createTrees agrega 27 arboles
	 * binarios al arraylis "dictionary" con el fin de que
	 * cada uno de los arboles represente a una letra del 
	 * albafeto (A-Z).
	 */
	private void createTrees(){
		dictionary = new ArrayList<BinaryTree<Word>>();
		for(int i=0; i< 27; i++) {
			dictionary.add(new BinaryTree<Word>(Word.compName));
		}
	}

	/**
	 * El metodo preloaded, consiste en la creacion de un 
	 * grupo de palabras precargadas con las cuales el
	 * programa inciara.
	 */
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


	// OBTENER INDICE DEL ARRAY
	/**
	 * La función getIndex se basa en la obtención de un
	 * indice, el cual es la posición del arraylist denominado
	 * dictionary en el cual se encuentran los diveros arboles
	 * binarios que representan cada letra del alfabeto. 
	 * 
	 * @param name - Palabra ingresada por el usuario.
	 * @return - la función getIndex retorna un valor entero, el
	 * cual corresponde al indice del arrayslist dictionary.
	 */
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
	/**
	 * El metodo addWord consiste en añadir una palabra, con su respectiva
	 * definición y traducción al idioma ingles ingresada por el usuario,
	 * cabe mencionar que la palabra sera añadida al diccionario solo si
	 * cumple ciertas condiciones, como por ejemplo:
	 * 1. La palabra ingresada no pueden ser valores numericos
	 * 2. La palabra ingresada no puede ser una que ya exista en el diccionario.
	 * 
	 * @param name - Hace referencia a la palabra ingresada por el usuario.
	 * @param meaning - Hace referencia al signficado de la palabra ingresada por el usuario.
	 * @param translation - Hace referencia a la traducción al idioma ingles de la palabra ingresada.
	 * 
	 * Cabe mencionar que dichos parametros deben ser de tipo String.
	 * 
	 * @return - Esta función retorna un valor booleano, con el cual se puede determinar
	 * si la palabra fue añadida correctamente al dicionario.
	 */
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
	/**
	 * Esta función nos permite buscar una palabra en especifico
	 * en el arrayist de arboles binarios, cabe mencionar que dicha
	 * buqueda sera mediante la palabra, la cual es nuesta llave a
	 * comparar.
	 * 
	 * @param name - Hace referencia a la palabra a buscar ingresada por el usuario, de tipo String.
	 * @return - En caso de que la palabra sea encontrada, el metodo searchWord nos retornara un
	 * vector de tipo String con los atributos de la palabra, por el contrario si no es encontrada
	 * la palabra, el metodo retornara null.  
	 */
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
	/**
	 * El metodo updateWork permite actualizar una palabra existente en el diccionario,
	 * dicho metodo consiste en la busqueda del nodo de la palabra ingresada por el usuario,
	 * una vez encontrado el nodo se le asigna una nueva información, lo cual se traduce a la
	 * actualización de los atributos de la palabra.
	 * 
	 * @param name - Palabra ingresada por el usuario.
	 * @param meaning - Significado de la palabra ingresada por el usuario.
	 * @param translation - traducción de la palabra ingresada por el ususario.
	 * 
	 * Cabe mencionar que dichos parametros deben ser de tipo String.
	 * 
	 * @return - Este metodo retorna un valor booleano, el cual indica si la palabra fue
	 * actualizada correctamente, o por el contrario, si la palabra no existe.  
	 */
	public boolean updateWork(String name, String meaning, String translation) {

		Word word = new Word(name, meaning, translation);

		if(dictionary.get(getIndex(name)).findNode(new Word(name, null, null)) != null){

			dictionary.get(getIndex(name)).findNode(new Word(name, null, null)).setInfo(word);

			return true;
		}
		return false;
	}


	//ELIMINAR PALABRA
	/**
	 * El metodo deleteWork permite eliminar una palabra existente en el diccionario,
	 * dicho metodo consiste en la busqueda del nodo de la palabra ingresada por el usuario,
	 * una vez encontrado el nodo se procede a eliminarlo.
	 * 
	 * @param name - Palabra ingresada por el usuario, de tipo String.
	 * @return - El metodo retorna un valor booleano, el cual indica si la palabra fue
	 * eliminada correctamente, o por el contrario, si la palabra no existe.  
	 */
	public boolean deleteWord(String name){

		if(dictionary.get(getIndex(name)).findNode(new Word(name, null, null))!= null) {
			dictionary.get(getIndex(name)).deleteNode(dictionary.get(getIndex(name)).findNode(new Word(name, null, null)));
			return true;
		}
		return false;
	}


	// LISTAR PALABRAS POR CARACTER

	/**
	 * El metodo listedByCharacter consiste en la busqueda de palabras
	 * las cuales empiezan por un caracter especifico, esto con el fin de
	 * obtener una lista de ellas, por lo cual es necesario la 
	 * implementacion de una matriz de n filas por m columnas de tipo String
	 * con el fin de guardar las palabras en la matriz y al retornarla observar
	 * de manera adecuada el listado de palabras.    
	 * 
	 * @param character - Caracter del cual se espera la lista de palabras, valor de tipo char.
	 * @return - El metodo retorna una matriz de tipo String con el listado de las palabras
	 * clasificadas por caracter.
	 */
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

	/**
	 * El metodo listedWords consiste en la implementación de un arraylist de
	 * tipo Word, en el cual se agregaran todas las palabras del dicionario, esto
	 * se realiza mediante el recorrido de todo el diccionario desde el arbol binario
	 * que representa la letra A, hasta el arbol binario que representa a la letra Z.
	 * Una vez agregadas todas las palabras del diccionario al arraylist auxiliar 
	 * es necesario la implementacion de una matriz de n filas por m columnas de tipo String
	 * con el fin de guardar las palabras del array auxiliar en la matriz y al retornarla
	 * observarde manera adecuada el listado de todas las palabras del diccionario.     
	 *
	 *	  
	 * @return - El metodo retorna una matriz de tipo String con el listado de todas las
	 * palabras del diccionario.
	 */
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
	/**
	 * El metodo singUp valida el ingreso del administrador, comparando
	 * el usuario y contraseña por parametro con el usuario y contraseña
	 * establecido.
	 * 
	 * @param user - Usuario de ingreso, valor de tipo String.
	 * @param pass - Contraseña de ingreso, valor de tipo String.
	 * @return - El metodo retorna un valor booleano indicando si el usuario o contraseña
	 * son correctos.
	 */
	public boolean singnUp(String user, String pass) {

		if ((user.equalsIgnoreCase("freddy.ojeda") && pass.equalsIgnoreCase("201911519")) || (user.equalsIgnoreCase("felipe.dueñas") && pass.equalsIgnoreCase("201910985"))) {
			return true;
		}

		return false;
	}

}
