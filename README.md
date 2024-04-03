
# La légende Kaïzoku : poudre noire et rhum doré

## Description

"La légende Kaïzoku : poudre noire et rhum doré" est un jeu de plateau interactif développé en Java avec JavaFX. Le jeu invite les joueurs à incarner des pirates naviguant à travers des mers dangereuses à la recherche d'un trésor caché. Chaque joueur doit surmonter des obstacles (cases rhum), ramasser des armes (case arme), combattre des adversaires (duels) et atteindre le trésor à la derniere case (case win).

## Fonctionnalités

- **Jeu Multijoueur** : Supporte 2 à 10 joueurs, chacun choisissant un pirate unique et une couleur distinctive.
- **Plateau Dynamique** : Le plateau de jeu comporte 30 cases, chacune offrant des défis ou des avantages spécifiques (rhums , armes, trésor).
- **Combats de Pirates** : Les joueurs peuvent s'affronter en duel lorsqu'ils se retrouvent sur des cases proches.
- **Sélection de Personnages** : Les joueurs choisissent parmi une variété de pirates.
- **Armes à récupérer** : Les pirates peuvent trouver des armes tels que le pistolet, le mousquet , le sabre ou seulement leurs poings si ils n'ont pas de chance.
- **BETA : Interface Graphique** : Une interface utilisateur riche et intuitive grâce à JavaFX, facilitant l'interaction et l'immersion dans le jeu.

## Prérequis

- Java 11 ou version supérieure.
- JavaFX SDK 11 ou version supérieure.

## Documentation Technique

Une documentation visuelle à été mise à disposition pour comprendr le projet. Elle comporte Les diagrammes de classe par package et de tout le projet. Il y à aussi un diagramme de séquence et un diagramme de séquence détaillé d'un tour de pirate.

Une documentation technique détaillée a été générée avec Doxygen, offrant une vue approfondie de la structure interne du jeu, des classes, des méthodes et de l'architecture globale. Cette documentation est destinée aux développeurs souhaitant contribuer au projet ou comprendre son fonctionnement en détail.

### Accéder à la Documentation

La documentation Doxygen est disponible au format HTML et peut être consultée en ouvrant le fichier `index.html` situé dans le dossier `/HTML` avec votre navigateur web préféré.

### Générer la Documentation

Si vous souhaitez générer la dernière version de la documentation à partir du code source :

1. Assurez-vous que Doxygen est installé sur votre machine. Pour l'installer, visitez [le site officiel de Doxygen](http://www.doxygen.nl/).

2. Naviguez vers le dossier racine du projet et exécutez la commande suivante (assurez-vous que le fichier de configuration `Doxyfile` est présent) :

    ```shell
    doxygen Doxyfile
    ```

    Cette commande générera la documentation dans le dossier spécifié dans votre `Doxyfile`.


## Installation et Exécution

Clonez le dépôt :

```shell
git clone https://github.com/Bebel19/Les_Pirates.git
cd Les_Pirates

## Pour la version console (terminal) : 
java tests.TestStart

## Pour la version javaFX (beta) :
java --module-path /chemin/vers/javafx-sdk-11/lib --add-modules javafx.controls,javafx.fxml -cp bin tests.TestStartJavaFX

## Pour la version javaFX en architecture MVC (Model, Vue, Control) (beta) :
java --module-path /chemin/vers/javafx-sdk-11/lib --add-modules javafx.controls,javafx.fxml -cp bin tests.TestControleurJavaFX
```
