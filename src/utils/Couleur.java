package utils;

public enum Couleur {
	ROUGE("\u001B[31m"), BLEU("\u001B[34m"), NOIR("\u001B[30m"), VERT("\u001B[32m"), ROSE("\u001B[35m"),
	VIOLET("\u001B[35m"), JAUNE("\u001B[33m"), ORANGE("\u001B[33m"), 
																	
	BLANC("\u001B[37m"), GRIS("\u001B[90m");

	private final String code;

	Couleur(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	@Override
	public String toString() {
		return code + name() + "\u001B[0m"; 
	}
}
