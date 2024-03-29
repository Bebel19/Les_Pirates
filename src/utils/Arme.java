package utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public enum Arme {
	POING("Poing", 1), SABRE("Sabre", 3), PISTOLET("Pistolet", 5), MOUSQUET("Mousquet", 7);

	private final String nom;
	private final int force;


	Arme(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}


	public String getNom() {
		return nom;
	}


	public int getForce() {
		return force;
	}


	public static Arme obtenirArmeAleatoire() {
		Random random = new Random();
		List<Arme> armesPossibles = Arrays.asList(values());
		armesPossibles = armesPossibles.stream().filter(arme -> arme != POING).toList();
		return armesPossibles.get(random.nextInt(armesPossibles.size()));
	}
}
