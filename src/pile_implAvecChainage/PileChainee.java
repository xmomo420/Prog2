package pile_implAvecChainage;

import java.util.EmptyStackException;   // Runtime exception (non controle)

/**
 * La classe PileChainee implante l'interface Pile.
 * L'implantation est faite avec une liste chainee simple de maillons
 * 
 * @author Louise Laforest
 * @version janvier 2006, fevrier 2011
 */
public class PileChainee<T> implements Pile<T> {

  // ------------------------------------------------------
  // Liste contenant les objets de la pile.
  // Le sommet de la pile est au debut de la liste
  // ------------------------------------------------------

  // nombre d'elements de la liste (pile)
  private int nbElem = 0; 
  // premier maillon de la liste
  private MaillonEx<T> debut = null;

  /**
   * Teste si la pile est vide
   * @return true si aucun element false autrement
   */
  @Override
  public boolean estVide () {
    return debut == null;
  }

  /**
   * Ajoute un nouvel element au sommet de la pile
   * @param objet l'element a empiler
   */
  @Override
  public void empiler ( T objet ) {
    ++nbElem;
    debut = new MaillonEx<>( objet, debut );  // ajout en debut de liste
  }

  /**
   * Retire l'element au sommet de la pile.  La pile ne doit pas etre vide.
   * @return l'element retire de la pile
   * @throws EmptyStackException si la pile est vide avant l'appel
   */
  @Override
  public T depiler() {
    T reponse = sommet();
    debut = debut.suivant(); // retrait du premier maillon
    --nbElem;
    return reponse;
  }

  /**
   * Retourne l'element au sommet de la pile sans modifier celle-ci.  La pile ne doit pas etre vide.
   * @return l'element au sommet de la pile
   * @throws EmptyStackException si la pile est vide avant l'appel
   */
  @Override
  public T sommet() {
    T reponse;
    if ( estVide () ) {
      throw new EmptyStackException();
    } else { 
      reponse = debut.info(); // l'element est laisse dans la liste
    }
    return reponse;
  } 

  /**
   * Retire tous les objets de la pile.
   * Aucun effet si la pile est deje vide
   */
  @Override
  public void vider() {
    debut = null; 
    nbElem = 0;
  } 

  /**
   * Retourne le nombre d'elements presents dans la pile
   * @return le nombre d'elements
   */
  @Override
  public int taille() {
    return nbElem;
  }

}
