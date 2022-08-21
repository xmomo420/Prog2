package utilisationPileFile;

import java.util.ArrayList;             // Classe ArrayList
import java.util.EmptyStackException;   // Runtime exception (non controle)

/**
 * La classe PileArrayList implante l'interface Pile.
 * L'implantation est basee sur les services de ArrayList
 * 
 * @author Louise Laforest
 * @version janvier 2006, fevrier 2011
 * @param <T> le type generique des elements contenus dans cette Pile.
 */
public class PileArrayList<T> implements Pile<T> {

  // ------------------------------------------------------
  // Liste contenant les objets de la pile.
  // Le sommet de la pile est a la fin de la liste
  // ------------------------------------------------------

  // liste vide
  private ArrayList<T> lesElements = new ArrayList<>();  

  /**
   * Teste si la pile est vide
   * @return true si aucun element false autrement
   */
  @Override
  public boolean estVide () {
    return lesElements.isEmpty();
  }

  /**
   * Ajoute un nouvel element au sommet de la pile
   * @param element l'element a empiler
   */
  @Override
  public void empiler ( T element ) {
    lesElements.add ( element );  // ajout en fin de liste
  }

  /**
   * Retire l'element au sommet de la pile.  La pile ne doit pas etre vide.
   * @return l'element retire de la pile
   * @throws EmptyStackException si la pile est vide avant l'appel
   */
  @Override
  public T depiler () {
    T reponse = sommet();
    lesElements.remove ( lesElements.size() - 1 );
    return reponse;
  }

  /**
   * Retourne l'element au sommet de la pile sans modifier celle-ci.  La pile ne doit pas etre vide.
   * @return l'element au sommet de la pile
   * @throws EmptyStackException si la pile est vide avant l'appel
   */
  @Override
  public T sommet() {
    T reponse = null;
    if ( estVide () ) {
      throw new EmptyStackException();
    } else { 
      reponse = lesElements.get ( lesElements.size() - 1 ); // l'objet est laisse dans la liste
    }
    return reponse;
  }

  /**
   * Retire tous les objets de la pile.
   * Aucun effet si la pile est deja vide
   */
  @Override
  public void vider() {
    lesElements.clear();    
  }

  /**
   * Retourne le nombre d'elements presents dans la pile
   * @return le nombre d'elements
   */
  @Override
  public int taille() {
    return lesElements.size();
  }
}
