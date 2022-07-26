package laboListesChainees.partie2;

public class Maillon<T> {
   
   //-----   Variables d'instance -----
   
   private T info;            //l'information stockee dans ce maillon
   private Maillon<T> suiv;   //Le maillon suivant

   /**
    * Cree un nouveau maillon n'ayant pas de maillon suivant
    *
    * @param info l'information qui sera stockee dans le maillon
    */
   public Maillon(T info) {
      this(info, null);
   }

   /**
    * Cree un nouveau maillon ayant un autre maillon existant comme suivant
    *
    * @param info l'information qui sera stockee dans le maillon
    * @param suivant le maillon qui sera le suivant du maillon cree
    */
   public Maillon(T info, Maillon<T> suivant) {
      this.info = info;
      suiv = suivant;
   }

   //-----   Observateurs (getters) -----
   
   public T info() {
      return info;
   }

   public Maillon<T> suivant() {
      return suiv;
   }

   //-----   Modificateurs (setters) -----
   
   public void modifierInfo(T info) {
      this.info = info;
   }

   public void modifierSuivant(Maillon<T> suivant) {
      suiv = suivant;
   }

} // Maillon
