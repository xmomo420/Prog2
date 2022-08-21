
package exemplesMethodesStaticABR;


public class Noeud<T extends Comparable> {
   
   //Variables d'instance
   private T info; //la clé/valeur de ce noeud
   private Noeud<T> gauche; //fils gauche de ce noeud
   private Noeud<T> droite; //fils droit de ce noeud

   /**
    * Cree un nouveau noeud feuille
    *
    * @param element la cle (valeur) qui sera stockee dans le noeud
    */
   public Noeud(T element) {
      info = element;
   }

   /**
    * Cree un nouveau noeud ayant un fils gauche et un fils droit.
    *
    * @param element la cle (valeur) qui sera stockee dans le noeud
    * @param gauche le noeud qui sera fils gauche  de ce noeud
    * @param droite le noeud qui sera le fils droit de ce noeud
    */
   public Noeud(T element, Noeud<T> gauche, Noeud<T> droite) {
      info = element;
      this.gauche = gauche;
      this.droite = droite;
   }

   //-----   Observateurs (getters) -----//
   
   public T info() {
      return info;
   }

   public Noeud<T> gauche() {
      return gauche;
   }

   public Noeud<T> droite() {
      return droite;
   }

   //-----   Modificateurs (setters) -----//
   
   public void modifierInfo(T element) {
      info = element;
   }

   public void modifierGauche(Noeud<T> gauche) {
      this.gauche = gauche;
   }

   public void modifierDroite(Noeud<T> droite) {
      this.droite = droite;
   }
   
}