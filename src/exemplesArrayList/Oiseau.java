
public class Oiseau extends Animal {
   private String chant;
   
   /**
    * Construit un Oiseau avec les 
    * attributs :
    * nom : "Anonyme"
    * chant : "cui cui cui...".
    */
   public Oiseau () {
      //Appel implicite du constructeur sans 
      //arguments de la superclasse
      chant = "cui cui cui...";
   }
   
   /**
    * Construit un Oiseau avec les attributs 
    * donnes en parametre.
    * @param nom le nom de cet Oiseau
    *        ANT: ne doit pas etre null.
    * @param chant le chant de cet Oiseau.
    *        ANT: ne doit pas etre null.
    */
   public Oiseau (String nom, String chant) {
      super(nom);
      this.chant = chant;
   }


   /**
    * Redefinition de la methode toString() de 
    * la classe Animale.
    * @return une representation sous forme de 
    * chaine de caracteres
    * de cet Oiseau.
    */
   public String toString() {
      return 
         super.toString() + " " + chant;
   }
   
   /**
    * Redefinition de la methode equals de la 
    * classe Animal.
    * Deux objets Oiseau sont égaux s'ils ont 
    * le meme nom et le meme chant.
    * @return true si les deux Oiseaux sont 
    * égaux, false sinon.
    */
   public boolean equals (Object autreAnimal) {
      return 
        super.equals (autreAnimal) &&
        //on suppose ici que this.chant n'est pas null
        this.chant.equals(((Oiseau)autreAnimal).chant);
   }
   
}
