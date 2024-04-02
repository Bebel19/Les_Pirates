package affichage;

import entites.Case;
import entites.Pirate;
import entites.Plateau;
import utils.Arme;
import utils.Couleur;
import utils.PirateNom;

public interface IAffichage {
	/**
	 * @brief Affiche le plateau de jeu.
	 * @param plateau L'objet Plateau repr�sentant l'�tat actuel du jeu � afficher.
	 */
	void afficherPlateau(Plateau plateau);

	/**
	 * @brief Affiche un message � l'utilisateur.
	 * @param message Le message � afficher.
	 */
	void afficherMessage(String message);

	/**
	 * @brief Affiche la position actuelle d'une case et son contenu.
	 * @param positionAfficher Le num�ro de la case � afficher.
	 * @param caseCourante La case � afficher.
	 */
	void afficherPosition(int positionAfficher, Case caseCourante);

	/**
	 * @brief Affiche le gagnant du jeu.
	 * @param pirate Le pirate qui a gagn� le jeu.
	 */
	void afficherGagnant(Pirate pirate);

	/**
	 * @brief Affiche le d�but du tour d'un pirate.
	 * @param pirate Le pirate dont le tour commence.
	 */
	void afficherDebutTour(Pirate pirate);

	/**
	 * @brief Affiche la fin du tour d'un pirate.
	 * @param pirate Le pirate dont le tour se termine.
	 */
	void afficherFinTour(Pirate pirate);

	/**
	 * @brief Affiche un avertissement quand un pirate subit l'effet d'ivresse.
	 * @param valRecul Le nombre de cases que le pirate recule � cause de l'ivresse.
	 */
	void afficherIvresse(int valRecul);

	/**
	 * @brief Affiche un changement d'arme pour un pirate.
	 * @param pirate Le pirate qui change d'arme.
	 * @param nouvelleArme La nouvelle arme obtenue par le pirate.
	 */
	void afficherChangementArme(Pirate pirate, Arme nouvelleArme);

	/**
	 * @brief Demande le nombre de joueurs participant au jeu.
	 * @return Le nombre de joueurs entr� par l'utilisateur.
	 */
	int demanderNombreJoueurs();

	/**
	 * @brief Permet � l'utilisateur de choisir un nom de pirate parmi les options disponibles.
	 * @return Le nom du pirate choisi.
	 */
	PirateNom choisirPirate();

	/**
	 * @brief Permet � l'utilisateur de choisir une couleur parmi les options disponibles.
	 * @return La couleur choisie.
	 */
	Couleur choisirCouleur();

}
