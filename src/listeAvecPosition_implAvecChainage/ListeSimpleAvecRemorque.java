package listeAvecPosition_implAvecChainage;
/**
 * Implementation du type abstrait Liste (avec position) avec des maillons
 * chaines et avec un maillon remorque. Les elements d'une liste sont numerotes
 * de 0 a longueur() - 1 inclusivement.
 *
 * @author Louise Laforest
 * @version fevrier 2005 (generique : fevrier 2006), fevrier 2011
 *          modifications par Melanie Lord (op diamond, annotations override, 
 *          modification methode insererPosition et modification javadoc, octobre 2014)
 */
import pile_implAvecChainage.MaillonEx;

import java.util.NoSuchElementException;

public class ListeSimpleAvecRemorque<T> implements Liste<T> {

   //premier maillon de la liste
   private MaillonEx<T> debut;
   
   //Nombre d'elements dans la liste
   private int nbElements;

   /**
    * Construit une nouvelle liste vide.
    */
   public ListeSimpleAvecRemorque() {
      // remorque : maillon bidon en fin de liste
      debut = new MaillonEx<>(null);
   }

   /**
    * Determine si la liste est vide.
    *
    * @return true si la liste est vide, false autrement
    */
   @Override
   public boolean estVide() {
      return nbElements == 0;
   }

   /**
    * Determine le nombre d'elements dans la liste.
    *
    * @return le nombre d'elements dans la liste
    */
   @Override
   public int longueur() {
      return nbElements;
   }

   /**
    * Retourne le premier element de la liste.
    *
    * @return le premier element de la liste
    * @throws NoSuchElementException si liste vide
    */
   @Override
   public T elementDebut() {
      return elementPosition(0);
   }

   /**
    * Retourne le dernier element de la liste.
    *
    * @return le dernier element de la liste
    * @throws NoSuchElementException si liste vide
    */
   @Override
   public T elementFin() {
      return elementPosition(nbElements - 1);
   }

   /**
    * Retourne l'element en position pos dans la liste. Le premier element est
    * en position 0.
    *
    * @param pos position de l'element a retourner.
    * @return l'element en position pos dans la liste
    * @throws NoSuchElementException si pos < 0 ou pos >= longueur()
    */
   @Override
   public T elementPosition(int pos) {
      T reponse = null;
      if (pos < 0 || pos > nbElements - 1) {
         throw new NoSuchElementException("position invalide");
      } else {
         MaillonEx<T> p = debut;
         // Avancer pos fois
         for (int i = 0; i < pos; i++) {
            //p est l'element en position i + 1
            p = p.suivant();
         }
         //p contient l'element en position pos
         reponse = p.info();
      }
      return reponse;
   }

   /**
    * Insere l'element en debut de liste.
    *
    * @param element l'element a inserer
    */
   @Override
   public void insererDebut(T element) {
      insererPosition(element, 0);
   }

   /**
    * Insere l'element en fin de liste.
    *
    * @param element l'element a inserer
    */
   @Override
   public void insererFin(T element) {
      insererPosition(element, nbElements);
   }

   /**
    * Insere l'element en position pos dans la liste. Si pos = 0, insere
    * au debut; si pos = longueur, insere a la fin.
    *
    * @param element l'element a inserer
    * @param pos position ou inserer l'element
    * @throws NoSuchElementException si pos < 0 ou pos > longueur()
    */
   @Override
   public void insererPosition(T element, int pos) {
      if (pos < 0 || pos > nbElements) {
         throw new NoSuchElementException("position invalide");
      } else if (pos == 0) {
         // insertion au debut
         debut = new MaillonEx<>(element, debut);
      } else {
         // premier element de la liste
         MaillonEx<T> p = debut;
         
         // avancer pos-1 fois pour se rendre sur le maillon qui precedera 
         // celui qu'on ajoute
         for (int i = 1; i < pos; i++) {
            p = p.suivant();
         }
         // p est l'element en position pos - 1
         // inserer apres p
         p.modifierSuivant(new MaillonEx<>(element, p.suivant()));
      }
      nbElements++;
   }
   
   /**
    * Retire et retourne l'element au debut de la liste.
    *
    * @return l'element en debut de liste
    * @throws NoSuchElementException si liste vide
    */
   @Override
   public T retirerDebut() {
      return retirerPosition(0);
   }

   /**
    * Retire et retourne l'element en fin de liste.
    *
    * @return l'element en fin de liste
    * @throws NoSuchElementException si liste vide
    */
   @Override
   public T retirerFin() {
      return retirerPosition(nbElements - 1);
   }

   /**
    * Retire et retourne l'element en position pos dans la liste.
    *
    * @param pos position ou retirer l'element
    * @return l'objet en position pos dans la liste
    * @throws NoSuchElementException si pos < 0 ou pos >= longueur()
    */
   @Override
   public T retirerPosition(int pos) {
      T element = null;
      if (pos < 0 || pos > nbElements - 1) {
         throw new NoSuchElementException("position invalide");
      } else {
         //se rendre sur le maillon en position pos
         MaillonEx<T> p = debut;
         for (int i = 0; i < pos; i++) {
            p = p.suivant();
         }
         // p est l'element en position pos
         // retirer p
         element = p.info();
         p.modifierInfo(p.suivant().info());
         p.modifierSuivant(p.suivant().suivant());
         nbElements--;
      }
      return element;
   }
   
}
