
/**
 * Classe qui modelise un chien.
 * @author Melanie Lord
 * @version 2013
 */
package heritagePolyExemple;
public class Chien extends AnimalDomestique {
   private String typePoil = "ras";
   private String aboiement = "aucun";
   
   /**
    * Construit un Chien avec les attributs 
    * nom : "Bobino"
    * age : 3 
    * typePoil : "brun et doux"; 
    * crie : "Wiiif wif wiiiiiif grrrr !".
    */
   public Chien () {
      super("Bobino", 3);
      aboiement = "Wiiif wif wiiiiiif !";
   }
   
   /**
    * Construit un Chien avec les attributs donnes en parametre.
    */
   public Chien (String nom, int age, String typePoil, String aboiement) {
      super(nom, age);
      this.typePoil = typePoil;
      this.aboiement = aboiement;
   }
   
   /**
    * Affiche le type d'aboiement de ce Chien.
    */
   public void aboyer () {
      System.out.println(aboiement);
   }
   
   /**
    * Redefinition de la methode meDeplacer de la classe 
    * AnimalDomestique.
    * Affiche la maniere dont ce Chien se
    * deplace.
    */
   public void meDeplacer() {
      System.out.println("Je cours !");
   }
   
   /**
    * Redefinition de la methode equals de la classe AnimalDomestique.
    * Deux objets Oiseau sont égaux s'ils ont le meme nom, le meme age 
    * la meme couleur de plumes et le meme chant.
    * @return true si les deux Oiseaux sont égaux, false sinon.
    */
   public boolean equals (Object autreAnimal) {
      return 
        //1. verif que autreAnimal n'est pas null (sinon return faux) 
        //2. verif que les deux objets compares sont de meme classe
        //3. verif que les deux objets compares ont le meme nom et le 
        //   meme age.
        super.equals (autreAnimal) &&
    
        //verif de l'egalite du type de poil et du type d'aboiement
        this.typePoil.equals(((Chien)autreAnimal).typePoil) &&
        this.aboiement.equals(((Chien)autreAnimal).aboiement);
   }
   
   
   
   
}
