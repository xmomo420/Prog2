package listeAvecPosition_implAvecChainage;

import pile_implAvecChainage.MaillonEx;

public class Maillon<T> {

   //-----   Variables d'instance -----
   
   // donnee dans le maillon
   private T info;
   // reference vers le maillon suivant
   private MaillonEx<T> suiv;

   /**
    * Cree un nouveau maillon n'ayant pas de maillon suivant
    *
    * @param o l'information qui sera stockee dans le maillon
    */
   public Maillon(T o) {
      this(o, null);
   }

   /**
    * Cree un nouveau maillon ayant un autre maillon existant comme suivant
    *
    * @param o l'information qui sera stockee dans le maillon
    * @param suivant le maillon qui sera le suivant du maillon cree
    */
   public Maillon(T o, MaillonEx<T> suivant) {
      info = o;
      suiv = suivant;
   }

   //-----   Observateurs (getters) -----
   public T info() {
      return info;
   }

   public MaillonEx<T> suivant() {
      return suiv;
   }

   //-----   Modificateurs (setters) -----
   public void modifierInfo(T o) {
      info = o;
   }

   public void modifierSuivant(MaillonEx<T> suivant) {
      suiv = suivant;
   }
   
   
}
