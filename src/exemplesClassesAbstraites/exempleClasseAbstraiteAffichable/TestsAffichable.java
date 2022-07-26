package exemplesClassesAbstraites.exempleClasseAbstraiteAffichable;

public class TestsAffichable {

	public static void main (String[] params) {

		//Tout objet d’une classe concrete derivant 
    //de Affichable pourra etre place dans tab
		Affichable[] tab = new Affichable[5];
		
		tab[0] = new Entier ( 23 );
		tab[1] = new Flottant ( 3 );
		tab[2] = new Point ( 23, 99 );
		tab[3] = new Entier ( 233 );
		tab[4] = new Point ( -22, 9999 );

		for ( int i = 0; i < tab.length; ++i ) {
				tab[i].affiche();
		}
	} 
} 

/*
RESULTATS DE L'EXECUTION DE LA METHODE MAIN

Entier de valeur 23
Flottant de valeur 3.0
Un point de coordonnées (23, 99)
Entier de valeur 233
Un point de coordonnées (-22, 9999)

*/