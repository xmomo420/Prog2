package exemplesClassesAbstraites.exempleClasseAbstraiteAffichable;

public class Flottant extends Affichable {
	private float valeur;

	public Flottant ( float x ) {
		valeur = x;
	}

	//Concretisation de la methode abstraite affiche
	public void affiche () { 
		System.out.println ( "Flottant de valeur " + valeur );
	}
}