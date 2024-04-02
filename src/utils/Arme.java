/**
 * @enum Arme
 * @brief �num�ration des diff�rentes armes disponibles dans le jeu.
 *
 * Chaque arme est caract�ris�e par un nom et une force, qui influence l'issue des combats entre pirates.
 */
package utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public enum Arme {
	POING("Poing", 1), SABRE("Sabre", 3), PISTOLET("Pistolet", 5), MOUSQUET("Mousquet", 7);

	private final String nom;
	private final int force;
	private static final Random random = new Random();

	/**
	 * @brief Constructeur priv� pour d�finir une arme.
	 * @param nom   Le nom de l'arme.
	 * @param force La force de l'arme, influen�ant les duels entre pirates.
	 *
	 *              Initialise une nouvelle arme avec le nom et la force sp�cifi�s.
	 */

	Arme(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	/**
	 * @brief Retourne le nom de l'arme.
	 * @return Le nom de l'arme.
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @brief Retourne la force de l'arme.
	 * @return La force de l'arme.
	 */
	public int getForce() {
		return force;
	}

	/**
	 * @brief S�lectionne une arme al�atoire parmi les armes disponibles, �
	 *        l'exception du poing.
	 * @return Une arme al�atoirement choisie parmi celles d�finies, except� le
	 *         poing.
	 *
	 *         Cette m�thode est utile pour attribuer une arme al�atoire � un pirate
	 *         ou � une case arme sur le plateau.
	 */
	public static Arme obtenirArmeAleatoire() {
		List<Arme> armesPossibles = Arrays.stream(values()).filter(arme -> arme != POING).collect(Collectors.toList());
		return armesPossibles.get(random.nextInt(armesPossibles.size()));
	}
}
