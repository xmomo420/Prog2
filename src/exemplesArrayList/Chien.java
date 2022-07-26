
public class Chien extends Animal {
   private String aboiement = "aucun";
   
   /**
    * Construit un Chien avec les 
    * attributs : 
    * nom : "Bobino"
    * crie : "Wiiif".
    */
   public Chien () {
      super("Bobino");
      aboiement = "Wiiif";
   }
   
   /**
    * Construit un Chien avec les attributs donnes 
    * en parametres.
    * @param nom le nom de ce Chien.
    *        ANT: ne doit pas etre null.
    * @param aboiement l'aboiement de ce Chien.
    *        Ant: ne doit pas etre null.
    */
   public Chien (String nom, String aboiement) {
      super(nom);
      this.aboiement = aboiement;
   }
   
   /**
    * Redefinition de la methode toString() de la 
    * classe AnimalDomestique.
    * @return une representation sous forme de 
    * chaine de caracteres de ce Chien.
    */
   public String toString() {
      return super.toString() + " " + aboiement;
         
   }
   
   /**
    * Redefinition de la methode equals de la 
    * classe Animal.
    * Deux objets Chien sont égaux s'ils ont le 
    * meme nom et le meme aboiement.
    * @return true si les deux Chien sont égaux, 
    * false sinon.
    */
   public boolean equals (Object autreAnimal) {
      return 
        super.equals (autreAnimal) &&
        //on suppose ici que this.aboiement n'est pas null
        this.aboiement.equals(((Chien)autreAnimal).aboiement);
   }
   
}
