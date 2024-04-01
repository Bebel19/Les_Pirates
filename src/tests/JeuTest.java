package tests;

import affichage.IAffichage;
import entites.Case;
import entites.Jeu;
import entites.Pirate;
import utils.Couleur;
import utils.PirateNom;

public class JeuTest {

    public static void main(String[] args) {
        testDeplacerPirate();
        testEngagerDuel();
        testDeplacerPirateVersCaseNormale();
    }

    public static void testDeplacerPirate() {
        // Cr�er un faux objet IAffichage pour les tests
        IAffichage affichageTest = new IAffichage() {
            @Override
            public void afficherPlateau(entites.Plateau plateau) {
                // Ne rien faire dans ce test
            }

            @Override
            public void afficherMessage(String message) {
                // Afficher le message pour le test
                System.out.println("Message affich� : " + message);
            }

            @Override
            public void afficherPosition(int positionAfficher, Case caseCourante) {
                // Afficher la position pour le test
                System.out.println("Position affich�e : " + positionAfficher);
            }

			@Override
			public void afficherGagnant(Pirate pirate) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void afficherDebutTour(Pirate pirate) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void afficherFinTour(Pirate pirate) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public int demanderNombreJoueurs() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public PirateNom choisirPirate() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Couleur choisirCouleur() {
				// TODO Auto-generated method stub
				return null;
			}
        };

        // Cr�er un objet Jeu � tester
        Jeu jeu = new Jeu(affichageTest);

        // Remplacez pirate, valeurDe par les valeurs appropri�es pour votre test
        Pirate pirate = new Pirate("Jack Sparrow", Couleur.ROUGE);

        int valeurDe = 3;
        jeu.deplacerPirate(pirate, valeurDe);
    }

    public static void testEngagerDuel() {
        // Cr�er un faux objet IAffichage pour les tests
        IAffichage affichageTest = new IAffichage() {
            @Override
            public void afficherPlateau(entites.Plateau plateau) {
                // Ne rien faire dans ce test
            }

            @Override
            public void afficherMessage(String message) {
                // Afficher le message pour le test
                System.out.println("Message affich� : " + message);
            }

            @Override
            public void afficherPosition(int positionAfficher, Case caseCourante) {
                // Ne rien faire dans ce test
            }

			@Override
			public void afficherGagnant(Pirate pirate) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void afficherDebutTour(Pirate pirate) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void afficherFinTour(Pirate pirate) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public int demanderNombreJoueurs() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public PirateNom choisirPirate() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Couleur choisirCouleur() {
				// TODO Auto-generated method stub
				return null;
			}
        };

        // Cr�er un objet Jeu � tester
        Jeu jeu = new Jeu(affichageTest);

        // Remplacez pirate1, pirate2 par les valeurs appropri�es pour votre test
        Pirate pirate1 = new Pirate("Barbe Noire", Couleur.ROUGE);
        Pirate pirate2 = new Pirate("Anne Bonny", Couleur.ROUGE);
        jeu.engagerDuel(pirate1, pirate2);
    }
    public static void testDeplacerPirateVersCaseNormale() {
        // Cr�er un faux objet IAffichage pour les tests
        IAffichage affichageTest = new IAffichage() {
            @Override
            public void afficherPlateau(entites.Plateau plateau) {
                // Ne rien faire dans ce test
            }

            @Override
            public void afficherMessage(String message) {
                // Afficher le message pour le test
                System.out.println("Message affich� : " + message);
            }

            @Override
            public void afficherPosition(int positionAfficher, Case caseCourante) {
                // Afficher la position pour le test
                System.out.println("Position affich�e : " + positionAfficher);
            }

			@Override
			public void afficherGagnant(Pirate pirate) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void afficherDebutTour(Pirate pirate) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void afficherFinTour(Pirate pirate) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public int demanderNombreJoueurs() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public PirateNom choisirPirate() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Couleur choisirCouleur() {
				// TODO Auto-generated method stub
				return null;
			}
        };

        // Cr�er un objet Jeu � tester
        Jeu jeu = new Jeu(affichageTest);

        // Cr�er un pirate et le placer sur une case normale
        Pirate pirate = new Pirate("Jack Sparrow", Couleur.ROUGE);
        jeu.deplacerPirate(pirate, 2); // Supposons que le d�placement se fait vers une case normale

        // V�rifier que le pirate est maintenant sur la nouvelle position
        // TODO: Ajoutez ici des assertions pour v�rifier le comportement attendu
    }

}
