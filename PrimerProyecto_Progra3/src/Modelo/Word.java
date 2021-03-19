package Modelo;
import java.util.Comparator;

/**
 * La clase Word consiste en la definic�n de 
 * la palabra que sera ingresada al diccionario,
 * dicha palabra posee determinados atributos como:
 * 1. name - palabra en espa�ol	
 * 2. meaning - significado de la palabra
 * 3. translation - traducci�n de la palabra al idioma ingles
 * 
 * @author Freddy Ojeda -Felipe Due�as
 */
public class Word {

	private String name;
	private String meaning;
	private String translation;

	/**
	 * El metodo comparator sera el que nos permita comparar una llave,
	 * en este caso, la llave es name, que hace referecia a la palabra en
	 * espa�ol.
	 */
	public static Comparator<Word> compName = (w1, w2) -> {
		return w1.getName().compareTo(w2.getName());
	};


	/**
	 * Este metodo hace referencia al constructor de la clase Word
	 * el cual recibe por parametros, la palabra en espa�ol, el
	 * significado y la traducci�n.
	 * 
  	 * @param name - Hace referencia a la palabra ingresada por el usuario.
	 * @param meaning - Hace referencia al signficado de la palabra ingresada por el usuario.
	 * @param translation - Hace referencia a la traducci�n al idioma ingles de la palabra ingresada.
	 * 
	 *Cabe mencionar que dichos parametros son de tipo String.
	 * 	
	 */
	public Word(String name,String meaning, String translation) {
		this.name=name;
		this.meaning = meaning;
		this.translation = translation;
	}

	/**
	 * @return - Retorna la palabra en espa�ol - valor de tipo String
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name - Recibe un parametro de tipo String, el cual sera asignado a "name", es
	 * decir, la palabra en espa�ol.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return - Retorna el significado de la palabra - valor de tipo String
	 */
	public String getMeaning() {
		return meaning;
	}

	/**
	 * @param meaning - Recibe un parametro de tipo String, el cual sera asignado a "meaning", es
	 * decir, el significado de la pa�abra.
	 */
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	/**
	 * @return - Retorna la traducci�n de la palabra - valor de tipo String;
	 */
	public String getTranslation() {
		return translation;
	}

	/**
	 * @param translation - Recibe un parametro de tipo String, el cual sera asignado a "translation", es
	 * decir, la traducci�n de la palabra.
	 */
	public void setTranslation(String translation) {
		this.translation = translation;
	}


	@Override
	public String toString() {
		return name+";"+meaning+";"+translation;
	}

}
