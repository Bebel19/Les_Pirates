/**
 * @class Pirate
 * @brief Repr�sente un pirate participant au jeu.
 *
 * Cette classe contient toutes les informations n�cessaires sur un pirate, y compris ses points de vie,
 * son nom, sa couleur, sa position sur le plateau, et son arme actuelle.
 */
package entites;

import utils.Arme;
import utils.Couleur;

public class Pirate {
	private int pv = 5; // points de vie initiaux
	private String nom;
	private Couleur couleur; // Enumération pour les couleurs
	private int position = 1;
	private Arme arme;

	/**
	 * @brief Constructeur de la classe Pirate.
	 * @param nom     Le nom du pirate.
	 * @param couleur La couleur du pirate, utilis�e pour l'affichage.
	 *
	 *                Initialise un nouveau pirate avec un nom et une couleur
	 *                sp�cifiques, une position initiale sur le plateau, et une arme
	 *                par d�faut (les poings).
	 */

	public Pirate(String nom, Couleur couleur) {
		this.nom = nom;
		this.couleur = couleur;
		this.arme = Arme.POING;
	}

	/**
	 * @brief Retourne les points de vie actuels du pirate.
	 * @return Les points de vie (pv) du pirate.
	 */
	public int getPv() {
		return pv;
	}

	/**
	 * @brief Retourne le nom du pirate.
	 * @return Le nom du pirate.
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @brief Retourne la couleur du pirate.
	 * @return La couleur du pirate.
	 */
	public Couleur getCouleur() {
		return couleur;
	}

	/**
	 * @brief Retourne la position actuelle du pirate sur le plateau.
	 * @return La position du pirate.
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * @brief Met � jour la position du pirate sur le plateau.
	 * @param destination La nouvelle position du pirate.
	 */
	public void setPosition(int destination) {
		position = destination;
	}

	/**
	 * @brief Retourne l'arme actuellement �quip�e par le pirate.
	 * @return L'arme du pirate.
	 */
	public Arme getArme() {
		return arme;
	}

	/**
	 * @brief R�duit les points de vie du pirate en fonction des dommages subis.
	 * @param perte Le nombre de points de vie � retirer.
	 *
	 *              Soustrait la perte sp�cifi�e des points de vie du pirate, sans
	 *              tomber en dessous de z�ro.
	 */
	public void perdrePv(int perte) {
		this.pv -= perte;
		if (this.pv < 0) {
			this.pv = 0;
		}
	}

	/**
	 * @brief Met � jour l'arme �quip�e par le pirate.
	 * @param nouvelleArme La nouvelle arme du pirate.
	 */
	public void setArme(Arme nouvelleArme) {
		this.arme = nouvelleArme;
	}

	/**
	 * @brief V�rifie si le pirate est mort.
	 * @return Vrai si les points de vie du pirate sont � z�ro ou moins, faux sinon.
	 */
	public boolean estMort() {
		return this.pv <= 0;
	}

}