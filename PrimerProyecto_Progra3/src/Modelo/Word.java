package Modelo;

public class Word {
	private String name, meaning, translation;
	
	public Word(String name,String meaning, String translation) {
		this.name=name;
		this.meaning = meaning;
		this.translation = translation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}
	
	@Override
	public String toString() {
		return name+";"+meaning+";"+translation;
	}
}
