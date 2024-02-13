


## INTRODUCTION AU PROJET : 

-    Il s'agit d'une simulation de plusieurs station de vélos avec un centre de controle qui suprveise ces stations et qui est égalemnt résponsable de la distribution des velos, chaque station notifie le centre de control à chaque fois qu'un depot ou un retrait ait lieu dans chaque station  . 

-  Ce projet a été réalise en Java avec notamment la programmation orientée objet et utilisant les differents design patterns vu en cours , quant aux tests on a uilisé JUnit 5 . 

## HOW TO  : 

- Pour faciliter la tache, on ajouté un Makefile qui permet de faciliter l'exécution des commandes qui vont suivre.

- Il faut d'abord cloner le projet pour l'avoir sur propre pc et pour ce faire on doit taper la commande  suivante :

### Récuperer le depot 

```git clone git@gitlab-etu.fil.univ-lille.fr:tarik.moulouel.etu/moulouel_hachour_coo.git```

- Une fois que le projet a été cloné on se dirige vers la racinde du projet et ensuite  et on effectue les différentes commandes suivantes, Chaque commande est précedée de son utilité .

### Génerer la documentation

```javadoc -sourcepath src -d docs -subpackages bike visitor sharingStrategies state  observer```  

- Vous aurez ensuite accés la documentations qui se trouve dans docs/index.html

### Compiler toutes les sources 

```javac -sourcepath src -d classes src/*.java```

### Lancer la simulation

```	java -classpath classes Main ``` 
 

### Compiler les tests 

```javac -cp classes:junit-platform-console-standalone-1.10.1.jar -d classes  tests/*/*.java```

### Executer les tests 

```java -jar junit-platform-console-standalone-1.10.1.jar -cp classes --scan-class-path```

### Generer l'archive 

```jar cvfe jeu.jar Main -C classes .```


### Executer l'archive  

```java -jar jeu.jar```  



## PRESENTATION D'ELEMENTS DE CODE SAILLANTS 
- Pour mener à bien le projet on a utlisé plusieurs paterns de coneption  : 

1- Decorator : pour pouvoir décorer un vélo c'est à dire pour pouvoir ajouter un panier, un porte bagage aux différents vélos , cela nous permet d'ajouter dynamiquement des caractéristiques à un obejet . 

2- Strategy : pour pouvoir ajouter plus facilement des strategiés de distribution des velos par le centre de control , cela nous permet  de définir plusieurs algorithmes, encapsuler chacun d'eux, et les rendre interchangeables. Il permet à un client de choisir dynamiquement l'algorithme approprié à utiliser , dans notre cas RoundRobin ou Random . 

3- Visitor : pour permettre au voleur ainsi qu'un mécanicien d'interagir avec les vélos, on pouvait aussi creer un autre type de visiteur qui s'appelle Client et qui à son tour intéragit avec les car il peut soit louer un vélo ou le retourner , l'interet de ce design pattern est de définir une nouvelle opération sans changer les classes des éléments sur lesquels on opère. Il est souvent utilisé pour traverser une structure d'objets complexe en l'occurence les vélos dans notre cas .

4- State : pour définir l'etat des vélos , soit ils ont en marche soit ils ne le sont pas, ce state est un attribut de Bike. 

5- Observer : on l'a utilisé pour permettre aux stattion de notifier le centre de controle à chaque changement dans la station ( un retour ou une location de vélo) et par la suite le centre de controle met immédiatement la station à jour en fonction des notifications qu'il a reçu

6- Methode Factory : On l'a utilsié pour tester un appel de méthode, En effet on autilisé la méthode factory pour tester les bikes, le tetst ont été écrit dans la classe astraite ```BikeTest``` et les tests sont éxécutés dans les sous classe qui redéfinissent la méthode factory.

- On a a aussi utilisé un MOCK pour tester un appel de fonction, en effet on testé que chaque appel de la méthode ```notifyObserver()``` declenche un appel à la méthode ```update()```  


- ### A propos du Main  

- Dans notre Main on a fait en sorte de créer 5 stations et 31 vélos avec notamment un vélo qui a un maximum d'utilisation de 2 pour  tester  que le réparateur répare bien le vélo. La simulation commence par une distribution de vélos , et par la suite on a une suite de retrait et de depot de vélos , à chaque retrait ou depot on indique le nombre de vélos restant dans la station , on a égalemnt fait en sorte de respecter les intervalles de temps indiqué dans l'énoncé ,un intervalle de temsp est 1500ms (1,5 secondes) , au bout d'un certain moment , les stations seront toutes vides  ce qui est logique car tout les vélos ont été volés , et donc on aura le DistributeTask qui essaie de distribuer les vélos mais vu qu'on plus de vélos les statios restent vides et donc notre simulation est terminé et il faut appuyer sur ```Ctrl+c``` pour arreter la simulation.

- Les diagrammes UML sont présent dans le fichier UML .

## UML FINAL : 

  ![UML.png](../UML/UML.png)





