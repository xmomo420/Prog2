package pile_implAvecChainage;

import java.util.EmptyStackException;

/**
 * Classe pour tester partiellement les operations sur une pile.
 * 
 * @author Louise Laforest
 * @version Fevrier 2010
 */
public class TestPile {

  public static void main (String [] args) {

		// une pile de String pour tester l'implementation PileArrayList
    Pile<String> p = new PileChainee<String>();   

		// une pile de String pour tester l'implementation PileListeChainee
    //Pile<String> p = new PileListeChainee<String>();    

    System.out.println ( "TestPile - tester les operations sur une pile" );
    System.out.println ( "Les resultats attendus sont entre parentheses.\n" );

    System.out.println ( "estVide() = " + p.estVide() + " (true)" );

    try {
      p.sommet();
      System.out.println ( "erreur : sommet() ne leve aucune exception avec une pile vide" );
    } catch ( EmptyStackException e ) {
      System.out.println ( "sommet() leve bien EmptyStackException avec une pile vide" );
    } catch ( Exception e ) {
      System.out.println ( "erreur : sommet() leve une exception autre que EmptyStackException avec une pile vide" );
    }

    try {
      p.depiler();
      System.out.println ( "erreur : depiler() ne leve aucune exception avec une pile vide" );
    } catch ( EmptyStackException e ) {
      System.out.println ( "depiler() leve bien EmptyStackException avec une pile vide" );
    } catch ( Exception e ) {
      System.out.println ( "erreur : depiler() leve une exception autre EmptyStackException que avec une pile vide" );
    }

    System.out.println ( "Empilement de A B C D E F");        
    p.empiler ("A");
    p.empiler ("B");
    p.empiler ("C");
    p.empiler ("D");
    p.empiler ("E");
    p.empiler ("F");

    System.out.println ( "estVide() = " + p.estVide() + " (false)" );
    System.out.println ( "sommet = " + p.sommet() + " (F)" );
    System.out.println ( "taille = " + p.taille() + " (6)" );

    while ( !p.estVide() ) {
      System.out.println ( "element depile : " + p.depiler() + " " );
    }
    System.out.println ( "(F E D C B A)" );

    System.out.println ( "estVide() = " + p.estVide() + " (true)" );

    System.out.println ( "Empilement de X Y Z" ); 
    p.empiler ( "X" );
    p.empiler ( "Y" );
    p.empiler ( "Z" );

    System.out.println();      
    System.out.println ( "Vider la pile" );
    p.vider();

    System.out.println ( "estVide() = " + p.estVide() + " (true)" );

    System.out.println ();     
    System.out.println ( "F i n   n o r m a l e   d u   p r o g r a m m e" );
  }
}