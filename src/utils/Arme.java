/**
 * @enum Arme
 * @brief Énumération des différentes armes disponibles dans le jeu.
 *
 * Chaque arme est caractérisée par un nom et une force, qui influence l'issue des combats entre pirates.
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
	 * @brief Constructeur privé pour définir une arme.
	 * @param nom   Le nom de l'arme.
	 * @param force La force de l'arme, influençant les duels entre pirates.
	 *
	 *              Initialise une nouvelle arme avec le nom et la force spécifiés.
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
	 * @brief Sélectionne une arme aléatoire parmi les armes disponibles, à
	 *        l'exception du poing.
	 * @return Une arme aléatoirement choisie parmi celles définies, excepté le
	 *         poing.
	 *
	 *         Cette méthode est utile pour attribuer une arme aléatoire à un pirate
	 *         ou à une case arme sur le plateau.
	 */
	public static Arme obtenirArmeAleatoire() {
		List<Arme> armesPossibles = Arrays.stream(values()).filter(arme -> arme != POING).collect(Collectors.toList());
		return armesPossibles.get(random.nextInt(armesPossibles.size()));
	}
}
