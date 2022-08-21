package utilisationPileFile;

import java.util.EmptyStackException;

/**
 * Une pile (ou LIFO, Larst In, First Out) est une structure de donnees lineaire dans laquelle un seul 
 * element est directement accessible, celui qui est au sommet.  Un nouvel element est ajoute au sommet 
 * de la pile et un element est retire au sommet de la pile.
 * 
 * @author Louise Laforest
 * @version janvier 2006, fevrier 2011, oct 2014(Melanie Lord)
 * @param <T> le type generique des elements dans la pile.
 */

public interface Pile<T> {
  /**
   * Teste si la pile est vide
   * @return true si aucun element false autrement
   */
  public abstract boolean estVide ();

  /**
   * Ajoute un nouvel element au sommet de la pile
   * @param element l'element a empiler
   */
  public abstract void empiler (T element);

  /**
   * Retire l'element au sommet de la pile.  La pile ne doit pas etre vide.
   * @return l'element retire de la pile
   * @throws EmptyStackException si la pile est vide avant l'appel
   */
  public abstract T depiler ();

  /**
   * Retourne l'element au sommet de la pile sans modifier celle-ci.  La pile ne doit pas etre vide.
   * @return l'element au sommet de la pile
   * @throws EmptyStackException si la pile est vide avant l'appel
   */
  public abstract T sommet ();

  /**
   * Retire tous les objets de la pile.
   * Aucun effet si la pile est deja vide
   */
  public abstract void vider ();

  /**
   * Retourne le nombre d'elements presents dans la pile
   * @return le nombre d'elements
   */
  public abstract int taille();

}
