
# Les Pirates

## Description

"Les Pirates" est un jeu de plateau interactif développé en Java avec JavaFX. Le jeu invite les joueurs à incarner des pirates naviguant à travers des mers dangereuses à la recherche d'un trésor caché. Chaque joueur doit surmonter des obstacles (cases rhum), ramasser des armes (case arme), combattre des adversaires (duels) et atteindre le trésor à la derniere case (case win).

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

## Installation et Exécution

Clonez le dépôt :

```shell
git clone https://github.com/Bebel19/Les_Pirates.git
cd Les_Pirates

## Pour la version javaFX (beta) :
java --module-path /chemin/vers/javafx-sdk-11/lib --add-modules javafx.controls,javafx.fxml -cp bin tests.TestStartJavaFX

## Pour la version console (terminal) : 
java --module-path /chemin/vers/javafx-sdk-11/lib --add-modules javafx.controls,javafx.fxml -cp bin tests.TestStart
```
