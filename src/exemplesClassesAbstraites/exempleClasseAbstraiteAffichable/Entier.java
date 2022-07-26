package exemplesClassesAbstraites.exempleClasseAbstraiteAffichable;


public class Entier extends Affichable {

   private int valeur;

   public Entier(int n) {
      valeur = n;
   }

   //Concretisation de la methode abstraite affiche
   public void affiche() {
      System.out.println("Entier de valeur " + valeur);
   }
}
