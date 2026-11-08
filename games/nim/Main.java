package games.nim ;
import java.util.Scanner;


public class Main{
	public static void main(String[] args){
Scanner scanner = new java.util.Scanner(System.in);


// INFORMATION DE LA PARTIE

System.out.println("entrer le premier joueur :");
String joueurUn = scanner.next();
System.out.println("le joueur numero 1 est : " + joueurUn);

System.out.println("entrer le deuxieme joueur :");
String joueurDeux = scanner.next();
System.out.println("le joueur numero 2 est : " + joueurDeux);


System.out.println("entrer le nombre d'allumettes total :");
String inputStr = scanner.next();
int totalAllumettes = Integer.parseInt(inputStr);
System.out.println("le nombre saisi est : " + totalAllumettes);

System.out.println("entrer le nombre maximum d'allumettes à enlever :");
int maxAllumettes = scanner.nextInt();
System.out.println("le nombre max d'allumettes à enlevé est : " + maxAllumettes);


// PARTIE
Nim partie = new Nim(totalAllumettes, maxAllumettes, joueurUn, joueurDeux);

while (!partie.isOver()){
	System.out.println(partie.getCurrentPlayer() + ", choisissez un nombre d'allumettes à retirer :");
		int nbreEnleverUn = scanner.nextInt();
		if (partie.isValid(nbreEnleverUn)){
			partie.removeMatches(nbreEnleverUn);
		}
		else {
			System.out.println("coup invalide !!");
		}
	System.out.println(partie.situationToString());		
}
System.out.println("Fin de la partie. Le gagnant est " + partie.getWinner() + " felicitations !!");

scanner.close();
}
}
