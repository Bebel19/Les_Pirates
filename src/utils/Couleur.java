/**
 * @enum Couleur
 * @brief Énumération des couleurs disponibles pour les pirates et les éléments du jeu.
 *
 * Chaque couleur est associée à un code couleur ANSI pour l'affichage dans le terminal,
 * permettant une distinction visuelle des différents éléments du jeu.
 */
package utils;

public enum Couleur {
	ROUGE("\u001B[31m", "ROUGE"), BLEU("\u001B[34m", "BLEU"), NOIR("\u001B[30m", "NOIR"), VERT("\u001B[32m", "VERT"),
	ROSE("\u001B[35m", "ROSE"), VIOLET("\u001B[35m", "VIOLET"), JAUNE("\u001B[33m", "JAUNE"),
	ORANGE("\u001B[33m", "ORANGE"), BLANC("\u001B[37m", "BLANC"), GRIS("\u001B[90m", "GRIS");

	private final String code;
	private final String nom;

	/**
	 * @brief Constructeur de l'énumération Couleur.
	 * @param code Le code couleur ANSI associé à la couleur.
	 * @param nom  Le nom de la couleur.
	 *
	 *             Initialise une couleur avec son code ANSI pour l'affichage dans
	 *             le terminal et son nom.
	 */

	Couleur(String code, String nom) {
		this.code = code;
		this.nom = nom;
	}

	/**
	 * @brief Retourne le code couleur ANSI de la couleur.
	 * @return Le code couleur ANSI.
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @brief Retourne le nom de la couleur.
	 * @return Le nom de la couleur.
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @brief Retourne une chaîne représentant la couleur, comprenant le code
	 *        couleur ANSI suivi du nom et réinitialisant le style à la fin.
	 * @return Une chaîne de caractères représentant la couleur.
	 */
	@Override
	public String toString() {
		return code + nom + "\u001B[0m";
	}
}
