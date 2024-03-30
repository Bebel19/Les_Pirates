package utils;

public enum Couleur {
	ROUGE("rouge","\u001B[31m"), BLEU("bleu","\u001B[34m"), NOIR("noir","\u001B[30m"), VERT("vert","\u001B[32m"), ROSE("rose","\u001B[35m"),
	VIOLET("violet","\u001B[35m"), JAUNE("jaune","\u001B[33m"), ORANGE("orange","\u001B[33m"), 
																	
	BLANC("blanc","\u001B[37m"), GRIS("gris","\u001B[90m");

	private final String code;
	private final String nom;

	Couleur(String nom,String code) {
		this.code = code;
		this.nom = nom;
	}

	public String getCode() {
		return code;
	}

	@Override
	public String toString() {
		return nom; 
	}

	public String getNom() {
		return nom;
	}
}
