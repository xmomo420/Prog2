package laboListesChainees.partie2;

import java.util.NoSuchElementException;

/**
 * Type  liste avec position.
 * Les elements d'une liste sont numerotes de 0 a longueur() - 1 inclusivement.
 *
 * Implementation avec une chaine de maillons.
 *
 * @author  Louise Laforest
 * @version Fevrier 2005
 * @param <T> le type des elements dans la liste
 */
public class ListeSimple<T> implements Liste<T> {

   private Maillon<T> debut;  // maillon du premier element de la liste
   private int nbElements;    // nombre d'elements dans la liste

   /**
    * Teste si la liste est vide.
    *
    * @return true si la liste est vide, false autrement
    */
   public boolean estVide() {
      return nbElements == 0;
   }

   /**
    * Retourne le nombre d'elements dans la liste.
    *
    * @return le nombre d'elements dans la liste
    */
   public int longueur() {
      return nbElements;
   }

   /**
    * Retourne le premier element de la liste.
    *
    * @return le premier element de la liste
    * @throws NoSuchElementException si la liste est vide
    */
   public T elementDebut() {
      return elementPosition(0);
   }

   /**
    * Retourne le dernier element de la liste.
    *
    * @return le dernier element de la liste
    * @throws NoSuchElementException si la liste est vide
    */
   public T elementFin() {
      return elementPosition(nbElements - 1); // dernier maillon
   }

   /**
    * Retourne l'element en position pos dans la liste. Le premier element est
    * en position 0.
    *
    * @return l'element en position pos dans la liste
    * @throws NoSuchElementException si la liste est vide ou si ( pos < 0 || pos
    * > longueur() - 1 )
    */
   public T elementPosition(int pos) {
      if (pos < 0 || pos > nbElements - 1) {
         throw new NoSuchElementException("position invalide");
      } else {
         Maillon<T> p = debut;
         // Avancer pos fois
         for (int i = 0; i < pos; i++) {
            p = p.suivant();
         }
         return p.info();
      }
   }

   /**
    * Insere l'objet element en debut de liste.
    *
    * @param element l'objet a inserer
    */
   public void insererDebut(T element) {
      insererPosition(element, 0);
   }

   /**
    * Insere l'objet element en fin de liste.
    *
    * @param element l'objet a inserer
    */
   public void insererFin(T element) {
      insererPosition(element, nbElements);
   }

   /**
    * Insere l'objet element en position pos dans la liste. Si pos = 0, insere
    * au debut; si pos = longueur, insere a la fin
    *
    * @param element l'objet a inserer
    * @param pos position ou inserer element
    */
   public void insererPosition(T element, int pos) {
      if (pos < 0 || pos > nbElements) {
         throw new NoSuchElementException("position invalide");
      } else if (pos == 0) {
         // insertion au debut
         debut = new Maillon<T>(element, debut);
         nbElements++;
      } else {
         Maillon<T> p = debut;
         // avancer pos-1 fois 
         for (int i = 1; i < pos; i++) {
            p = p.suivant();
         }
         // inserer apres p
         p.modifierSuivant(new Maillon<>(element, p.suivant()));
         nbElements++;
      }
   }

   /**
    * Retire et retourne l'objet au debut de la liste.
    *
    * @return l'objet en debut de liste
    * @throws NoSuchElementException si la liste est vide
    */
   public T retirerDebut() {
      if (estVide()) {
         throw new NoSuchElementException("liste vide");
      } else {
         T element = debut.info();
         debut = debut.suivant();
         nbElements--;
         return element;
      }
   }

   /**
    * Retire et retourne l'objet en fin de liste.
    *
    * @return l'objet en fin de liste
    * @throws NoSuchElementException si la liste est vide
    */
   public T retirerFin() {
      return retirerPosition(nbElements - 1);
   }

   /**
    * Retire et retourne l'objet en position pos dans la liste.
    *
    * @return l'objet en position pos dans la liste
    * @throws NoSuchElementException si la liste est vide ou si ( pos < 0 || pos
    * > longueur() - 1 )
    */
   public T retirerPosition(int pos) {
      if (pos < 0 || pos > nbElements - 1) {
         throw new NoSuchElementException("position invalide");
      } else if (pos == 0) {
         // retrait au debut
         return retirerDebut();
      } else {
         Maillon<T> p = debut;
         for (int i = 1; i < pos; i++) {
            p = p.suivant();
         }
         // retirer apres p
         T element = p.suivant().info();
         p.modifierSuivant(p.suivant().suivant());
         nbElements--;
         return element;
      }
   }

}
