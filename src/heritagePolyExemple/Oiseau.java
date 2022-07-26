
/**
 * Classe qui modelise un oiseau.
 * @author Melanie Lord
 * @version 2013
 */
package heritagePolyExemple;
public class Oiseau extends AnimalDomestique {
   private String couleurPlumes = "jaune";
   private String chant;
   
   /**
    * Construit un Oiseau avec les attributs 
    * nom : "Anonyme"
    * age : 0 
    * courleurPlumes : "jaune"; 
    * chant : "cui cui cui...".
    */
   public Oiseau () {
      //Appel implicite du constructeur sans arguments de la superclasse
      chant = "cui cui cui...";
   }
   
   /**
    * Construit un Oiseau avec les attributs donnes en parametre.
    */
   public Oiseau (String nom, int age, String couleurPlumes, String chant) {
      super(nom, age);
      this.couleurPlumes = couleurPlumes;
      this.chant = chant;
   }

   /**
    * Affiche le chant de cet Oiseau;
    */
   public void gazouiller () {
      System.out.println(chant);
   }

   /**
    * Redefinition de la methode meDeplacer de la classe
    * AnimalDomestique.
    * Affiche la maniere dont cet Oiseau se
    * deplace.
    */
   public void meDeplacer() {
      System.out.println("Je vole !");
   }
   
   /**
    * Redefinition de la methode toString() de la classe AnimalDomestique.
    * @return une representation sous forme de chaine de caracteres
    * de cet Oiseau.
    */
   public String toString() {
      return 
         //retourne le type, le nom et l'age de cet Oiseau
         super.toString() + "\n" +
              
         //concatene a la chaine retourne par super.toString() les autres infos
         //sur cet Oiseau (couleur plumes et chant).
         "Couleur     : " + this.couleurPlumes + "\n" +
         "Chant       : " + chant;
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
    
        //verif de l'egalite de la couleur des plumes et du chant
        this.couleurPlumes.equals(((Oiseau)autreAnimal).couleurPlumes) &&
        this.chant.equals(((Oiseau)autreAnimal).chant);
   }
   
}
