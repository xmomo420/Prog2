package exemplesClassesAbstraites.exempleClasseAbstraiteAffichable;

public class Point extends Affichable {
	
  private int x; //coordonnee x
	private int y; //coordonnee y
	
  public Point ( int x, int y ) {
		this.x = x;
		this.y = y;
	}

	//Concretisation de la methode abstraite affiche
	public void affiche () { 
		System.out.println ( "Un point de coordonnées " + 
				"(" + x + ", " + y + ")" );
	}

}
