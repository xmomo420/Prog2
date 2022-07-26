package listeSimpleAvecIterateur;

import pile_implAvecChainage.MaillonEx;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementation de l'interface ListeAvecIterateur avec des maillons
 * chaines. Les elements d'une listeAvecIterateur sont numerotes de 0 a 
 * longueur() - 1 inclusivement.
 *
 * @author Louise Laforest, Melanie Lord (ajout de l'implementation de iterator)
 * @version fevrier 2005 (generique : fevrier 2006), fevrier 2011, mai 2017 (Iterable)
 * @param <T> le type des elements dans cette liste.
 */
public class ListeSimpleAvecIterateur<T> implements ListeAvecIterateur<T> {

   private MaillonEx<T> debut;  // maillon contenant le premier element de la liste
   private int nbElements;    // nombre d'elements dans la liste
   
   
   /****************************************
    * IMPLEMENTATION DE L'INTERFACE ITERABLE
    ****************************************/
   
   /**
    * Retourne un iterateur pour parcourir les elements de cette liste, du 
    * premier au dernier (position 0 a position longueur() - 1).
    * @return 
    */
   @Override
   public Iterator<T> iterator() {
       return new IterateurListeSimple();  //voir classe interne ci-dessous
   }
   
   /**
    * Classe interne qui implemente l'interface Iterator.
    */
   private class IterateurListeSimple implements Iterator<T> {
      
      //Pointe sur l'element qui doit etre retourne par l'appel de la methode
      //next(). 
      private MaillonEx<T> suivant = debut;
      
      //Pointe sur l'element obtenu avec le dernier appel de next(). 
      //Apres un appel de remove(), courant devient null.
      private MaillonEx<T> courant = null;
      
      //Le precedent du courant. Apres un appel de remove(), 
      //il devient le precedent du suivant.
      private MaillonEx<T> precedent = null;
      
      
      /*****************************************************
       * IMPLEMENTATION DES METHODES DE L'INTERFACE ITERATOR
       *****************************************************/

      /**
       * Teste si l'iteration a encore au moins un element. 
       * 
       * @return true si l'iteration a encore au moins un element, false sinon.
       */
      @Override
      public boolean hasNext() {
         return suivant != null;
      }
      
      /**
       * Permet d'obtenir l'element suivant dans l'iteration. 
       * 
       * @return l'element suivant dans l'iteration. 
       * @throws NoSuchElementException si l'iteration n'a plus d'elements.
       */
      @Override
      public T next() {
         if (!hasNext())
            throw new NoSuchElementException();
         
         T elem = suivant.info();
         
         //si courant est null, c'est que la derniere methode executee etait
         //remove (ou c'est le premier next). Dans ce cas, on ne modifie pas  
         //precedent, car il est deja bien positionne.
         if (courant != null) {
            precedent = courant;
         }
         courant = suivant;
         suivant = suivant.suivant();
         
         return elem;
      }

      
      /**
       * Supprime de la collection sous-jacente le dernier element retourne 
       * par cet iterateur (par la methode next()). 
       * 
       * Cette methode peut etre appelee seulement une fois par appel de la 
       * methode next(). 
       * 
       * Le comportement de cette methode n'est pas specifiee si la collection 
       * sous-jacente est modifiee pendant l'iteration, autrement que par l'appel 
       * de cette methode.
       * 
       * @throws IllegalStateException si aucun appel de la methode next() n'a 
       *         encore ete effectuee ou si la methode remove() a deja ete appelee 
       *         apres le dernier appel de la methode next().
       * 
       * NOTE : l'implementation de cette methode est optionnelle (JDK8). 
       * Si elle n'est pas redefinie, elle lance une UnsupportedOperationException 
       * et ne fait rien d'autres.
       */
      @Override
      public void remove() {
         //on ne peut pas supprimer avant de faire appel a next().
         if (courant == null) 
            throw new IllegalStateException();
         
         //supprimer courant en debut de liste
         if (courant == debut) {
            debut = debut.suivant();
            
         //supprimer courant ailleurs qu'en debut de liste
         } else {
            precedent.modifierSuivant(suivant);
         }

         //on ne peut plus appeler cette methode avant d'avoir appele la methode
         //next().
         courant = null; 
         
         //ajuster le nombre d'elements de la liste puiqu'on vient d'en 
         //supprimer un.
         nbElements--;
      }
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
      return elementPosition(nbElements - 1); // dernier maillon
   }

   /**
    * Retourne l'element en position pos dans la liste. Le premier element est
    * en position 0.
    *
    * @param pos la position de l'element recherche.
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
         
      } else if (pos == 0) { // insertion au debut
         debut = new MaillonEx<>(element, debut);
      } else {
         // premier element de la liste
         MaillonEx<T> p = debut;
         
         // avancer pos-1 fois pour se rendre sur le maillon qui precedera 
         // celui qu'on ajoute
         for (int i = 1; i < pos; ++i) {
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
    * @param pos la position de l'element a retirer
    * @return l'objet en position pos dans la liste
    * @throws NoSuchElementException si pos < 0 ou pos >= longueur()
    */
   @Override
   public T retirerPosition(int pos) {
      T reponse = null;
      if (pos < 0 || pos > nbElements - 1) {
         throw new NoSuchElementException("position invalide");
      } else if (pos == 0) {
         // retrait au debut
         reponse = debut.info();
         debut = debut.suivant();
      } else {
         // se rendre au maillon qui precede celui qu'on veut retirer
         // on doit donc avancer pos - 1 fois
         MaillonEx<T> p = debut;
         for (int i = 1; i < pos; i++) {
            p = p.suivant();
         }
         // retirer apres p
         reponse = p.suivant().info();
         p.modifierSuivant(p.suivant().suivant());   
      }
      nbElements--;
      
      return reponse;
   }

   /**
    * Construit une representation sous forme de chaine de caracteres de 
    * cette liste.
    * @return une representation sous forme de chaine de caracteres de cette
    *         liste.
    */
   @Override
   public String toString() {
      String s = "";
      MaillonEx<T> p = debut;
      for (int i = 0; i < longueur(); i++) {
         s = s + p.info() + "  ";
         p = p.suivant();
      }
      return s;
   }
   
}
