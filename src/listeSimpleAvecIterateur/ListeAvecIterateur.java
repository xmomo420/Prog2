package listeSimpleAvecIterateur;

import java.util.NoSuchElementException;

/**
 * TDA ListeAvecIterateur, avec position. Les elements de la liste sont numerotes 
 * de 0 a longueur() - 1 inclusivement.
 *
 * @author Louise Laforest, Melanie Lord (ajout de extends Iterable)
 * @version fevrier 2005 (generique : fevrier 2006), fevrier 2011, 
 *          mai 2017 (ajout de Iterable)
 * @param <T> le type des elements dans la liste.
 */
public interface ListeAvecIterateur<T> extends Iterable<T> {  //extends iterable 
                                                              //ajoute la methode 
                                                              //iterator() a cette interface
   
   /**
    * Determine si la liste est vide.
    *
    * @return true si la liste est vide, false autrement
    */
   public abstract boolean estVide();

   /**
    * Determine le nombre d'elements dans la liste.
    *
    * @return le nombre d'elements dans la liste
    */
   public abstract int longueur();

   /**
    * Retourne le premier element de la liste.
    *
    * @return le premier element de la liste
    * @throws NoSuchElementException si liste vide
    */
   public abstract T elementDebut();

   /**
    * Retourne le dernier element de la liste.
    *
    * @return le dernier element de la liste
    * @throws NoSuchElementException si liste vide
    */
   public abstract T elementFin();

   /**
    * Retourne l'element en position pos dans la liste. Le premier element est
    * en position 0.
    * 
    * @param pos la position de l'element recherche
    * @return l'element en position pos dans la liste
    * @throws NoSuchElementException si pos < 0 ou pos >= longueur()
    */
   public abstract T elementPosition(int pos);

   /**
    * Insere l'element en debut de liste.
    *
    * @param element l'element a inserer
    */
   public abstract void insererDebut(T element);

   /**
    * Insere l'element en fin de liste.
    *
    * @param element l'element a inserer
    */
   public abstract void insererFin(T element);

   /**
    * Insere l'element en position pos dans la liste. Si pos = 0, insere au
    * debut; si pos = longueur, insere a la fin
    *
    * @param element l'element a inserer
    * @param pos position ou inserer l'element
    * @throws NoSuchElementException si pos < 0 ou pos > longueur()
    */
   public abstract void insererPosition(T element, int pos);

   /**
    * Retire et retourne l'element au debut de la liste.
    *
    * @return l'element en debut de liste
    * @throws NoSuchElementException si liste vide
    */
   public abstract T retirerDebut();

   /**
    * Retire et retourne l'element en fin de liste.
    *
    * @return l'element en fin de liste
    * @throws NoSuchElementException si liste vide
    */
   public abstract T retirerFin();

   /**
    * Retire et retourne l'element en position pos dans la liste.
    *
    * @param pos la position de l'element recherche
    * @return l'objet en position pos dans la liste
    * @throws NoSuchElementException si pos < 0 ou pos >= longueur()
    */
   public abstract T retirerPosition(int pos);
}
